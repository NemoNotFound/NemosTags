package com.nemonotfound.nemos.tags.datagen;

import com.nemonotfound.nemos.tags.tags.ModBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BlockTagsProvider extends FabricTagProvider.BlockTagProvider {

    public BlockTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(ModBlockTags.BARS)
                .add(Blocks.IRON_BARS);

        getOrCreateTagBuilder(ModBlockTags.ALL_GLASS_PANES)
                .addTag(ModBlockTags.GLASS_PANES)
                .addTag(ModBlockTags.BROWN_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.BLUE_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.LIGHT_BLUE_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.CYAN_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.RED_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.BLACK_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.YELLOW_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.ORANGE_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.GREEN_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.LIME_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.PURPLE_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.PINK_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.MAGENTA_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.LIGHT_GRAY_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.GRAY_STAINED_GLASS_PANES)
                .addTag(ModBlockTags.WHITE_STAINED_GLASS_PANES);

        getOrCreateTagBuilder(ModBlockTags.GLASS_PANES)
                .add(Blocks.GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.BROWN_STAINED_GLASS_PANES)
                .add(Blocks.BROWN_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.BLUE_STAINED_GLASS_PANES)
                .add(Blocks.BLUE_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.LIGHT_BLUE_STAINED_GLASS_PANES)
                .add(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.CYAN_STAINED_GLASS_PANES)
                .add(Blocks.CYAN_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.RED_STAINED_GLASS_PANES)
                .add(Blocks.RED_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.BLACK_STAINED_GLASS_PANES)
                .add(Blocks.BLACK_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.YELLOW_STAINED_GLASS_PANES)
                .add(Blocks.YELLOW_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.ORANGE_STAINED_GLASS_PANES)
                .add(Blocks.ORANGE_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.GREEN_STAINED_GLASS_PANES)
                .add(Blocks.GREEN_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.LIME_STAINED_GLASS_PANES)
                .add(Blocks.LIME_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.PURPLE_STAINED_GLASS_PANES)
                .add(Blocks.PURPLE_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.PINK_STAINED_GLASS_PANES)
                .add(Blocks.PINK_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.MAGENTA_STAINED_GLASS_PANES)
                .add(Blocks.MAGENTA_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.LIGHT_GRAY_STAINED_GLASS_PANES)
                .add(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.GRAY_STAINED_GLASS_PANES)
                .add(Blocks.GRAY_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.WHITE_STAINED_GLASS_PANES)
                .add(Blocks.WHITE_STAINED_GLASS_PANE);

        getOrCreateTagBuilder(ModBlockTags.CONNECTS_TO_WALL)
                .addTag(ModBlockTags.BARS)
                .addTag(ModBlockTags.ALL_GLASS_PANES);

        getOrCreateTagBuilder(ModBlockTags.ATTACHES_TO_PANE_AND_BARS)
                .addTag(ModBlockTags.BARS)
                .addTag(ModBlockTags.ALL_GLASS_PANES);

        getOrCreateTagBuilder(ModBlockTags.POWERED_RAILS)
                .add(Blocks.POWERED_RAIL);
    }
}
