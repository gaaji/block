package com.gaaji.block.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Embeddable
public class UserId implements Serializable {

    private String userId;

    public static UserId of(String userId) {
        return new UserId(userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserId userId1 = (UserId) o;
        return Objects.equals(userId, userId1.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public String getUserId(){
        return userId;
    }
}
