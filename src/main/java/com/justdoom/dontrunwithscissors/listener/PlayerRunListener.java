package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.Main;
import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
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

        if(DontRunConfig.cancel_sprinting.get()) {
            player.setSprinting(false);
            player.sendMessage(new TranslationTextComponent(DontRunConfig.cancel_sprinting_message.get()), player.getUUID());
        }

        if ((player.getMainHandItem().getItem() instanceof ShearsItem
                || player.getOffhandItem().getItem() instanceof ShearsItem)
                && Math.random() > DontRunConfig.run_damage_chance.get()) {

            player.hurt(Main.SHEARS, DontRunConfig.run_damage_amount.get() == -1 ? Float.MAX_VALUE : DontRunConfig.run_damage_amount.get());
        }
    }
}