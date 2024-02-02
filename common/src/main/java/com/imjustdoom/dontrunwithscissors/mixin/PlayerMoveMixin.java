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
                && Config.isDamageIfSprinting()
                && ScissorsUtil.isInHand(player)
                && !(Config.isIgnoreInWater() && player.isInWater())
                && !(Config.isIgnoreInLava() && player.isInLava())) {

            if (Config.isCancelSprinting()) {
//                player.setSprinting(false);
                player.displayClientMessage(Component.translatable(Config.getCancelSprintingMessage() == null ? "warning.scissors" : Config.getCancelSprintingMessage()), true);
                return;
            }

            if (Math.random() < Config.getSprintingChance()) {
                player.hurt(((DamageSourcesInterface) player.damageSources()).scissors(), Config.getSprintingDamage() == -1 ? player.getHealth() : Config.getSprintingDamage());
            }
        }
    }
}
