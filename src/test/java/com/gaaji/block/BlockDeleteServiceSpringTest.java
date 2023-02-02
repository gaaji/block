package com.gaaji.block;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.BlockId;
import com.gaaji.block.domain.BlockedUser;
import com.gaaji.block.domain.UserId;
import com.gaaji.block.exception.NoSearchException;
import com.gaaji.block.repository.JpaBlockRepository;

@Transactional
@SpringBootTest
public class BlockDeleteServiceSpringTest {

	@Autowired
    JpaBlockRepository jpaBlockRepository;
	
    
    @Test
    void 삭제서비스 () throws Exception{
        //given

    	this.jpaBlockRepository.save(Block.of(BlockId.of("123"), UserId.of("456"), BlockedUser.of("789", "asd", "qwe")));
    	Block block = this.jpaBlockRepository.findByUserIdAndBlockedUser_BlockedUserId(UserId.of("456"), "789").orElseThrow(() -> new NoSearchException());
    	this.jpaBlockRepository.delete(block);

    }
}