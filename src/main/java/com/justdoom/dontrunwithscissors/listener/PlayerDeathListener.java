package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.DontRunWithScissors;
import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DontRunWithScissors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerDeathListener {

    @SubscribeEvent
    public static void event(LivingDeathEvent event) {
        if(!(event.getEntity() instanceof Player player)) return;

        if(event.getSource() == DontRunWithScissors.SHEARS
                || event.getSource() == DontRunWithScissors.SHEARS_FALL) {
            player.awardStat(DontRunWithScissors.SHEAR_DEATHS.get(), 1);
        }
    }
}