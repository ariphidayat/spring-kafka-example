package id.arip.one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by Arip Hidayat on 10/8/2018.
 */
@Component
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = TopicConst.TOPIC_TEST)
    public void listen(TestObj obj) {
        log.info("Received a message: {}", obj.toString());
    }
}
