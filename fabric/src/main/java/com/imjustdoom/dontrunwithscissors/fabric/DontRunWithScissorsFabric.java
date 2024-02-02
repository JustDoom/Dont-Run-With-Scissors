package com.imjustdoom.dontrunwithscissors.fabric;

import com.imjustdoom.dontrunwithscissors.DontRunWithScissors;
import com.imjustdoom.dontrunwithscissors.config.fabric.ConfigImpl;
import net.fabricmc.api.ModInitializer;

public class DontRunWithScissorsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        DontRunWithScissors.init();

        new ConfigImpl();
    }
}
