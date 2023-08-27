package edu.pja.pskomorowski.sri4jms.receiver;

import edu.pja.pskomorowski.sri4jms.config.JmsConfig;
import edu.pja.pskomorowski.sri4jms.model.BolidStateMessage;
import org.springframework.jms.annotation.JmsListener;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class StateLogger {

    @JmsListener(destination = JmsConfig.MAIN_TOPIC, containerFactory =
            "topicConnectionFactory")
    public void receiveMessage(@Payload BolidStateMessage convertedMessage,
                               @Headers MessageHeaders messageHeaders,
                               Message message) {
        LogBeautiful(convertedMessage);
    }

    private void LogBeautiful(BolidStateMessage convertedMessage) {

        System.out.println("StateLogger received message at " + convertedMessage.getLogTime()+ ", msg: \n"+
                "Oil press - " + convertedMessage.getOilPressure()+"\n"+
                "Engine temp - " + convertedMessage.getEngineTemp()+"\n"+
                "Break fluid temp - " + convertedMessage.getBreakFluidTemp()+"\n"+
                "Tire pressure  - " + convertedMessage.getTirePressure());

    }
}
