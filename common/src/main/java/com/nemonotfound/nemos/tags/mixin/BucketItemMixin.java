package com.nemonotfound.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static com.nemonotfound.nemos.tags.helper.ItemReplacementMaps.FILLED_BUCKET_TO_EMPTY_BUCKET;

@Mixin(BucketItem.class)
public class BucketItemMixin {

    @ModifyExpressionValue(method = "getEmptySuccessItem", at = @At(value = "NEW", target = "(Lnet/minecraft/world/level/ItemLike;)Lnet/minecraft/world/item/ItemStack;"))
    private static ItemStack getEmptyBucket(ItemStack original, @Local(argsOnly = true) ItemStack bucketStack) {
        var bucketItem = bucketStack.getItem();

        if (FILLED_BUCKET_TO_EMPTY_BUCKET.containsKey(bucketItem)) {
            return new ItemStack(FILLED_BUCKET_TO_EMPTY_BUCKET.get(bucketItem));
        }

        return original;
    }
}
