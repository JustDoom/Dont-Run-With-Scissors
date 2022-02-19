package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerRunListener {

    @SubscribeEvent
    public static void event(LivingEvent.LivingUpdateEvent event) {
        if (!(event.getEntity() instanceof PlayerEntity)) return;

        PlayerEntity player = (PlayerEntity) event.getEntity();

        if (player.prevDistanceWalkedModified == player.distanceWalkedModified
            || !player.isSprinting()) return;

        if ((player.getHeldItemMainhand().getItem() instanceof ShearsItem
                || player.getHeldItemOffhand().getItem() instanceof ShearsItem)
                && (int) (Math.random() * 10) == 0) {
            player.attackEntityFrom(DamageSource.MAGIC, 2);
        }
    }
}