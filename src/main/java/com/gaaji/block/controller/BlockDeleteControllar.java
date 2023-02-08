package com.gaaji.block.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.gaaji.block.applicationservice.BlockDeleteService;
import com.gaaji.block.controller.dto.BlockedUserRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BlockDeleteControllar {

	private final BlockDeleteService blockDeleteService;


    @DeleteMapping("/block")
    public ResponseEntity<Void> createBlock(@RequestHeader(HttpHeaders.AUTHORIZATION) String userId,
            @RequestBody BlockedUserRequest dto){
    	blockDeleteService.deleteBlock(userId, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
