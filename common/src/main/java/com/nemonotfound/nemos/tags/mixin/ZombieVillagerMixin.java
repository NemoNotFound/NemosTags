package com.nemonotfound.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.nemonotfound.nemos.tags.tags.ModBlockTags;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ZombieVillager.class)
public class ZombieVillagerMixin {

    @ModifyExpressionValue(method = "getConversionProgress", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"))
    private boolean isBars(boolean original, @Local BlockState blockState) {
        return original || blockState.is(ModBlockTags.BARS);
    }
}
