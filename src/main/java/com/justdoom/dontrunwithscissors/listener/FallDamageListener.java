package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.DontRunWithScissors;
import com.justdoom.dontrunwithscissors.config.DontRunConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemShears;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = DontRunWithScissors.MOD_ID)
public class FallDamageListener {

    @SubscribeEvent
    public static void event(LivingFallEvent event) {
        if (!(event.getEntity() instanceof EntityPlayer)) return;

        EntityPlayer player = (EntityPlayer) event.getEntity();
        if (event.getDistance() > 3.0
                && (player.getHeldItemMainhand().getItem() instanceof ItemShears
                || player.getHeldItemOffhand().getItem() instanceof ItemShears)
                && Math.random() < DontRunConfig.fall_damage_chance) {
            event.setCanceled(true);
            player.attackEntityFrom(DontRunWithScissors.SHEARS_FALL, player.getHealth());
        }
    }
}
