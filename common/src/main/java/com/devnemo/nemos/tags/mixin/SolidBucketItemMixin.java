package com.devnemo.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.item.context.UseOnContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SolidBucketItem.class)
public class SolidBucketItemMixin {

    @Unique
    private ItemStack nemosCopper$bucketStack;

    @Inject(method = "useOn", at = @At("HEAD"))
    private void useOn(UseOnContext useOnContext, CallbackInfoReturnable<InteractionResult> cir) {
        nemosCopper$bucketStack = useOnContext.getItemInHand().copy();
    }

    @ModifyExpressionValue(method = "useOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/context/UseOnContext;getItemInHand()Lnet/minecraft/world/item/ItemStack;"))
    private ItemStack getBucketStack(ItemStack original) {
        return nemosCopper$bucketStack != null ? nemosCopper$bucketStack : original;
    }
}
