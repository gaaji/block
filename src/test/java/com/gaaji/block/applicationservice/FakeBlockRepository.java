package com.gaaji.block.applicationservice;

import com.gaaji.block.domain.Block;
import com.gaaji.block.domain.BlockId;
import com.gaaji.block.domain.UserId;
import com.gaaji.block.repository.BlockRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void deleteByUserIdAndBlockedUser_BlockedUserId(String userId, String blockedUserId) {
		// TODO Auto-generated method stub
		
	}


}
