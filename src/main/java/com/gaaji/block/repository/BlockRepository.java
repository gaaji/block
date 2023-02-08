package com.gaaji.block.repository;

import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.UserId;
import java.util.List;
import java.util.UUID;

public interface BlockRepository {

    List<Block> findAllByUserId(UserId userId);

    void save(Block block);

    default String nextId(){
        return UUID.randomUUID().toString();
    }

	void deleteByUserIdAndBlockedUser_BlockedUserId(UserId userId, String blockedUserId);

}
