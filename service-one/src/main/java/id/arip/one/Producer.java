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

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(TestObj obj) {
        kafkaTemplate.send(TopicConst.TOPIC_TEST, obj);
        log.info("#{} : {}", TopicConst.TOPIC_TEST, obj.toString());
    }
}
