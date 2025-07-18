package com.devnemo.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.devnemo.nemos.tags.interfaces.CustomBucketItemGetter;
import com.devnemo.nemos.tags.interfaces.CustomBucketPickup;
import com.devnemo.nemos.tags.tags.NemosItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FlowingFluid;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LiquidBlock.class)
public class LiquidBlockMixin implements CustomBucketPickup {

    @Shadow
    @Final
    @Deprecated
    protected FlowingFluid fluid;

    @Shadow
    @Final
    public static IntegerProperty LEVEL;

    @ModifyExpressionValue(method = "pickupBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/material/FlowingFluid;getBucket()Lnet/minecraft/world/item/Item;"))
    private Item getFilledBucket(Item original, @Local(argsOnly = true) LivingEntity entity) {
        if (entity == null || !(fluid instanceof CustomBucketItemGetter)) {
            return original;
        }

        var mainHandItem = entity.getMainHandItem();
        var offHandItem = entity.getOffhandItem();

        if (mainHandItem.is(NemosItemTags.EMPTY_BUCKETS)) {
            return ((CustomBucketItemGetter) fluid).nemosTags$getFilledBucket(mainHandItem.getItem());
        }

        if (offHandItem.is(NemosItemTags.EMPTY_BUCKETS)) {
            return ((CustomBucketItemGetter) fluid).nemosTags$getFilledBucket(offHandItem.getItem());
        }

        return original;
    }

    /**
     * Used for registering a dispenser behaviour.
     * <p>
     * Retrieves the filled bucket corresponding to the given empty bucket by using a {@link CustomBucketItemGetter}
     * <p>
     * The fluid block will only be replaced with air if the fluid level is 0.
     *
     * @param bucket - the empty bucket item to be filed
     * @param levelAccessor - The {@link ServerLevel} used to set the fluid block to air after filling the bucket.
     * @param blockpos - The {@link BlockPos} of the fluid block
     * @param blockstate - The {@link BlockState} of the fluid block, used to verify a fluid level
     * @return the filled bucket item, or {@link ItemStack#EMPTY} if the fluid level is not 0
     */
    @Override
    public ItemStack nemosTags$pickupBlock(Item bucket, ServerLevel levelAccessor, BlockPos blockpos, BlockState blockstate) {
        if (blockstate.getValue(LEVEL) != 0) {
            return ItemStack.EMPTY;
        }

        levelAccessor.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 11);

        return new ItemStack(((CustomBucketItemGetter) fluid).nemosTags$getFilledBucket(bucket));
    }
}
