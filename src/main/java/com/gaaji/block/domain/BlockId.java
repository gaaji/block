package com.gaaji.block.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access =  AccessLevel.PRIVATE)
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
@Embeddable
public class BlockId implements Serializable {

    private String blockId;

    public static BlockId of(String id){
        return new BlockId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BlockId blockId1 = (BlockId) o;
        return Objects.equals(blockId, blockId1.blockId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockId);
    }

    public String getBlockId(){
        return this.blockId;
    }
}
