package com.imjustdoom.dontrunwithscissors.config.fabric;

import com.imjustdoom.dontrunwithscissors.config.Config;
import com.imjustdoom.dontrunwithscissors.config.SimpleConfig;

public class ConfigImpl {

    private static final SimpleConfig CONFIG = SimpleConfig.of("dont-run-with-scissors-config").provider(ConfigImpl::provider).request();

    public static boolean DAMAGE_IF_SPRINTING;
    public static boolean DAMAGE_ON_FALL;
    public static float SPRINTING_DAMAGE;
    public static float FALL_DAMAGE; // -1 is insta kill
    public static float SPRINTING_CHANCE; // chance from 0-1 for taking damage
    public static float FALLING_CHANCE;
    public static boolean CANCEL_SPRINTING;
    public static boolean IGNORE_IN_WATER;
    public static boolean IGNORE_IN_LAVA;

    public static String SPRINTING_DEATH_MESSAGE;
    public static String FALL_DEATH_MESSAGE;
    public static String CANCEL_SPRINTING_MESSAGE;

    private static String provider(String filename) {
        return "# Settings" +
                "\n#Is enabled?" +
                "\ndamage-on-run=" + Config.DAMAGE_IF_SPRINTING +
                "\ndamage-on-fall=" + Config.DAMAGE_ON_FALL +
                "\n#Damage, -1 is insta kill" +
                "\nsprinting-damage=" + Config.SPRINTING_DAMAGE +
                "\nfall-damage=" + Config.FALL_DAMAGE +
                "\n#Change to take damage, 0 is 0%, 0.5 is 50% and 1 is 100%" +
                "\nsprinting-damage-chance=" + Config.SPRINTING_CHANCE +
                "\nfall-damage-chance=" + Config.FALLING_CHANCE +
                "\n#Currently doesnt cancel the message, only a warning as of now" +
                "\ncancel-sprinting=" + Config.CANCEL_SPRINTING +
                "\n#Should the player be damaged if swimming" +
                "\nignore-in-water=" + Config.IGNORE_IN_WATER +
                "\nignore-in-lava=" + Config.IGNORE_IN_LAVA +
                "\n" +
                "\nsprinting-death-message=" + Config.SPRINTING_DEATH_MESSAGE +
                "\nfall-death-message=" + Config.FALL_DEATH_MESSAGE +
                "\ncancel-sprinting-message=" + Config.CANCEL_SPRINTING_MESSAGE;
    }

    public static boolean isDamageIfSprinting() {
        return CONFIG.getOrDefault("damage-on-run", Config.DAMAGE_IF_SPRINTING);
    }

    public static boolean isDamageOnFall() {
        return CONFIG.getOrDefault("damage-on-fall", Config.DAMAGE_ON_FALL);
    }

    public static float getSprintingDamage() {
        return (float) CONFIG.getOrDefault("sprinting-damage", Config.SPRINTING_DAMAGE);
    }

    public static float getFallDamage() {
        return (float) CONFIG.getOrDefault("fall-damage", Config.FALL_DAMAGE);
    }

    public static float getSprintingChance() {
        return (float) CONFIG.getOrDefault("sprinting-damage-chance", Config.SPRINTING_DAMAGE);
    }

    public static float getFallingChance() {
        return (float) CONFIG.getOrDefault("fall-damage-chance", Config.FALLING_CHANCE);
    }

    public static boolean isCancelSprinting() {
        return CONFIG.getOrDefault("cancel-sprinting", Config.CANCEL_SPRINTING);
    }

    public static boolean isIgnoreInWater() {
        return CONFIG.getOrDefault("ignore-in-water", Config.IGNORE_IN_WATER);
    }

    public static boolean isIgnoreInLava() {
        return CONFIG.getOrDefault("ignore-in-lava", Config.IGNORE_IN_LAVA);
    }

    public static String getSprintingDeathMessage() {
        return CONFIG.getOrDefault("sprinting-death-message", Config.SPRINTING_DEATH_MESSAGE);
    }

    public static String getFallDeathMessage() {
        return CONFIG.getOrDefault("fall-death-message", Config.FALL_DEATH_MESSAGE);
    }

    public static String getCancelSprintingMessage() {
        return CONFIG.getOrDefault("cancel-sprinting-message", Config.CANCEL_SPRINTING_MESSAGE);
    }
}
