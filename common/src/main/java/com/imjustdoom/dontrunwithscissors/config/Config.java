package com.imjustdoom.dontrunwithscissors.config;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class Config {

    // Defaults
    public static final boolean DAMAGE_IF_SPRINTING = true;
    public static final boolean DAMAGE_ON_FALL = true;
    public static final float SPRINTING_DAMAGE = 2f;
    public static final float FALL_DAMAGE = -1; // -1 is insta kill
    public static final float SPRINTING_CHANCE = 0.1f; // chance from 0-1 for taking damage
    public static final float FALLING_CHANCE = 0.1f;
    public static final boolean CANCEL_SPRINTING = false;
    public static final boolean IGNORE_IN_WATER = true;
    public static final boolean IGNORE_IN_LAVA = true;

    public static final String SPRINTING_DEATH_MESSAGE = "%1$s was running with scissors!";
    public static final String FALL_DEATH_MESSAGE = "%1$s tripped and fell on their scissors";
    public static final String CANCEL_SPRINTING_MESSAGE = "Oi, Don't run with scissors (shears)";

    // TODO: maybe take armour into account or something?

    @ExpectPlatform
    public static boolean isDamageIfSprinting() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isDamageOnFall() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static float getSprintingDamage() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static float getFallDamage() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static float getSprintingChance() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static float getFallingChance() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isCancelSprinting() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isIgnoreInWater() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isIgnoreInLava() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static String getSprintingDeathMessage() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static String getFallDeathMessage() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static String getCancelSprintingMessage() {
        throw new AssertionError();
    }
}
