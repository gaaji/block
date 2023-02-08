package com.gaaji.block.domain;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Block {

    @EmbeddedId
    private BlockId blockId;
    @Embedded
    private UserId userId;
    @Embedded
    private BlockedUser blockedUser;


    public static Block of(BlockId blockId, UserId userId, BlockedUser blockedUser) {
        return new Block(blockId,userId,blockedUser);
    }

    public String getBlockId() {
        return blockId.getBlockId();
    }

    public String getUserId() {
        return userId.getUserId();
    }
    
    public String getBlockedUserId() {
    	return blockedUser.getBlockedUserId();
    }
}
