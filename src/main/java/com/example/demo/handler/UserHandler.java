package com.example.demo.handler;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;

import com.example.demo.config.CustomerClient;
import com.example.demo.util.Util;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.openapitools.delphi.client.api.StreamApi;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserHandler {
	
	@Autowired
	private CustomerClient customerClient;
    /**
     * GET ALL Users
     */
    public Mono<ServerResponse> getAll(ServerRequest request) {
        // fetch all customers from repository
        return customerClient.streamGet(request.exchange())
                .flatMap(Util::responseEntityToServerResponse);
    }
}