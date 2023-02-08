package com.gaaji.block.repository;

import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.UserId;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BlockRepositoryImpl implements BlockRepository{

    private final JpaBlockRepository jpaBlockRepository;

    @Override
    public List<Block> findAllByUserId(UserId userId) {
        return jpaBlockRepository.findAllByUserId( userId);
    }

    @Override
    public void save(Block block) {
        jpaBlockRepository.save(block);
    }

	@Override
	public Optional<Block> findByUserIdAndBlockedUser_BlockedUserId(UserId userId, String blockedUserId) {
		return this.jpaBlockRepository.findByUserIdAndBlockedUser_BlockedUserId(userId, blockedUserId);
	}

	@Override
	public void delete(Block block) {
		this.jpaBlockRepository.delete(block);
	}
}
