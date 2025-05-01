package com.nemonotfound.nemos.tags.datagen;

import com.nemonotfound.nemos.tags.tags.NemosItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class BlockLootTableProvider extends FabricBlockLootTableProvider {

    private static final float[] JUNGLE_LEAVES_SAPLING_CHANGES = new float[]{0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F};

    public BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.add(Blocks.OAK_LEAVES, block -> this.createOakLeavesDrops(block, Blocks.OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(Blocks.SPRUCE_LEAVES, block -> this.createLeavesDrops(block, Blocks.SPRUCE_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(Blocks.BIRCH_LEAVES, block -> this.createLeavesDrops(block, Blocks.BIRCH_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(Blocks.JUNGLE_LEAVES, block -> this.createLeavesDrops(block, Blocks.JUNGLE_SAPLING, JUNGLE_LEAVES_SAPLING_CHANGES));
        this.add(Blocks.ACACIA_LEAVES, block -> this.createLeavesDrops(block, Blocks.ACACIA_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(Blocks.DARK_OAK_LEAVES, block -> this.createOakLeavesDrops(block, Blocks.DARK_OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(Blocks.PALE_OAK_LEAVES, (block) -> this.createLeavesDrops(block, Blocks.PALE_OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(Blocks.CHERRY_LEAVES, block -> this.createLeavesDrops(block, Blocks.CHERRY_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(Blocks.AZALEA_LEAVES, block -> this.createLeavesDrops(block, Blocks.AZALEA, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(Blocks.FLOWERING_AZALEA_LEAVES, block -> this.createLeavesDrops(block, Blocks.FLOWERING_AZALEA, NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(Blocks.COBWEB, block -> this.createSilkTouchOrShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(net.minecraft.world.item.Items.STRING))));
        this.add(Blocks.DEAD_BUSH, block -> this.createShearsDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(net.minecraft.world.item.Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F))))));
        this.add(Blocks.NETHER_SPROUTS, this::createShearsOnlyDrop);
        this.add(Blocks.SEAGRASS, this::createShearsOnlyDrop);
        this.add(Blocks.VINE, this::createShearsOnlyDrop);
        this.add(Blocks.GLOW_LICHEN, block -> this.createMultifaceBlockDrops(block, this.hasShears()));
        this.add(Blocks.HANGING_ROOTS, this::createShearsOnlyDrop);
        this.add(Blocks.SMALL_DRIPLEAF, this::createShearsOnlyDrop);
        this.add(Blocks.MANGROVE_LEAVES, this::createMangroveLeavesDrops);
        this.add(Blocks.TALL_SEAGRASS, this.createDoublePlantShearsDrop(Blocks.SEAGRASS));
        this.add(Blocks.FERN, this::createGrassDrops);
        this.add(Blocks.SHORT_GRASS, this::createGrassDrops);
        this.add(Blocks.LARGE_FERN, block -> this.createDoublePlantWithSeedDrops(block, Blocks.FERN));
        this.add(Blocks.TALL_GRASS, block -> this.createDoublePlantWithSeedDrops(block, Blocks.SHORT_GRASS));
        this.addNetherVinesDropTable(Blocks.WEEPING_VINES, Blocks.WEEPING_VINES_PLANT);
        this.addNetherVinesDropTable(Blocks.TWISTING_VINES, Blocks.TWISTING_VINES_PLANT);
    }

    public LootItemCondition.@NotNull Builder hasShears() {
        return MatchTool.toolMatches(ItemPredicate.Builder.item().of(this.registries.lookupOrThrow(Registries.ITEM), NemosItemTags.SHEARS));
    }
}
