package com.devnemo.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.devnemo.nemos.tags.interfaces.CustomBucketPickup;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static com.devnemo.nemos.tags.helper.ItemReplacementMaps.EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET;

@Mixin(PowderSnowBlock.class)
public class PowderSnowBlockMixin implements CustomBucketPickup {

    @ModifyExpressionValue(method = "pickupBlock", at = @At(value = "FIELD", target = "Lnet/minecraft/world/item/Items;POWDER_SNOW_BUCKET:Lnet/minecraft/world/item/Item;"))
    private Item getItem(Item original, @Local(argsOnly = true) LivingEntity entity) {
        if (entity == null) {
            return original;
        }

        var mainHandItem = entity.getMainHandItem().getItem();
        var offHandItem = entity.getOffhandItem().getItem();

        if (EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET.containsKey(mainHandItem)) {
            return EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET.get(mainHandItem);
        }

        if (EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET.containsKey(offHandItem)) {
            return EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET.get(offHandItem);
        }

        return original;
    }

    @Override
    public ItemStack nemosTags$pickupBlock(Item bucket, ServerLevel levelAccessor, BlockPos blockpos, BlockState blockstate) {
        levelAccessor.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 11);
        if (!levelAccessor.isClientSide()) {
            levelAccessor.levelEvent(2001, blockpos, Block.getId(blockstate));
        }

        if (!EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET.containsKey(bucket)) {
            return new ItemStack(Items.POWDER_SNOW_BUCKET);
        }

        return new ItemStack(EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET.get(bucket));
    }
}
