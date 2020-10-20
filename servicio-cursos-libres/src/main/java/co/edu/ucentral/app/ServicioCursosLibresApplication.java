package co.edu.ucentral.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServicioCursosLibresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioCursosLibresApplication.class, args);
	}

}
