package com.gaaji.block.domain;

import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class BlockedUser {
    private String blockedUserId;
    private String nickname;
    private String pictureUrl;



    public static BlockedUser of(String blockedUserId, String nickname, String pictureUrl){
            return new BlockedUser(blockedUserId,nickname,pictureUrl);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BlockedUser that = (BlockedUser) o;
        return Objects.equals(blockedUserId, that.blockedUserId) && Objects.equals(
                nickname, that.nickname) && Objects.equals(pictureUrl, that.pictureUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockedUserId, nickname, pictureUrl);
    }
}
