package com.gaaji.block.applicationservice;

import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.BlockId;
import com.gaaji.block.domain.UserId;
import com.gaaji.block.repository.BlockRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class FakeBlockRepository implements BlockRepository {

    private Map<BlockId, Block> map = new HashMap();

    @Override
    public List<Block> findAllByUserId(UserId userId) {

        return map.values()
                .stream()
                .filter(b ->
                        UserId.of(b.getUserId())
                                .equals(userId))
                .toList();
    }
    @Override
    public void save(Block block){
        map.put(BlockId.of(block.getBlockId()), block);

    }


	@Override
	public void deleteByUserIdAndBlockedUser_BlockedUserId(UserId userId, String blockedUserId) {
		Optional<Block> map1 =map.values()
        .stream()
        .filter(b ->
                UserId.of(b.getUserId())
                        .equals(userId)).filter(b -> b.getBlockedUserId().equals(blockedUserId)).findFirst();
		
		log.debug(map1.get().getBlockId());
		
		map.remove(BlockId.of(map1.get().getBlockId()));
	}


}
