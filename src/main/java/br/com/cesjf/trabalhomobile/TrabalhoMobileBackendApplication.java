package br.com.cesjf.trabalhomobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TrabalhoMobileBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoMobileBackendApplication.class, args);
	}

}
