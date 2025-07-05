package com.devnemo.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.devnemo.nemos.tags.tags.NemosBlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;

@Mixin(IronBarsBlock.class)
public class IronBarsBlockMixin {

    @ModifyReturnValue(method = "attachsTo", at = @At(value = "RETURN"))
    private boolean isBars(boolean original, @Local(argsOnly = true) BlockState blockState) {
        return original || blockState.is(NemosBlockTags.ATTACHES_TO_PANES_AND_BARS);
    }

    @ModifyExpressionValue(method = "skipRendering", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"))
    private boolean skipRendering(boolean original, @Local(argsOnly = true, ordinal = 0) BlockState blockState, @Local(argsOnly = true, ordinal = 1) BlockState adjacentBlockState) {
        List<TagKey<Block>> paneTags = List.of(
                NemosBlockTags.BARS,
                NemosBlockTags.GLASS_PANES,
                NemosBlockTags.BROWN_STAINED_GLASS_PANES,
                NemosBlockTags.BLUE_STAINED_GLASS_PANES,
                NemosBlockTags.LIGHT_BLUE_STAINED_GLASS_PANES,
                NemosBlockTags.CYAN_STAINED_GLASS_PANES,
                NemosBlockTags.RED_STAINED_GLASS_PANES,
                NemosBlockTags.BLACK_STAINED_GLASS_PANES,
                NemosBlockTags.YELLOW_STAINED_GLASS_PANES,
                NemosBlockTags.ORANGE_STAINED_GLASS_PANES,
                NemosBlockTags.GREEN_STAINED_GLASS_PANES,
                NemosBlockTags.LIME_STAINED_GLASS_PANES,
                NemosBlockTags.PURPLE_STAINED_GLASS_PANES,
                NemosBlockTags.PINK_STAINED_GLASS_PANES,
                NemosBlockTags.MAGENTA_STAINED_GLASS_PANES,
                NemosBlockTags.LIGHT_GRAY_STAINED_GLASS_PANES,
                NemosBlockTags.GRAY_STAINED_GLASS_PANES,
                NemosBlockTags.WHITE_STAINED_GLASS_PANES
        );

        var anyMatch = paneTags.stream()
                .anyMatch(tag -> nemosTags$areBothStatesInTag(blockState, adjacentBlockState, tag));

        return original || anyMatch;
    }

    @Unique
    private boolean nemosTags$areBothStatesInTag(BlockState state, BlockState adjacentBlockState, TagKey<Block> blockTag) {
        return state.is(blockTag) && adjacentBlockState.is(blockTag);
    }
}
