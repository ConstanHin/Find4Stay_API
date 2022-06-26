package api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import api.uploadFile.StorageService;

@SpringBootApplication
public class Find4StayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Find4StayApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
}
