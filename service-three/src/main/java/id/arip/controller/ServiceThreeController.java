package id.arip.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Arip Hidayat on 18/04/2016.
 */
@RestController
public class ServiceThreeController {
    private static final Logger logger = LoggerFactory.getLogger(ServiceThreeController.class);

    @Autowired
    private Producer producer;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUsers() {
        return "Welcome to Service Three!";
    }

    @RequestMapping(value = "/{message}", method = RequestMethod.GET)
    public String test(@PathVariable("message") String message){
        producer.send(message);
        return "You just send a message: " + message;
    }
}
