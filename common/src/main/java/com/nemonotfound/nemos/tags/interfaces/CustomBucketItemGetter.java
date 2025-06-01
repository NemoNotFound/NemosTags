package com.nemonotfound.nemos.tags.interfaces;

import net.minecraft.world.item.Item;

public interface CustomBucketItemGetter {

    /**
     * Returns the filled bucket corresponding to the provided empty bucket.
     * <p>
     * This method is implemented by fluids.
     *
     * @param emptyBucket - The empty bucket item used for picking up the fluid
     * @return the filled bucket item
     */
    Item nemosTags$getFilledBucket(Item emptyBucket);
}
