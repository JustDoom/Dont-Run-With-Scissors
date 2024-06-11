package com.imjustdoom.dontrunwithscissors.config.neoforge;

import com.imjustdoom.dontrunwithscissors.config.Config;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ConfigImpl {

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    private static final ModConfigSpec.ConfigValue<Boolean> DAMAGE_IF_SPRINTING;
    private static final ModConfigSpec.ConfigValue<Boolean> DAMAGE_ON_FALL;
    private static final ModConfigSpec.DoubleValue SPRINTING_DAMAGE;
    private static final ModConfigSpec.DoubleValue FALL_DAMAGE; // -1 is insta kill
    private static final ModConfigSpec.DoubleValue SPRINTING_CHANCE; // chance from 0-1 for taking damage
    private static final ModConfigSpec.DoubleValue FALLING_CHANCE;
    private static final ModConfigSpec.ConfigValue<Boolean> CANCEL_SPRINTING;
    private static final ModConfigSpec.ConfigValue<Boolean> IGNORE_IN_WATER;
    private static final ModConfigSpec.ConfigValue<Boolean> IGNORE_IN_LAVA;

    private static final ModConfigSpec.ConfigValue<String> SPRINTING_DEATH_MESSAGE;
    private static final ModConfigSpec.ConfigValue<String> FALL_DEATH_MESSAGE;
    private static final ModConfigSpec.ConfigValue<String> CANCEL_SPRINTING_MESSAGE;

    static {
        BUILDER.push("settings");

        DAMAGE_IF_SPRINTING = BUILDER.define("damage-on-run", Config.DAMAGE_IF_SPRINTING);
        DAMAGE_ON_FALL = BUILDER.define("damage-on-fall", Config.DAMAGE_ON_FALL);
        SPRINTING_DAMAGE = BUILDER.defineInRange("sprinting-damage", Config.SPRINTING_DAMAGE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        FALL_DAMAGE = BUILDER.defineInRange("fall-damage", Config.FALL_DAMAGE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        SPRINTING_CHANCE = BUILDER.defineInRange("sprinting-damage-chance", Config.SPRINTING_CHANCE, 0f, 1f);
        FALLING_CHANCE = BUILDER.defineInRange("fall-damage-chance", Config.FALLING_CHANCE, 0f, 1f);
        CANCEL_SPRINTING = BUILDER.define("cancel-sprinting", Config.CANCEL_SPRINTING);
        IGNORE_IN_WATER = BUILDER.define("ignore-in-water", Config.IGNORE_IN_WATER);
        IGNORE_IN_LAVA = BUILDER.define("ignore-in-lava", Config.IGNORE_IN_LAVA);

        SPRINTING_DEATH_MESSAGE = BUILDER.define("sprinting-death-message", Config.SPRINTING_DEATH_MESSAGE);
        FALL_DEATH_MESSAGE = BUILDER.define("fall-death-message", Config.FALL_DEATH_MESSAGE);
        CANCEL_SPRINTING_MESSAGE = BUILDER.define("cancel-sprinting-message", Config.CANCEL_SPRINTING_MESSAGE);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    public static boolean isDamageIfSprinting() {
        return DAMAGE_IF_SPRINTING.get();
    }

    public static boolean isDamageOnFall() {
        return DAMAGE_ON_FALL.get();
    }

    public static float getSprintingDamage() {
        return SPRINTING_DAMAGE.get().floatValue();
    }

    public static float getFallDamage() {
        return FALL_DAMAGE.get().floatValue();
    }

    public static float getSprintingChance() {
        return SPRINTING_CHANCE.get().floatValue();
    }

    public static float getFallingChance() {
        return FALLING_CHANCE.get().floatValue();
    }

    public static boolean isCancelSprinting() {
        return CANCEL_SPRINTING.get();
    }

    public static boolean isIgnoreInWater() {
        return IGNORE_IN_WATER.get();
    }

    public static boolean isIgnoreInLava() {
        return IGNORE_IN_LAVA.get();
    }

    public static String getSprintingDeathMessage() {
        return SPRINTING_DEATH_MESSAGE.get();
    }

    public static String getFallDeathMessage() {
        return FALL_DEATH_MESSAGE.get();
    }

    public static String getCancelSprintingMessage() {
        return CANCEL_SPRINTING_MESSAGE.get();
    }
}
