package com.devnemo.nemos.tags.datagen;

import com.devnemo.nemos.tags.tags.NemosBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BlockTagsProvider extends FabricTagProvider.BlockTagProvider {

    public BlockTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(NemosBlockTags.BARS)
                .add(Blocks.IRON_BARS);

        valueLookupBuilder(NemosBlockTags.ALL_GLASS_PANES)
                .addTag(NemosBlockTags.GLASS_PANES)
                .addTag(NemosBlockTags.BROWN_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.BLUE_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.LIGHT_BLUE_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.CYAN_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.RED_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.BLACK_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.YELLOW_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.ORANGE_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.GREEN_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.LIME_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.PURPLE_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.PINK_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.MAGENTA_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.LIGHT_GRAY_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.GRAY_STAINED_GLASS_PANES)
                .addTag(NemosBlockTags.WHITE_STAINED_GLASS_PANES);

        valueLookupBuilder(NemosBlockTags.GLASS_PANES)
                .add(Blocks.GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.BROWN_STAINED_GLASS_PANES)
                .add(Blocks.BROWN_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.BLUE_STAINED_GLASS_PANES)
                .add(Blocks.BLUE_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.LIGHT_BLUE_STAINED_GLASS_PANES)
                .add(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.CYAN_STAINED_GLASS_PANES)
                .add(Blocks.CYAN_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.RED_STAINED_GLASS_PANES)
                .add(Blocks.RED_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.BLACK_STAINED_GLASS_PANES)
                .add(Blocks.BLACK_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.YELLOW_STAINED_GLASS_PANES)
                .add(Blocks.YELLOW_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.ORANGE_STAINED_GLASS_PANES)
                .add(Blocks.ORANGE_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.GREEN_STAINED_GLASS_PANES)
                .add(Blocks.GREEN_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.LIME_STAINED_GLASS_PANES)
                .add(Blocks.LIME_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.PURPLE_STAINED_GLASS_PANES)
                .add(Blocks.PURPLE_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.PINK_STAINED_GLASS_PANES)
                .add(Blocks.PINK_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.MAGENTA_STAINED_GLASS_PANES)
                .add(Blocks.MAGENTA_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.LIGHT_GRAY_STAINED_GLASS_PANES)
                .add(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.GRAY_STAINED_GLASS_PANES)
                .add(Blocks.GRAY_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.WHITE_STAINED_GLASS_PANES)
                .add(Blocks.WHITE_STAINED_GLASS_PANE);

        valueLookupBuilder(NemosBlockTags.CONNECTS_TO_WALL)
                .addTag(NemosBlockTags.BARS)
                .addTag(NemosBlockTags.ALL_GLASS_PANES);

        valueLookupBuilder(NemosBlockTags.ATTACHES_TO_PANES_AND_BARS)
                .addTag(NemosBlockTags.BARS)
                .addTag(NemosBlockTags.ALL_GLASS_PANES);

        valueLookupBuilder(NemosBlockTags.POWERED_RAILS)
                .add(Blocks.POWERED_RAIL);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(NemosBlockTags.BARS);
    }
}
