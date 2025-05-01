package com.nemonotfound.nemos.tags.interfaces;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public interface CustomBucketPickup {

    ItemStack nemosTags$pickupBlock(Item bucket, ServerLevel levelAccessor, BlockPos blockpos, BlockState blockstate);
}
