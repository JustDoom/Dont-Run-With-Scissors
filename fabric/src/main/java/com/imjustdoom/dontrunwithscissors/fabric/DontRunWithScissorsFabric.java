package com.imjustdoom.dontrunwithscissors.fabric;

import com.imjustdoom.dontrunwithscissors.DontRunWithScissors;
import com.imjustdoom.dontrunwithscissors.fabric.config.Config;
import net.fabricmc.api.ModInitializer;

public class DontRunWithScissorsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        DontRunWithScissors.init();

        new Config();
    }
}
