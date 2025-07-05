package com.devnemo.nemos.tags.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static com.devnemo.nemos.tags.Constants.MOD_ID;

public class NemosBlockTags {

    private NemosBlockTags() {}

    public static final TagKey<Block> BARS = create("bars");
    public static final TagKey<Block> GLASS_PANES = create("glass_panes");
    public static final TagKey<Block> ALL_GLASS_PANES = create("glass_panes/all");
    public static final TagKey<Block> BROWN_STAINED_GLASS_PANES = create("stained_glass_panes/brown");
    public static final TagKey<Block> BLUE_STAINED_GLASS_PANES = create("stained_glass_panes/blue");
    public static final TagKey<Block> LIGHT_BLUE_STAINED_GLASS_PANES = create("stained_glass_panes/light_blue");
    public static final TagKey<Block> CYAN_STAINED_GLASS_PANES = create("stained_glass_panes/cyan");
    public static final TagKey<Block> RED_STAINED_GLASS_PANES = create("stained_glass_panes/red");
    public static final TagKey<Block> BLACK_STAINED_GLASS_PANES = create("stained_glass_panes/black");
    public static final TagKey<Block> YELLOW_STAINED_GLASS_PANES = create("stained_glass_panes/yellow");
    public static final TagKey<Block> ORANGE_STAINED_GLASS_PANES = create("stained_glass_panes/orange");
    public static final TagKey<Block> GREEN_STAINED_GLASS_PANES = create("stained_glass_panes/green");
    public static final TagKey<Block> LIME_STAINED_GLASS_PANES = create("stained_glass_panes/lime");
    public static final TagKey<Block> PURPLE_STAINED_GLASS_PANES = create("stained_glass_panes/purple");
    public static final TagKey<Block> PINK_STAINED_GLASS_PANES = create("stained_glass_panes/pink");
    public static final TagKey<Block> MAGENTA_STAINED_GLASS_PANES = create("stained_glass_panes/magenta");
    public static final TagKey<Block> LIGHT_GRAY_STAINED_GLASS_PANES = create("stained_glass_panes/light_gray");
    public static final TagKey<Block> GRAY_STAINED_GLASS_PANES = create("stained_glass_panes/gray");
    public static final TagKey<Block> WHITE_STAINED_GLASS_PANES = create("stained_glass_panes/white");
    public static final TagKey<Block> CONNECTS_TO_WALL = create("connects_to_wall");
    public static final TagKey<Block> ATTACHES_TO_PANES_AND_BARS = create("attaches_to_panes_and_bars");
    public static final TagKey<Block> POWERED_RAILS = create("powered_rails");

    private static TagKey<Block> create(String id) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, id));
    }
}
