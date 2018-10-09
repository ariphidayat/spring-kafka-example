package id.arip.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServiceOneApplication {

	@Autowired
	private Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class, args);
	}

	@GetMapping("/{message}")
	public String test(@PathVariable("message") String message){
		producer.send(message);
		return "You just send a message: " + message;
	}
}
