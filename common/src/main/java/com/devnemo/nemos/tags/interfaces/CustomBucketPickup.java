package com.devnemo.nemos.tags.interfaces;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public interface CustomBucketPickup {

    /**
     * Used for registering a dispenser behaviour.
     *
     * @param bucket - the empty bucket item to be filed
     * @param levelAccessor - The {@link ServerLevel} used to set the fluid block to air after filling the bucket.
     * @param blockpos - The {@link BlockPos} of the fluid block
     * @param blockstate - The {@link BlockState} of the fluid block, used to verify a fluid level
     * @return the filled bucket item
     */
    ItemStack nemosTags$pickupBlock(Item bucket, ServerLevel levelAccessor, BlockPos blockpos, BlockState blockstate);
}
