package id.arip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Arip Hidayat on 18/04/2016.
 */
@RestController
public class ServiceThreeController {
    private static final Logger log = LoggerFactory.getLogger(ServiceThreeController.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "Welcome to Service Three!";
    }

    @RequestMapping(value = "/{message}", method = RequestMethod.GET)
    public String sendMessage(@PathVariable("message") String message){
        kafkaTemplate.send("spring", message);
        return "You just send a message: " + message;
    }

    @KafkaListener(topics = "spring")
    public void subscribe(String message) {
        log.info("Received a message: {}", message);
    }
}
