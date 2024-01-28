package com.imjustdoom.dontrunwithscissors.forge;

import com.imjustdoom.dontrunwithscissors.DontRunWithScissors;
import com.imjustdoom.dontrunwithscissors.config.forge.ConfigImpl;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(DontRunWithScissors.MOD_ID)
public class DontRunWithScissorsForge {
    public DontRunWithScissorsForge() {
        DontRunWithScissors.init();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigImpl.SPEC, "dont-run-with-scissors.toml");
    }
}
