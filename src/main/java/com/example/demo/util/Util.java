package com.example.demo.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class Util {

    public static <T> Mono<ServerResponse> responseEntityToServerResponse(ResponseEntity<T> responseEntity) {
        ServerResponse.BodyBuilder builder = ServerResponse.status(responseEntity.getStatusCode());
        responseEntity.getHeaders().forEach((key, values) -> builder.header(key, values.toArray(new String[values.size()])));
        return builder.bodyValue(responseEntity.getBody());
    }

}