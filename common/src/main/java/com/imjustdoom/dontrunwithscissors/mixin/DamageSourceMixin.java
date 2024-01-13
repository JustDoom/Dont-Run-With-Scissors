package com.imjustdoom.dontrunwithscissors.mixin;

import com.imjustdoom.dontrunwithscissors.interfaces.DamageSourceInterface;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(DamageSource.class)
public abstract class DamageSourceMixin implements DamageSourceInterface {

    @Unique
    public boolean scissors;

    @Unique
    public boolean fallingScissors;

    @Override
    public void setScissors(boolean scissors) {
        this.scissors = scissors;
    }

    @Override
    public boolean isScissors() {
        return this.scissors;
    }

    @Override
    public void setFallingScissors(boolean scissors) {
        this.fallingScissors = scissors;
    }

    @Override
    public boolean isFallingScissors() {
        return this.fallingScissors;
    }
}
