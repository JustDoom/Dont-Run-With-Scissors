package com.imjustdoom.dontrunwithscissors.mixin;

import com.imjustdoom.dontrunwithscissors.interfaces.DamageSourceInterface;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.CombatEntry;
import net.minecraft.world.damagesource.CombatTracker;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(CombatTracker.class)
public abstract class CombatTrackerMixin {

    @Shadow @Final private LivingEntity mob;

    @Inject(method = "getDeathMessage", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/damagesource/DamageSource;getLocalizedDeathMessage(Lnet/minecraft/world/entity/LivingEntity;)Lnet/minecraft/network/chat/Component;"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    public void getDeathMessage(CallbackInfoReturnable<Component> cir, CombatEntry combatEntry, DamageSource damageSource) {
        if (((DamageSourceInterface) damageSource).isScissors()) {
            cir.setReturnValue(Component.translatable("death.attack.scissors", this.mob.getDisplayName()));
        } else if (((DamageSourceInterface) damageSource).isFallingScissors()) {
            cir.setReturnValue(Component.translatable("death.attack.scissors_fall", this.mob.getDisplayName()));
        }
    }
}
