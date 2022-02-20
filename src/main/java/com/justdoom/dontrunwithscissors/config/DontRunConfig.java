package com.justdoom.dontrunwithscissors.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class DontRunConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> run_damage_chance;

    static {
        BUILDER.comment("Config for mod");

        run_damage_chance = BUILDER.comment("Chance to take damage while sprinting. Default is 10").define("run-damage-chance", 10);
        //minimum_pack_size = BUILDER.comment("The minimum number who spawn together. The default is 3").define("minimum_pack_size", 3);
        //maximum_pack_size = BUILDER.comment("The maximum number who spawn together. The default is 7").define("maximum_pack_size", 7);
        SPEC = BUILDER.build();
    }
}
