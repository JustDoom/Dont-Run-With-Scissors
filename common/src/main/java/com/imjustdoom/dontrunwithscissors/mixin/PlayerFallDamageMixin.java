package com.imjustdoom.dontrunwithscissors.mixin;

import com.imjustdoom.dontrunwithscissors.config.Config;
import com.imjustdoom.dontrunwithscissors.interfaces.DamageSourcesInterface;
import com.imjustdoom.dontrunwithscissors.util.ScissorsUtil;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class PlayerFallDamageMixin {

    @Inject(method = "causeFallDamage", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z", shift = At.Shift.AFTER))
    public void causeFallDamage(float f, float g, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (!entity.level().isClientSide
                && Config.isDamageOnFall()
                && ScissorsUtil.isInHand(entity)
                && Math.random() < Config.getFallingChance()) {
            entity.hurt(((DamageSourcesInterface) entity.damageSources()).fallingScissors(), Config.getFallDamage() == -1 ? entity.getHealth() : Config.getFallDamage());
        }
    }
}
