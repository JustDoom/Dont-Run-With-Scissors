package com.justdoom.dontrunwithscissors;

import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("dontrunwith")
public class DontRunWithScissors {
    public static final String MOD_ID = "dontrunwith";
    //private static final Logger LOGGER = LogManager.getLogger();

    public static DamageSource SHEARS = new DamageSource("shears").bypassArmor();
    public static DamageSource SHEARS_FALL = new DamageSource("shears_fall").bypassArmor();

    public DontRunWithScissors() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DontRunConfig.SPEC, "dont-run-with-scissors.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

}
