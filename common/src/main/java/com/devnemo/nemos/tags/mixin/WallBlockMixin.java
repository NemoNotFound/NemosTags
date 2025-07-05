package com.devnemo.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.devnemo.nemos.tags.tags.NemosBlockTags;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WallBlock.class)
public class WallBlockMixin {

    @ModifyReturnValue(method = "connectsTo", at = @At(value = "RETURN"))
    private boolean isBars(boolean original, @Local(argsOnly = true) BlockState blockState) {
        return original || blockState.is(NemosBlockTags.CONNECTS_TO_WALL);
    }
}
