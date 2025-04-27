package com.nemonotfound.nemos.tags.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static com.nemonotfound.nemos.tags.Constants.MOD_ID;

public class NemosItemTags {

    private NemosItemTags() {}

    public static final TagKey<Item> SHEARS = create("shears");
    public static final TagKey<Item> EMPTY_BUCKETS = create("empty_buckets");
    public static final TagKey<Item> WATER_BUCKETS = create("water_buckets");

    private static TagKey<Item> create(String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, id));
    }
}
