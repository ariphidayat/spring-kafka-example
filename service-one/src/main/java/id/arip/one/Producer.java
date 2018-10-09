package id.arip.one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Arip Hidayat on 10/8/2018.
 */
@Component
public class Producer {
    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    private String topic = "spring";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        log.info("Send message: {} to topic: {}", message, topic);
        kafkaTemplate.send(topic, message);
    }
}
