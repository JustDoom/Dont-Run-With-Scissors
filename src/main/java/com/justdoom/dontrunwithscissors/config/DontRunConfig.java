package com.justdoom.dontrunwithscissors.config;

import com.justdoom.dontrunwithscissors.DontRunWithScissors;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class DontRunConfig {

    public static Configuration config;

    public static double run_damage_chance;
    public static int run_damage_amount;

    public static double fall_damage_chance;

    public static boolean cancel_sprinting;
    public static String cancel_sprinting_message;

    public static void init(File file) {
        config = new Configuration(file);

        String category;

        category = "Settings";
        run_damage_chance = config.getFloat("run_damage_chance",
                category,
                0.1f, 0.0f, 1.0f,
                "Chance to take damage while sprinting. Chance is between 0.0 and 1.0, 1.0 is 100% chance and 0.0 is 0% chance. Default is 0.1");

        run_damage_amount = config.getInt("run_damage_amount",
                category,
                2, Integer.MIN_VALUE, Integer.MAX_VALUE,
                "Damage taken when sprinting. Set to -1 to kill. Default is 2");

        fall_damage_chance = config.getFloat("fall_damage_chance",
                category,
                0.3f, Float.MIN_VALUE, Float.MAX_VALUE,
                "Chance to die when taking fall damage and holding scissors. Chance is between 0.0 and 1.0, 1.0 is 100% chance and 0.0 is 0% chance. Default is 0.3");

        cancel_sprinting = config.getBoolean("cancel_sprinting",
                category,
                false,
                "Cancel the players spring if they try to run with scissors. Default false");

        cancel_sprinting_message = config.getString("cancel_sprinting_message",
                category,
                "Oi, Don't run with scissors!",
                "Message sent to the player when they try and run with scissors");

        config.save();
    }

    public static void registerConfig(FMLPreInitializationEvent event) {
        DontRunWithScissors.config = new File(event.getModConfigurationDirectory() + "/" + DontRunWithScissors.MOD_ID);
        DontRunWithScissors.config.mkdirs();
        init(new File(DontRunWithScissors.config.getPath(), DontRunWithScissors.MOD_ID + ".cfg"));
    }

//    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
//    public static final ForgeConfigSpec SPEC;
//
//    public static final ForgeConfigSpec.ConfigValue<Double> run_damage_chance;
//    public static final ForgeConfigSpec.ConfigValue<Integer> run_damage_amount;
//
//    public static final ForgeConfigSpec.ConfigValue<Double> fall_damage_chance;
//
//    public static final ForgeConfigSpec.ConfigValue<Boolean> cancel_sprinting;
//    public static final ForgeConfigSpec.ConfigValue<String> cancel_sprinting_message;
//
//    static {
//        BUILDER.comment("Config for mod");
//        BUILDER.comment("Shears = Scissors");
//
//        run_damage_chance = BUILDER.comment("Chance to take damage while sprinting. Chance is between 0.0 and 1.0, 1.0 is 100% chance and 0.0 is 0% chance. Default is 0.1").define("run-damage-chance", 0.1);
//        run_damage_amount = BUILDER.comment("Damage taken when sprinting. Set to -1 to kill. Default is 2").define("run-damage-amount", 2);
//        fall_damage_chance = BUILDER.comment("Chance to die when taking fall damage and holding scissors. Chance is between 0.0 and 1.0, 1.0 is 100% chance and 0.0 is 0% chance. Default is 0.30").define("fall-damage-chance", 0.30);
//        cancel_sprinting = BUILDER.comment("Cancel the players spring if they try to run with scissors. Default false").define("cancel-sprinting", false);
//        cancel_sprinting_message = BUILDER.comment("Message sent to the player when they try and run with scissors").define("cancel-sprinting-message", "Oi, Don't run with scissors!");
//        SPEC = BUILDER.build();
//    }
}
