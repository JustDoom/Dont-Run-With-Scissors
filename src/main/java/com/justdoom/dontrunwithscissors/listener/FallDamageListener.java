package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.DontRunWithScissors;
import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemShears;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FallDamageListener {

    @SubscribeEvent
    public void event(LivingFallEvent event) {
        if (!(event.entity instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) event.entity;
        if (player.getHeldItem() != null
                && event.distance > 3.0
                && player.getHeldItem().getItem() == Items.shears
                && Math.random() < DontRunConfig.fall_damage_chance) {
            player.attackEntityFrom(DontRunWithScissors.SHEARS_FALL, player.getHealth());
        }
    }
}
