package co.edu.ucentral.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServicioEstudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioEstudiantesApplication.class, args);
	}

}
