package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.DontRunWithScissors;
import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemShears;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlayerRunListener {

    @SubscribeEvent
    public void event(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;

        if (player.distanceWalkedModified == player.prevDistanceWalkedModified
            || !player.isSprinting()
            || player.getHeldItem() == null) return;

        if(DontRunConfig.cancel_sprinting) {
            player.setSprinting(false);
            player.addChatMessage(new ChatComponentText(DontRunConfig.cancel_sprinting_message));
        }

        if (player.getHeldItem().getItem() == Items.shears
                && Math.random() < DontRunConfig.run_damage_chance) {

            player.attackEntityFrom(DontRunWithScissors.SHEARS, DontRunConfig.run_damage_amount == -1 ? player.getHealth() : DontRunConfig.run_damage_amount);
        }
    }
}