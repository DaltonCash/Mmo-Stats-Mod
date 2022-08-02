package com.daltoncash.mmostats.capabilities.mining;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerMiningExpProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerMiningExp> PLAYER_MINING_EXP = CapabilityManager.get(new CapabilityToken<PlayerMiningExp>() { });

    private PlayerMiningExp miningExp = null;
    private final LazyOptional<PlayerMiningExp> optional = LazyOptional.of(this::createPlayerMiningExp);

    private PlayerMiningExp createPlayerMiningExp() {
        if(this.miningExp == null) {
            this.miningExp = new PlayerMiningExp();
        }

        return this.miningExp;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_MINING_EXP) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerMiningExp().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerMiningExp().loadNBTData(nbt);
    }
}
