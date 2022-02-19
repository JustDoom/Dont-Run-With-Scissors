package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class FallDamageListener {

    @SubscribeEvent
    public static void event(LivingFallEvent event) {
        if (!(event.getEntity() instanceof PlayerEntity)) return;

        PlayerEntity player = (PlayerEntity) event.getEntity();
        if (player.getLastDamageSource() == DamageSource.FALL
                && player.getHeldItemMainhand().getItem() instanceof ShearsItem
                && (int) (Math.random() * 5) == 0) {
            player.setHealth(0);
        }
    }
}
