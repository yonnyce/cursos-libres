package co.edu.ucentral.app.serviciosecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ServicioSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioSecurityApplication.class, args);
	}

}
