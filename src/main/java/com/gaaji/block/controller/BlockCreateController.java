package com.gaaji.block.controller;

import com.gaaji.block.applicationservice.BlockCreateService;
import com.gaaji.block.controller.dto.BlockedUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlockCreateController {

    private final BlockCreateService blockCreateService;


    @PostMapping("/block")
    public ResponseEntity<Void> createBlock(@RequestHeader(HttpHeaders.AUTHORIZATION) String userId,
            @RequestBody BlockedUserRequest dto){
        blockCreateService.createBlock(userId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
