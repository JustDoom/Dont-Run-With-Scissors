package com.justdoom.dontrunwithscissors.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DontRunConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Double> run_damage_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> run_damage_amount;

    public static final ForgeConfigSpec.ConfigValue<Double> fall_damage_chance;

    public static final ForgeConfigSpec.ConfigValue<Boolean> cancel_sprinting;
    public static final ForgeConfigSpec.ConfigValue<Boolean> damage_in_liquid;
    public static final ForgeConfigSpec.ConfigValue<Boolean> respect_armour;
    public static final ForgeConfigSpec.ConfigValue<String> cancel_sprinting_message;

    static {
        BUILDER.comment("Config for mod");
        BUILDER.comment("Shears = Scissors");

        run_damage_chance = BUILDER.comment("Chance to take damage while sprinting. Chance is between 0.0 and 1.0, 1.0 is 100% chance and 0.0 is 0% chance. Default is 0.1").define("run-damage-chance", 0.1);
        run_damage_amount = BUILDER.comment("Damage taken when sprinting. Set to -1 to kill. Default is 2").define("run-damage-amount", 2);
        fall_damage_chance = BUILDER.comment("Chance to die when taking fall damage and holding scissors. Chance is between 0.0 and 1.0, 1.0 is 100% chance and 0.0 is 0% chance. Default is 0.30").define("fall-damage-chance", 0.30);
        cancel_sprinting = BUILDER.comment("Cancel the players sprint if they try to run with scissors. Default false").define("cancel-sprinting", false);
        cancel_sprinting_message = BUILDER.comment("Message sent to the player when they try and run with scissors").define("cancel-sprinting-message", "Oi, Don't run with scissors!");
        damage_in_liquid = BUILDER.comment("Should the player take damage when swimming in water? Default false").define("damage-in-water", false);
        respect_armour = BUILDER.comment("Should the shears damage respect armour protection? This will reduce the damage of the shears. Default true").define("respect-armour", true);
        SPEC = BUILDER.build();
    }
}
