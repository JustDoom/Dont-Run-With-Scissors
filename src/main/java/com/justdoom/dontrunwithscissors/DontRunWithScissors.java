package com.justdoom.dontrunwithscissors;

import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod("dontrunwith")
public class DontRunWithScissors {
    public static final String MOD_ID = "dontrunwith";
    //private static final Logger LOGGER = LogManager.getLogger();

    public static DamageSource SHEARS = new DamageSource("shears").bypassArmor();
    public static DamageSource SHEARS_FALL = new DamageSource("shears_fall").bypassArmor();
    public static final DeferredRegister<ResourceLocation> CUSTOM_STAT = DeferredRegister.create(Registry.CUSTOM_STAT_REGISTRY, MOD_ID);

    public static final RegistryObject<ResourceLocation> SHEAR_DEATHS = CUSTOM_STAT.register("shear_deaths", () -> new ResourceLocation(MOD_ID, "shear_deaths"));

    public DontRunWithScissors() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DontRunConfig.SPEC, "dont-run-with-scissors.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        Registry.register(Registry.CUSTOM_STAT, "shear_deaths", SHEAR_DEATHS.get());
        Stats.CUSTOM.get(SHEAR_DEATHS.get(), StatFormatter.DEFAULT);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    private static ResourceLocation makeCustomStat(String p_13008_, StatFormatter p_13009_) {
        ResourceLocation resourcelocation = new ResourceLocation(p_13008_);
        Registry.register(Registry.CUSTOM_STAT, p_13008_, resourcelocation);
        Stats.CUSTOM.get(resourcelocation, p_13009_);
        return resourcelocation;
    }
}
