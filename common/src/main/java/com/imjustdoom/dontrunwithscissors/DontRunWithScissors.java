package com.imjustdoom.dontrunwithscissors;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;

public class DontRunWithScissors {
    public static final String MOD_ID = "dontrunwithscissors";

    public static void init() {

        
    }

    public static boolean isScissorsItem(ItemStack itemStack) {
        return itemStack.getItem() instanceof ShearsItem;
    }
}
