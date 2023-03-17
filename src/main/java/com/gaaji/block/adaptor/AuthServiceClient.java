package com.gaaji.block.adaptor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("auth-service")
public interface AuthServiceClient {

    @GetMapping("/auth/{authId}")
    AuthRetrieveResponse retrieveAuth(@PathVariable("authId") String authId);

}
