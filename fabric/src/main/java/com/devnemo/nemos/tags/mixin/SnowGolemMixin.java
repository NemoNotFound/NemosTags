package com.devnemo.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.devnemo.nemos.tags.tags.NemosItemTags;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SnowGolem.class)
public class SnowGolemMixin {

    @ModifyExpressionValue(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private boolean mobInteract(boolean original, @Local ItemStack itemStack) {
        return original || itemStack.is(NemosItemTags.SHEARS);
    }
}
