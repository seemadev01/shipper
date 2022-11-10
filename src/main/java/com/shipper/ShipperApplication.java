package com.shipper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.shipper")
@EnableSwagger2
@EnableJpaRepositories
@EnableAutoConfiguration()
public class ShipperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShipperApplication.class, args);
	}

}
