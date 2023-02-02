package com.gaaji.block.repository;

import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.BlockId;
import com.gaaji.block.domain.UserId;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBlockRepository extends JpaRepository<Block, BlockId> {

    List<Block> findAllByUserId(UserId userId);

	Optional<Block> findByUserIdAndBlockedUser_BlockedUserId(UserId userId, String blockedUserId);

}
