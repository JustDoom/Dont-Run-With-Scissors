package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.DontRunWithScissors;
import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DontRunWithScissors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerRunListener {

    @SubscribeEvent
    public static void event(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;

        if (player.walkDist == player.walkDistO
            || !player.isSprinting()) return;

        if ((player.getMainHandItem().getItem() instanceof ShearsItem
                || player.getOffhandItem().getItem() instanceof ShearsItem)
                && Math.random() < DontRunConfig.run_damage_chance.get()) {

            if(DontRunConfig.cancel_sprinting.get()) {
                player.setSprinting(false);
                player.displayClientMessage(new TranslationTextComponent(DontRunConfig.cancel_sprinting_message.get()), true);
                return;
            }

            player.hurt(DontRunWithScissors.SHEARS, DontRunConfig.run_damage_amount.get() == -1 ? player.getHealth() : DontRunConfig.run_damage_amount.get());
        }
    }
}