package com.roms;

import java.io.IOException;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;







 

@SpringBootApplication
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@EnableCaching
public class AuthenticationMicroserviceApplication {
	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(
				AuthenticationMicroserviceApplication.class, args);
//		
//		ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
//		System.out.println(consumerControllerClient);
//		consumerControllerClient.getEmployee();
//		
	}
	
//	@Bean
//	public  ConsumerControllerClient  consumerControllerClient()
//	{
//		return  new ConsumerControllerClient();
//	}
	
	@Bean
	public  RestTemplate  restTemplate()
	{
		return  new RestTemplate();
	}
}