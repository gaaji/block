package com.gaaji.block.repository;

import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.UserId;
import java.util.List;
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
	public void deleteByUserIdAndBlockedUser_BlockedUserId(String userId, String blockedUserId) {
		this.jpaBlockRepository.deleteByUserIdAndBlockedUser_BlockedUserId(userId, blockedUserId);
	}
}
