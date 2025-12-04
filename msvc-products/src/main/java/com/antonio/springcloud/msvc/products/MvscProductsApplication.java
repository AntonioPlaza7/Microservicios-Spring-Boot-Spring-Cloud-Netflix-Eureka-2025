package com.antonio.springcloud.msvc.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.antonio.libs.msvc.commons.entities",
"com.antonio.springcloud.msvc.products.entities"})

public class MvscProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvscProductsApplication.class, args);
	}

}
