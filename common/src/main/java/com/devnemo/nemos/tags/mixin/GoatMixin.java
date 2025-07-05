package com.devnemo.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.devnemo.nemos.tags.tags.NemosItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static com.devnemo.nemos.tags.helper.ItemReplacementMaps.BUCKET_TO_MILK_BUCKET;

@Mixin(Goat.class)
public abstract class GoatMixin extends Animal {

    protected GoatMixin(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @ModifyExpressionValue(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private boolean isBucket(boolean original, @Local ItemStack itemStack) {
        return original || itemStack.is(NemosItemTags.EMPTY_BUCKETS);
    }

    @ModifyExpressionValue(method = "mobInteract", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/Item;getDefaultInstance()Lnet/minecraft/world/item/ItemStack;"))
    private ItemStack getDefaultInstance(ItemStack original, @Local ItemStack itemStack) {
        var item = itemStack.getItem();

        if (!BUCKET_TO_MILK_BUCKET.containsKey(item)) {
            return original;
        }

        return BUCKET_TO_MILK_BUCKET.get(item).getDefaultInstance();
    }

}
