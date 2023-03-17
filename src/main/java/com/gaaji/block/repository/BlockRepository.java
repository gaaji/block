package com.gaaji.block.repository;

import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.UserId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BlockRepository {

    List<Block> findAllByUserId(UserId userId);

    void save(Block block);

    default String nextId(){
        return UUID.randomUUID().toString();
    }

	Optional<Block> findByUserIdAndBlockedUser_BlockedUserId(UserId of, String blockedUserId);

	void delete(Block block);

}
