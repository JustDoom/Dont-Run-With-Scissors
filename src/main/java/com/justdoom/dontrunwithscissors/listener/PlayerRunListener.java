package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.DontRunWithScissors;
import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = DontRunWithScissors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerRunListener {

    @SubscribeEvent
    public static void event(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        if (player.walkDist == player.walkDistO || !player.isSprinting()) return;

        if ((player.getMainHandItem().getItem() instanceof ShearsItem
                || player.getOffhandItem().getItem() instanceof ShearsItem)
                && Math.random() < DontRunConfig.run_damage_chance.get()) {

            if(DontRunConfig.cancel_sprinting.get()) {
                player.setSprinting(false);
                player.displayClientMessage(Component.literal(DontRunConfig.cancel_sprinting_message.get()), true);
                return;
            }

            player.hurt(DontRunWithScissors.SHEARS, DontRunConfig.run_damage_amount.get() == -1 ? player.getHealth() : DontRunConfig.run_damage_amount.get());
        }
    }
}