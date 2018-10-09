package id.arip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Arip Hidayat on 10/9/2018.
 */
@Component
public class Producer {

    private String topic = "spring";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String message) {
        kafkaTemplate.send(topic, message);
    }
}
