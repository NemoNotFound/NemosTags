package com.nemonotfound.nemos.tags;

import com.nemonotfound.nemos.tags.datagen.BlockLootTableProvider;
import com.nemonotfound.nemos.tags.datagen.BlockTagsProvider;
import com.nemonotfound.nemos.tags.datagen.ItemTagsProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BlockTagsProvider::new);
        pack.addProvider(ItemTagsProvider::new);
        pack.addProvider(BlockLootTableProvider::new);
    }
}
