package com.imjustdoom.dontrunwithscissors.util;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;

public class ScissorsUtil {

    public static boolean isScissorsItem(ItemStack itemStack) {
        return itemStack.getItem() instanceof ShearsItem;
    }

    public static boolean isInHand(LivingEntity entity) {
        return isScissorsItem(entity.getItemInHand(InteractionHand.MAIN_HAND)) || isScissorsItem(entity.getItemInHand(InteractionHand.OFF_HAND));
    }
}
