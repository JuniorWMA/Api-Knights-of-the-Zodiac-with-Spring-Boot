package com.estudos.cdz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
	title = "API REST Knights of the Zodiac",
	description = "API Rest to study and pratice my code",
	version = "1.0",
	contact = @Contact(
		name = "Wellisson Junior",
		email = "junior.wmoreira@gmail.com",
		url = "https://github.com/JuniorWMA"
	)
))
public class CdzApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdzApplication.class, args);
	}

}
