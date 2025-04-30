package com.nemonotfound.nemos.tags.datagen;

import com.nemonotfound.nemos.tags.tags.NemosItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ItemTagsProvider extends FabricTagProvider.ItemTagProvider {

    public ItemTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(NemosItemTags.SHEARS)
                .add(Items.SHEARS);

        getOrCreateTagBuilder(NemosItemTags.EMPTY_BUCKETS)
                .add(Items.BUCKET);

        getOrCreateTagBuilder(NemosItemTags.WATER_BUCKETS)
                .add(Items.WATER_BUCKET);

        getOrCreateTagBuilder(NemosItemTags.LAVA_BUCKETS)
                .add(Items.LAVA_BUCKET);

        getOrCreateTagBuilder(NemosItemTags.POWDER_SNOW_BUCKETS)
                .add(Items.POWDER_SNOW_BUCKET);
    }
}
