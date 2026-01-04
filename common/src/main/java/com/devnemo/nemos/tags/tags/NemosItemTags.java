package com.devnemo.nemos.tags.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static com.devnemo.nemos.tags.Constants.MOD_ID;

public class NemosItemTags {

    private NemosItemTags() {}

    public static final TagKey<Item> SHEARS = create("shears");
    public static final TagKey<Item> EMPTY_BUCKETS = create("buckets/empty");
    public static final TagKey<Item> WATER_BUCKETS = create("buckets/water");
    public static final TagKey<Item> LAVA_BUCKETS = create("buckets/lava");
    public static final TagKey<Item> POWDER_SNOW_BUCKETS = create("buckets/powder_snow");

    private static TagKey<Item> create(String id) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, id));
    }
}
