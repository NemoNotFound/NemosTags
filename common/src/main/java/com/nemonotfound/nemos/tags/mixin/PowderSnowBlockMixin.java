package com.nemonotfound.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.PowderSnowBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static com.nemonotfound.nemos.tags.helper.ItemReplacementMaps.EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET;

@Mixin(PowderSnowBlock.class)
public class PowderSnowBlockMixin {

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
}
