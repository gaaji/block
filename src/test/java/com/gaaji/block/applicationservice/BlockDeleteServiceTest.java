package com.gaaji.block.applicationservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gaaji.block.adaptor.AuthServiceClient;
import com.gaaji.block.controller.dto.BlockedUserRequest;
import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.UserId;
import com.gaaji.block.repository.BlockRepository;

public class BlockDeleteServiceTest {

	
	
	@Test
	public void 삭제서비스() {
	BlockRepository blockRepository = new FakeBlockRepository();
    AuthServiceClient authServiceClient = new StubAuthServiceClient();
    BlockCreateService blockCreateService = new BlockCreateService(blockRepository, authServiceClient);
    blockCreateService.createBlock("userId", new BlockedUserRequest("blockedUserId"));
    
    List<Block> blocks= blockRepository.findAllByUserId(UserId.of("userId"));
    assertThat(blocks.size()).isSameAs(1);
    
    BlockDeleteService blockDeleteService = new BlockDeleteService(blockRepository);
    blockDeleteService.deleteBlock("userId", new BlockedUserRequest("blockedUserId"));
    
    blocks= blockRepository.findAllByUserId(UserId.of("userId"));
    assertThat(blocks.size()).isSameAs(0);
	}
	
}
