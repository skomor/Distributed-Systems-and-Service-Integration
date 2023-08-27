package edu.pja.pskomorowski.sri4jms.receiver;

import edu.pja.pskomorowski.sri4jms.config.JmsConfig;
import edu.pja.pskomorowski.sri4jms.model.BolidStateMessage;
import edu.pja.pskomorowski.sri4jms.model.PartFailureNotification;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Mechanics {
    @JmsListener(destination = JmsConfig.MECHANICS_QUEUE, containerFactory =
            "queueConnectionFactory")
    public void receiveMessage(@Payload PartFailureNotification convertedMessage,
                               @Headers MessageHeaders messageHeaders,
                               Message message) {
        System.out.println("Mechanic got message at " +convertedMessage.getCreatedAt() + "and are preparing pit stop");
    }
}
