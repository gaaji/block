package com.gaaji.block.applicationservice;

import com.gaaji.block.adaptor.AuthRetrieveResponse;
import com.gaaji.block.adaptor.AuthServiceClient;
import com.gaaji.block.controller.dto.BlockedUserRequest;
import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.BlockId;
import com.gaaji.block.domain.BlockedUser;
import com.gaaji.block.domain.UserId;
import com.gaaji.block.exception.SelfBlockException;
import com.gaaji.block.repository.BlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class BlockCreateService {

    private final BlockRepository blockRepository;
    private final AuthServiceClient authServiceClient;

    public void createBlock(String userId, BlockedUserRequest dto) {
    	
    	if(userId.equals(dto.getBlockedUserId())) {
    		throw new SelfBlockException();
    	}

        // AuthService에서 정보 조회
        AuthRetrieveResponse response = authServiceClient.retrieveAuth(
                dto.getBlockedUserId());

        
        // BlockEntity만들고 저장하기
        blockRepository.save(Block.of(BlockId.of(blockRepository.nextId()), UserId.of(userId),
                BlockedUser.of(dto.getBlockedUserId(), response.getNickname(),
                        response.getPictureUrl())));
    }
}
