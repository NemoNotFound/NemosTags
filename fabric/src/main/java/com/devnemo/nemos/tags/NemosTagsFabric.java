package com.devnemo.nemos.tags;

import net.fabricmc.api.ModInitializer;

public class NemosTagsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        NemosTagsCommon.init();
    }
}
