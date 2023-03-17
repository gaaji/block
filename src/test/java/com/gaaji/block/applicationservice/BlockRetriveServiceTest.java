package com.gaaji.block.applicationservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.gaaji.block.adaptor.AuthServiceClient;
import com.gaaji.block.controller.dto.BlockedUserRequest;
import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.UserId;
import com.gaaji.block.repository.BlockRepository;

public class BlockRetriveServiceTest {

	@Test
    void 정상_생성() throws Exception{
        BlockRepository blockRepository = new FakeBlockRepository();
        AuthServiceClient authServiceClient = new StubAuthServiceClient();
        BlockCreateService blockCreateService = new BlockCreateService(blockRepository, authServiceClient);

        blockCreateService.createBlock("userId", new BlockedUserRequest("blockedUserId"));

        
        BlockRetriveService blockRetriveService = new BlockRetriveService(blockRepository);
        List<Block> blocks= blockRetriveService.retirveBlock("userId");

        
        
        assertThat(blocks.size()).isSameAs(1);
    }
}
