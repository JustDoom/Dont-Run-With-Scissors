package com.imjustdoom.dontrunwithscissors.neoforge;

import com.imjustdoom.dontrunwithscissors.DontRunWithScissors;
import com.imjustdoom.dontrunwithscissors.config.neoforge.ConfigImpl;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(DontRunWithScissors.MOD_ID)
public class DontRunWithScissorsNeoForge {

    public DontRunWithScissorsNeoForge() {
        DontRunWithScissors.init();

        ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, ConfigImpl.SPEC, "dont-run-with-scissors.toml");
    }
}
