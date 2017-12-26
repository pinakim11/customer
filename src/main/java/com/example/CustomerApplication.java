package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(CustomerRespository repo) {
	return (evt) -> {
	repo.save(new Customer("Adam","smaith","adam@boot.com"));
	repo.save(new Customer("John","smaith","john@boot.com"));
	repo.save(new Customer("Smith","smaith","smith@boot.com"));
	repo.save(new Customer("Edgar","smaith","edgar@boot.com"));
	repo.save(new Customer("Martin","smaith","martin@boot.com"));
	repo.save(new Customer("Tom","smaith","tom@boot.com"));
	repo.save(new Customer("Sean","smaith","sean@boot.com"));
	};
	}
	
	public Docket registerApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
	
}
