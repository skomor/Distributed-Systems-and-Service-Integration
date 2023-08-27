package edu.pja.pskomorowski.sri4jms.receiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pja.pskomorowski.sri4jms.config.JmsConfig;
import edu.pja.pskomorowski.sri4jms.model.BolidStateMessage;
import edu.pja.pskomorowski.sri4jms.model.PartFailureNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class StateMonitor {
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.MAIN_TOPIC, containerFactory =
            "topicConnectionFactory")
    public void receiveMessageAndAct(@Payload BolidStateMessage convertedMessage,
                                     @Headers MessageHeaders messageHeaders,
                                     Message message) {
        System.out.println("StateMonitor received message at " + convertedMessage.getLogTime());
        if (convertedMessage.getBreakFluidTemp() > 200 ||
                convertedMessage.getEngineTemp() > 200 ||
                convertedMessage.getTirePressure() > 2 ||
                convertedMessage.getOilPressure() > 35) {
            var failing = getFailingParts(convertedMessage);
            sendMessageToDriver(convertedMessage.getLogTime(), failing);
            if (convertedMessage.getBreakFluidTemp() > 240 ||
                    convertedMessage.getEngineTemp() > 225 ||
                    convertedMessage.getTirePressure() > 2.5 ||
                    convertedMessage.getOilPressure() > 38) {
                sendMessageToPitStop(convertedMessage.getLogTime(), failing);
            }
        }
    }

    private String getFailingParts(BolidStateMessage convertedMessage) {
        var st = "";
        if (convertedMessage.getBreakFluidTemp() > 200)
            st += "BreakFluidTemp > 200 - " + convertedMessage.getBreakFluidTemp()+ "\n";
        if (convertedMessage.getEngineTemp() > 200)
            st += "EngineTemp > 200 - " + convertedMessage.getEngineTemp()+ "\n";
        if (convertedMessage.getTirePressure() > 2)
            st += "TirePressure > 2 - " + convertedMessage.getTirePressure()+ "\n";
        if (convertedMessage.getOilPressure() > 35)
            st += "OilPressure > 35 - " + convertedMessage.getOilPressure()+ "\n";
        return st;
    }

    public void sendMessageToDriver(LocalDateTime time, String failingPart) {
        PartFailureNotification message = PartFailureNotification.builder()
                .id(BolidStateMessage.nextId())
                .createdAt(time)
                .message("Warning: " + failingPart)
                .build();
        jmsTemplate.convertAndSend(JmsConfig.DRIVER_TOPIC, message);
        System.out.println("StateMonitor - sent message to driver:" + message.getMessage());
    }

    public void sendMessageToPitStop(LocalDateTime time, String failingPart) {
        PartFailureNotification message = PartFailureNotification.builder()
                .id(BolidStateMessage.nextId())
                .createdAt(time)
                .message("Warning: " + failingPart)
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MECHANICS_QUEUE, message);
        System.out.println("StateMonitor - sent message to mechanics:" + message.getMessage());
    }
}
