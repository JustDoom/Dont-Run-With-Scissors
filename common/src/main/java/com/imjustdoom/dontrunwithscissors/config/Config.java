package com.imjustdoom.dontrunwithscissors.config;

public class Config {

    public static final boolean damageIfSprinting = true;
    public static final boolean damageOnFall = true;
    public static final float sprintingDamage = 2f;
    public static final float fallDamage = -1; // -1 is insta kill
    public static final float sprintingChance = 0.01f; // chance from 0-1 for taking damage
    public static final float fallingChance = 0.1f;
    public static final boolean cancelSprinting = false;
    public static final boolean ignoreInWater = true;
    public static final boolean ignoreInLava = true;

    public static final String sprintingDeathMessage = "%1$s was running with scissors!"; // TODO: if empty use the default lang file one
    public static final String fallDeathMessage = "%1$s tripped and fell on their scissors";
    public static final String cancelSprintingMessage = "Oi, Don't run with scissors (shears)";

    // TODO: maybe take armour into account or something?
}
