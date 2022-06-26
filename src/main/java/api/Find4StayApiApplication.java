package api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import api.uploadFile.StorageProperties;
import api.uploadFile.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
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
