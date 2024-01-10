package com.imjustdoom.dontrunwithscissors.mixin;

import com.imjustdoom.dontrunwithscissors.DontRunWithScissors;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.InteractionHand;
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
                && (DontRunWithScissors.isScissorsItem(player.getItemInHand(InteractionHand.MAIN_HAND))
                || DontRunWithScissors.isScissorsItem(player.getItemInHand(InteractionHand.OFF_HAND)))
                && (int) (Math.random() * 10) == 0) {
            player.hurt(player.damageSources().magic(), 2f);
        }
    }
}
