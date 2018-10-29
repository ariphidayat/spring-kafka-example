package id.arip.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServiceOneApplication {

	@Autowired
	private Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class, args);
	}

	@GetMapping("/")
	public String test(TestObj obj){
		producer.send(obj);
		return "You just send a message: " + obj.toString();
	}
}
