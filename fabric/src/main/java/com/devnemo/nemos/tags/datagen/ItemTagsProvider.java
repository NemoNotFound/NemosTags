package com.devnemo.nemos.tags.datagen;

import com.devnemo.nemos.tags.tags.NemosItemTags;
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
        valueLookupBuilder(NemosItemTags.SHEARS)
                .add(Items.SHEARS);

        valueLookupBuilder(NemosItemTags.EMPTY_BUCKETS)
                .add(Items.BUCKET);

        valueLookupBuilder(NemosItemTags.WATER_BUCKETS)
                .add(Items.WATER_BUCKET);

        valueLookupBuilder(NemosItemTags.LAVA_BUCKETS)
                .add(Items.LAVA_BUCKET);

        valueLookupBuilder(NemosItemTags.POWDER_SNOW_BUCKETS)
                .add(Items.POWDER_SNOW_BUCKET);
    }
}
