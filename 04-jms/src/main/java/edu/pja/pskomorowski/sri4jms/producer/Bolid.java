package edu.pja.pskomorowski.sri4jms.producer;

import edu.pja.pskomorowski.sri4jms.config.JmsConfig;
import edu.pja.pskomorowski.sri4jms.model.BolidStateMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class Bolid {
    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 15000)
    public void sendCurrState() {
        BolidStateMessage message = BolidStateMessage.builder()
                .id(BolidStateMessage.nextId())
                .logTime(LocalDateTime.now())
                .engineTemp(getRandomNumber(100,  250))
                .breakFluidTemp(getRandomNumber(120,  250))
                .oilPressure(getRandomDouble(20,  40))
                .tirePressure(getRandomDouble(1,  3))
                .build();
        jmsTemplate.convertAndSend(JmsConfig.MAIN_TOPIC, message);
        System.out.println("Bolid - sent message:" + message);
    }
    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    private static double  getRandomDouble(int min, int max) {
        return ((Math.random() * (max - min)) + min);
    }
}
