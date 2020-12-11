package com.sajed.main;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.sajed.*")
@EntityScan("com.sajed.*")
@EnableJpaRepositories("com.sajed.*")
@EnableEncryptableProperties
@EnableAutoConfiguration
@SpringBootApplication
public class FamilyApplication {

    public static void main(String[] args) {
        //@TODO load key from a file
        System.setProperty("jasypt.encryptor.password", "1449");
        SpringApplication.run(FamilyApplication.class, args);
    }


}
