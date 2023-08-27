package edu.pja.pskomorowski.sri4jms.receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pja.pskomorowski.sri4jms.config.JmsConfig;
import edu.pja.pskomorowski.sri4jms.model.PartFailureNotification;
import edu.pja.pskomorowski.sri4jms.model.PitstopRequestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class Driver {
    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @JmsListener(destination = JmsConfig.DRIVER_TOPIC)
    public void receive(@Payload PartFailureNotification convertedMessage,
                        @Headers MessageHeaders messageHeaders,
                        Message message) throws JMSException {
        System.out.println("Driver received message about failure of: " + convertedMessage.getMessage());
    }

    @Scheduled(fixedRate = 18000)
    public void sendAndReceive() throws JMSException, JsonProcessingException {
        var doSend = Math.random() < 0.5;
        if (!doSend)//to add more randomness
            return;
        PitstopRequestMessage message = PitstopRequestMessage.builder()
                .id(PitstopRequestMessage.nextId())
                .createdAt(LocalDateTime.now())
                .message("Pit stop requested")
                .build();
        System.out.println("Driver is sending request for pitstop");

        TextMessage responseMessage = (TextMessage) jmsTemplate.sendAndReceive(
                JmsConfig.PITSTOPREQUEST_QUEUE, new MessageCreator() {
                    @Override
                    public javax.jms.Message createMessage(Session session) throws JMSException {
                        TextMessage plainMessage = session.createTextMessage();
                        try {
                            plainMessage.setText(objectMapper.writeValueAsString(message));
                            plainMessage.setStringProperty("_type",
                                    PitstopRequestMessage.class.getName());
                            return plainMessage;
                        } catch (JsonProcessingException e) {
                            throw new JMSException("conversion to json failed: " +
                                    e.getMessage());
                        }
                    }
                });
        String responseText = responseMessage.getText();
        PitstopRequestMessage responseConverted = objectMapper.readValue(responseText,
                PitstopRequestMessage.class);
        System.out.println("Driver knows that his request was: " + (responseConverted.getIsAccepted()? "Accepted" : " not accpeted"));

    }
}
