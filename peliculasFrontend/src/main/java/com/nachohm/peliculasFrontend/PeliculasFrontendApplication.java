package com.nachohm.peliculasFrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
public class PeliculasFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeliculasFrontendApplication.class, args);
	}

	@Bean
	public RestTemplate template() {
		RestTemplate template = new RestTemplate();
		return template;
	}

}