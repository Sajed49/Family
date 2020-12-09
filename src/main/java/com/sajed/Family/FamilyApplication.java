package com.sajed.Family;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
@SpringBootApplication
public class FamilyApplication {

	public static void main(String[] args) {
		System.setProperty("jasypt.encryptor.password", "1449");
		SpringApplication.run(FamilyApplication.class, args);
	}


}
