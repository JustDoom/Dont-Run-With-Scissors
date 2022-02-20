package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.DontRunWithScissors;
import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DontRunWithScissors.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FallDamageListener {

    @SubscribeEvent
    public static void event(LivingFallEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        if (event.getDistance() > 3.0
                && (player.getMainHandItem().getItem() instanceof ShearsItem
                || player.getOffhandItem().getItem() instanceof ShearsItem)
                && Math.random() < DontRunConfig.fall_damage_chance.get()) {
            event.setCanceled(true);
            player.hurt(DontRunWithScissors.SHEARS_FALL, player.getHealth());
        }
    }
}
