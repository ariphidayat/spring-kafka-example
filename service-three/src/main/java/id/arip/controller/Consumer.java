package id.arip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by Arip Hidayat on 10/9/2018.
 */
@Component
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(ServiceThreeController.class);

    @KafkaListener(topics = "spring")
    public void subscribe(String message) {
        log.info("Received a message: {}", message);
    }
}
