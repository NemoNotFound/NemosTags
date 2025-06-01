package com.nemonotfound.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.nemonotfound.nemos.tags.interfaces.CustomBucketItemGetter;
import com.nemonotfound.nemos.tags.interfaces.CustomBucketPickup;
import com.nemonotfound.nemos.tags.tags.NemosItemTags;
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

    @Shadow @Final @Deprecated
    protected FlowingFluid fluid;

    @Shadow @Final public static IntegerProperty LEVEL;

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

    @Override
    public ItemStack nemosTags$pickupBlock(Item bucket, ServerLevel levelAccessor, BlockPos blockpos, BlockState blockstate) {
        if (blockstate.getValue(LEVEL) != 0) {
            return ItemStack.EMPTY;
        }

        levelAccessor.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 11);

        return new ItemStack(((CustomBucketItemGetter) fluid).nemosTags$getFilledBucket(bucket));
    }
}
