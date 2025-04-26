package com.nemonotfound.nemos.tags.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.nemonotfound.nemos.tags.tags.ModBlockTags;
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
        return original || blockState.is(ModBlockTags.ATTACHES_TO_PANE_AND_BARS);
    }

    @ModifyExpressionValue(method = "skipRendering", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"))
    private boolean skipRendering(boolean original, @Local(argsOnly = true, ordinal = 0) BlockState blockState, @Local(argsOnly = true, ordinal = 1) BlockState adjacentBlockState) {
        List<TagKey<Block>> paneTags = List.of(
                ModBlockTags.BARS,
                ModBlockTags.GLASS_PANES,
                ModBlockTags.BROWN_STAINED_GLASS_PANES,
                ModBlockTags.BLUE_STAINED_GLASS_PANES,
                ModBlockTags.LIGHT_BLUE_STAINED_GLASS_PANES,
                ModBlockTags.CYAN_STAINED_GLASS_PANES,
                ModBlockTags.RED_STAINED_GLASS_PANES,
                ModBlockTags.BLACK_STAINED_GLASS_PANES,
                ModBlockTags.YELLOW_STAINED_GLASS_PANES,
                ModBlockTags.ORANGE_STAINED_GLASS_PANES,
                ModBlockTags.GREEN_STAINED_GLASS_PANES,
                ModBlockTags.LIME_STAINED_GLASS_PANES,
                ModBlockTags.PURPLE_STAINED_GLASS_PANES,
                ModBlockTags.PINK_STAINED_GLASS_PANES,
                ModBlockTags.MAGENTA_STAINED_GLASS_PANES,
                ModBlockTags.LIGHT_GRAY_STAINED_GLASS_PANES,
                ModBlockTags.GRAY_STAINED_GLASS_PANES,
                ModBlockTags.WHITE_STAINED_GLASS_PANES
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
