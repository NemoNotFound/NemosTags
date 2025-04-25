package com.nemonotfound.nemos.tags.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static com.nemonotfound.nemos.tags.Constants.MOD_ID;

public class ModBlockTags {

    private ModBlockTags() {}

    public static final TagKey<Block> BARS = create("bars");
    public static final TagKey<Block> GLASS_PANES = create("glass_panes");

    private static TagKey<Block> create(String id) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, id));
    }
}
