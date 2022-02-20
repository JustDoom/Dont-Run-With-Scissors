package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerRunListener {

    @SubscribeEvent
    public static void event(LivingEvent.LivingUpdateEvent event) {
        if (!(event.getEntity() instanceof PlayerEntity)) return;

        PlayerEntity player = (PlayerEntity) event.getEntity();

        if (player.walkDist == player.walkDistO
            || !player.isSprinting()) return;

        if ((player.getMainHandItem().getItem() instanceof ShearsItem
                || player.getOffhandItem().getItem() instanceof ShearsItem)
                && (int) (Math.random() * 10) == 0) { // TODO: change way to randomly get if player will be damaged

            player.hurt(DamageSource.MAGIC, 2);
        }
    }

    @SubscribeEvent
    public static void playerSpawnEvent(LivingSpawnEvent event) {
        if(event.getEntity() instanceof PlayerEntity) {
            ((PlayerEntity) event.getEntity()).inventory.add(new ItemStack(Items.SHEARS.getItem()));
        }
    }
}