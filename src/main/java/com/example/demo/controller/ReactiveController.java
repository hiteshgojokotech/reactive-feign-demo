package com.example.demo.controller;

import org.openapitools.delphi.client.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import com.example.demo.config.CustomerClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveController {
	
	@Autowired
	private CustomerClient customerClient;
	
	@GetMapping("/api/data")
	public Mono<ResponseEntity<Flux<Customer>>> getCustomer(ServerWebExchange exchanges){
		 customerClient.streamGet(exchanges)
				.subscribe(data -> {
					System.out.println(data.getBody()); 
				});
		return customerClient.streamGet(exchanges);
	}
}
