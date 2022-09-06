package com.example.demo.config;

import org.openapitools.delphi.client.api.StreamApi;

import reactivefeign.spring.config.ReactiveFeignClient;

@ReactiveFeignClient(name="customerClient", url="localhost:9191/customers")
public interface CustomerClient extends StreamApi{

}
