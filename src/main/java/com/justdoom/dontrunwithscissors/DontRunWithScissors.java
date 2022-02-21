package com.justdoom.dontrunwithscissors;

import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.io.File;
import java.rmi.registry.RegistryHandler;

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


//    I made a mod for 1.12.2 but i dont really have any experience with it. It seems to work but is there anything im doing wrong? Yes I know 1.12.2 is really old but its still used a lot
//    https://github.com/JustDoom/Dont-Run-With-Scissors/tree/1.12

}
