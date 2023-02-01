package com.gaaji.block.applicationservice;

import com.gaaji.block.adaptor.AuthRetrieveResponse;
import com.gaaji.block.adaptor.AuthServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


public class StubAuthServiceClient implements AuthServiceClient {

    public AuthRetrieveResponse retrieveAuth(String authId){
        return new AuthRetrieveResponse(authId, "foo", "bar");
    }

}
