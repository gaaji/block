package com.gaaji.block.applicationservice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.UserId;
import com.gaaji.block.repository.BlockRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class BlockRetriveService {

	private final BlockRepository blockRepository;
	
	public List<Block> retirveBlock(String userId) {
		return blockRepository.findAllByUserId(UserId.of(userId));
	}

}
