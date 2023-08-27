package edu.pja.pskomorowski.sri4jms.receiver;

import edu.pja.pskomorowski.sri4jms.config.JmsConfig;
import edu.pja.pskomorowski.sri4jms.model.PitstopRequestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class Manager {
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.PITSTOPREQUEST_QUEUE)
    public void receiveAndRespond(@Payload PitstopRequestMessage convertedMessage,
                                  @Headers MessageHeaders headers,
                                  Message message) throws JMSException {
        var doAllow = Math.random() < 0.5;

        System.out.println("Manager received message: " + convertedMessage);
        Destination replyTo = message.getJMSReplyTo();
        System.out.println("Manager decided to:" + (doAllow ? "allow" : "dont allow"));

        PitstopRequestMessage msg = PitstopRequestMessage.builder()
                .id(PitstopRequestMessage.nextId())
                .createdAt(LocalDateTime.now())
                .message(convertedMessage.getMessage())
                .isAccepted(doAllow)
                .build();
        jmsTemplate.convertAndSend(replyTo, msg);
    }
}
