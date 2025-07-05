package com.devnemo.nemos.tags.helper;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.HashMap;
import java.util.Map;

public class ItemReplacementMaps {

    /**
     * A mapping from empty bucket items to their corresponding milk bucket variants.
     * <p>
     * This map allows translating an empty bucket item (e.g., {@link net.minecraft.world.item.Items#BUCKET}) into its milk-filled version
     * (e.g., {@link net.minecraft.world.item.Items#MILK_BUCKET}).
     * It is used when handling interactions where an entity (such as a cow or goat) fills a player's bucket with milk.
     * <p>
     * The map is modifiable and can be extended to support additional bucket types if needed.
     */
    public static final Map<Item, Item> BUCKET_TO_MILK_BUCKET = new HashMap<>();

    /**
     * Maps filled bucket items to their corresponding empty bucket.
     * <p>
     * This map is used when handling interactions that consume the contents
     * of a filled bucket and return an empty bucket to the player.
     * <p>
     * The map is modifiable and can be extended to support additional bucket types if needed.
     */
    public static final Map<Item, Item> FILLED_BUCKET_TO_EMPTY_BUCKET = new HashMap<>();

    /**
     * Maps empty bucket items to their corresponding water-filled bucket items.
     * <p>
     * This map is used when picking up water with an empty bucket
     * to return the appropriate water bucket item.
     * <p>
     * The map is modifiable and can be extended to support additional bucket types if needed.
     */
    public static final Map<Item, Item> EMPTY_BUCKET_TO_WATER_BUCKET = new HashMap<>();

    /**
     * Maps empty bucket items to their corresponding lava-filled bucket items.
     * <p>
     * This map is used when picking up lava with an empty bucket
     * to return the appropriate lava bucket item.
     * <p>
     * The map is modifiable and can be extended to support additional bucket types if needed.
     */
    public static final Map<Item, Item> EMPTY_BUCKET_TO_LAVA_BUCKET = new HashMap<>();

    /**
     * Maps empty bucket items to their corresponding powder snow-filled bucket items.
     * <p>
     * This map is used when picking up powder snow with an empty bucket,
     * returning the appropriate powder snow bucket item.
     * <p>
     * The map is modifiable and can be extended to support additional bucket types if needed.
     */
    public static final Map<Item, Item> EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET = new HashMap<>();

    private ItemReplacementMaps() {}

    static {
        BUCKET_TO_MILK_BUCKET.put(Items.BUCKET, Items.MILK_BUCKET);

        FILLED_BUCKET_TO_EMPTY_BUCKET.put(Items.LAVA_BUCKET, Items.BUCKET);
        FILLED_BUCKET_TO_EMPTY_BUCKET.put(Items.WATER_BUCKET, Items.BUCKET);
        FILLED_BUCKET_TO_EMPTY_BUCKET.put(Items.POWDER_SNOW_BUCKET, Items.BUCKET);

        EMPTY_BUCKET_TO_WATER_BUCKET.put(Items.BUCKET, Items.WATER_BUCKET);

        EMPTY_BUCKET_TO_LAVA_BUCKET.put(Items.BUCKET, Items.LAVA_BUCKET);

        EMPTY_BUCKET_TO_POWDER_SNOW_BUCKET.put(Items.BUCKET, Items.POWDER_SNOW_BUCKET);
    }
}
