package com.imjustdoom.dontrunwithscissors.mixin;

import com.imjustdoom.dontrunwithscissors.interfaces.DamageSourceInterface;
import com.imjustdoom.dontrunwithscissors.interfaces.DamageSourcesInterface;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(DamageSources.class)
public abstract class DamageSourcesMixin implements DamageSourcesInterface {

    @Shadow protected abstract DamageSource source(ResourceKey<DamageType> arg);

    @Unique
    public DamageSource scissors() {
        DamageSource scissors = this.source(DamageTypes.MAGIC);
        ((DamageSourceInterface) scissors).setScissors(true);
        return scissors;
    }

    @Unique
    public DamageSource fallingScissors() {
        DamageSource scissors = this.source(DamageTypes.MAGIC);
        ((DamageSourceInterface) scissors).setFallingScissors(true);
        return scissors;
    }
}
