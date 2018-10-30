package id.arip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Arip Hidayat on 18/04/2016.
 */
@EnableKafka
@RestController
public class ServiceThreeController {
    private static final Logger log = LoggerFactory.getLogger(ServiceThreeController.class);

    private static final String TOPIC = "test";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sendMessage(Person person){
        kafkaTemplate.send(TOPIC, person);
        return "You just send a message: " + person.toString();
    }

    @KafkaListener(topics = TOPIC)
    public void subscribe(Person person) {
        log.info("Received a message: {}", person.toString());
    }
}
