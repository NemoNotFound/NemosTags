package com.nemonotfound.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.nemonotfound.nemos.tags.interfaces.CustomBucketItemGetter;
import com.nemonotfound.nemos.tags.tags.NemosItemTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LiquidBlock.class)
public class LiquidBlockMixin {

    @Shadow @Final @Deprecated
    protected FlowingFluid fluid;

    @ModifyExpressionValue(method = "pickupBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/material/FlowingFluid;getBucket()Lnet/minecraft/world/item/Item;"))
    private Item getFilledBucket(Item original, @Local(argsOnly = true) LivingEntity entity) {
        if (entity == null) {
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
}
