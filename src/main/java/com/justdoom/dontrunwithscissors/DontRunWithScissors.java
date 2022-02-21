package com.justdoom.dontrunwithscissors;

import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.io.File;

@Mod(modid = "dontrunwith")
public class DontRunWithScissors {

    public static final String MOD_ID = "dontrunwith";

    public static DamageSource SHEARS = new DamageSource("shears").setDamageBypassesArmor();
    public static DamageSource SHEARS_FALL = new DamageSource("shears_fall").setDamageBypassesArmor();

    public static File config;

    @Mod.Instance
    public static DontRunWithScissors instance;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventHandler
    public static void serverInit(FMLServerStartingEvent event)
    {

    }


//    public static final String MOD_ID = "dontrunwith";
//    //private static final Logger LOGGER = LogManager.getLogger();
//
//    public static DamageSource SHEARS = new DamageSource("shears").setDamageBypassesArmor();
//    public static DamageSource SHEARS_FALL = new DamageSource("shears_fall").setDamageBypassesArmor();
//
//    public DontRunWithScissors() {
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
//
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DontRunConfig.SPEC, "dont-run-with-scissors.toml");
//
//        MinecraftForge.EVENT_BUS.register(this);
//    }
//
//    private void setup(final FMLCommonSetupEvent event) {
//
//    }
//
//    private void doClientStuff(final FMLClientSetupEvent event) {
//
//    }

}
