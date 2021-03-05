package com.justdoom.dontrunwithscissors;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerRunEvent {

    @SubscribeEvent
    public static void event(LivingEvent.LivingUpdateEvent event) {
        if (!(event.getEntity() instanceof PlayerEntity)) {
            return;
        }
        if (event.getEntity().prevDistanceWalkedModified == event.getEntity().distanceWalkedModified) {
            return;
        }
        PlayerEntity player = (PlayerEntity) event.getEntity();
        if (!player.isSprinting()) {
            return;
        }
        if (player.getHeldItemMainhand().getItem() instanceof ShearsItem && (int) (Math.random() * 10) == 0) {
            player.attackEntityFrom(DamageSource.MAGIC, 2);
        }
    }
}