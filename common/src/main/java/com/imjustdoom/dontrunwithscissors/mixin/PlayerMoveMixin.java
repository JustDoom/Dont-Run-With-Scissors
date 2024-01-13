package com.imjustdoom.dontrunwithscissors.mixin;

import com.imjustdoom.dontrunwithscissors.config.Config;
import com.imjustdoom.dontrunwithscissors.interfaces.DamageSourcesInterface;
import com.imjustdoom.dontrunwithscissors.util.ScissorsUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerGamePacketListenerImpl.class)
public abstract class PlayerMoveMixin {

    @Inject(method = "handleMovePlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;checkMovementStatistics(DDD)V"))
    public void handleMovePlayer(ServerboundMovePlayerPacket serverboundMovePlayerPacket, CallbackInfo ci) {
        ServerGamePacketListenerImpl packet = (ServerGamePacketListenerImpl) (Object) this;
        Player player = packet.player;

        if (player.isSprinting()
                && Config.damageIfSprinting
                && ScissorsUtil.isInHand(player)
                && !(Config.ignoreInWater && player.isInWater())
                && !(Config.ignoreInLava && player.isInLava())
                && Math.random() < Config.sprintingChance) {

            if (Config.cancelSprinting) {
                player.setSprinting(false);
                player.displayClientMessage(Component.translatable("warning.scissors"), true); // TODO: use lang file if config is empty
                return;
            }

            player.hurt(((DamageSourcesInterface) player.damageSources()).scissors(), Config.sprintingDamage == -1 ? player.getHealth() : Config.sprintingDamage);
        }
    }
}
