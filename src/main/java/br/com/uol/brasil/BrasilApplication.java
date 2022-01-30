package br.com.uol.brasil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSpringDataWebSupport
@SpringBootApplication
@EnableSwagger2
public class BrasilApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrasilApplication.class, args);
	}

}
