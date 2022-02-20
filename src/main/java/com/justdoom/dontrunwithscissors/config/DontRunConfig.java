package com.justdoom.dontrunwithscissors.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DontRunConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Double> run_damage_chance;
    public static final ForgeConfigSpec.ConfigValue<Integer> run_damage_amount;

    public static final ForgeConfigSpec.ConfigValue<Double> fall_damage_chance;

    static {
        BUILDER.comment("Config for mod");
        BUILDER.comment("Shears = Scissors");

        run_damage_chance = BUILDER.comment("Chance to take damage while sprinting. Chance is between 0.0 and 1.0, 1.0 is 100% chance and 0.0 is 0% chance. Default is 0.1").define("run-damage-chance", 0.1);
        run_damage_amount = BUILDER.comment("Damage taken when sprinting. Set to -1 to kill. Default is 2").define("run-damage-amount", 2);
        fall_damage_chance = BUILDER.comment("Chance to die when taking fall damage and holding scissors. Chance is between 0.0 and 1.0, 1.0 is 100% chance and 0.0 is 0% chance. Default is 0.30").define("fall-damage-chance", 0.30);
        SPEC = BUILDER.build();
    }
}
