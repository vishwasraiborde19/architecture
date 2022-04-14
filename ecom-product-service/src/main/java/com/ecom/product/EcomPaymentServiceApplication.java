package com.ecom.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@EnableJpaRepositories("com.ecom.product.domain")
//@ComponentScan(basePackages = { "com.ecom.product.domain" })
//@EntityScan("com.ecom.product.domain")
public class EcomPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomPaymentServiceApplication.class, args);
	}
	
	@Bean 
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
