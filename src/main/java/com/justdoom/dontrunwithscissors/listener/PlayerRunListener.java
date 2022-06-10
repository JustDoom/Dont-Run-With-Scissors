package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.DontRunWithScissors;
import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import ibxm.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemShears;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber(modid = DontRunWithScissors.MOD_ID)
public class PlayerRunListener {

    @SubscribeEvent
    public static void event(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;

        if (player.distanceWalkedModified == player.prevDistanceWalkedModified
            || !player.isSprinting()) return;

        if ((player.getHeldItemMainhand().getItem() instanceof ItemShears
                || player.getHeldItemOffhand().getItem() instanceof ItemShears)
                && Math.random() < DontRunConfig.run_damage_chance) {

            if(DontRunConfig.cancel_sprinting) {
                player.setSprinting(false);
                player.sendMessage(new TextComponentTranslation(DontRunConfig.cancel_sprinting_message));
                return;
            }

            player.attackEntityFrom(DontRunWithScissors.SHEARS, DontRunConfig.run_damage_amount == -1 ? player.getHealth() : DontRunConfig.run_damage_amount);
        }
    }
}