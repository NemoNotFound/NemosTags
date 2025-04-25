package com.nemonotfound.nemos.tags;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class NemosTagsNeoForge {

    public NemosTagsNeoForge(IEventBus eventBus) {
        NemosTagsCommon.init();

    }
}