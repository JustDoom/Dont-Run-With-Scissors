package com.justdoom.dontrunwithscissors;

import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

@Mod(modid = DontRunWithScissors.MOD_ID, name = "Dont Run With Scissors", version = "1.0.0")
public class DontRunWithScissors {

    public static final String MOD_ID = "dontrunwith";

    public static DamageSource SHEARS = new DamageSource("shears").setDamageBypassesArmor();
    public static DamageSource SHEARS_FALL = new DamageSource("shears_fall").setDamageBypassesArmor();

    public static File config;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        DontRunConfig.registerConfig(event);
    }

}
