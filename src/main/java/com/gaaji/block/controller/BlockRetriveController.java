package com.gaaji.block.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.gaaji.block.applicationservice.BlockDeleteService;
import com.gaaji.block.applicationservice.BlockRetriveService;
import com.gaaji.block.controller.dto.BlockedUserRequest;
import com.gaaji.block.domain.Block;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BlockRetriveController {

	private final BlockRetriveService blockRetriveService;


    @GetMapping("/block")
    public ResponseEntity<List<Block>> retriveBlock(@RequestHeader(HttpHeaders.AUTHORIZATION) String userId){

    	return ResponseEntity.ok(blockRetriveService.retirveBlock(userId));
    }
}