package com.gaaji.block.applicationservice;

import static org.assertj.core.api.Assertions.assertThat;

import com.gaaji.block.adaptor.AuthServiceClient;
import com.gaaji.block.controller.dto.BlockedUserRequest;
import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.UserId;
import com.gaaji.block.repository.BlockRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlockCreateServiceTest {

    @Test
    void 정상_생성() throws Exception{
        BlockRepository blockRepository = new FakeBlockRepository();
        AuthServiceClient authServiceClient = new StubAuthServiceClient();
        BlockCreateService blockCreateService = new BlockCreateService(blockRepository, authServiceClient);

        blockCreateService.createBlock("userId", new BlockedUserRequest("blockedUserId"));

        List<Block> blocks= blockRepository.findAllByUserId(UserId.of("userId"));

        assertThat(blocks.size()).isSameAs(1);
    }

}