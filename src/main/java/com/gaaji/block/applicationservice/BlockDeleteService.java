package com.gaaji.block.applicationservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaaji.block.adaptor.AuthServiceClient;
import com.gaaji.block.controller.dto.BlockedUserRequest;
import com.gaaji.block.domain.UserId;
import com.gaaji.block.repository.BlockRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class BlockDeleteService {

	private final BlockRepository blockRepository;
	
	public void deleteBlock(String userId, BlockedUserRequest dto) {
		this.blockRepository.deleteByUserIdAndBlockedUser_BlockedUserId(UserId.of(userId), dto.getBlockedUserId());
	}

}
