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

public class PlayerMiningLevelProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerMiningLevel> PLAYER_MINING_LEVEL = CapabilityManager.get(new CapabilityToken<PlayerMiningLevel>() { });

    private PlayerMiningLevel miningLevel = null;
    private final LazyOptional<PlayerMiningLevel> optional = LazyOptional.of(this::createPlayerMiningLevel);

    private PlayerMiningLevel createPlayerMiningLevel() {
        if(this.miningLevel == null) {
            this.miningLevel = new PlayerMiningLevel();
        }

        return this.miningLevel;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PLAYER_MINING_LEVEL) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerMiningLevel().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerMiningLevel().loadNBTData(nbt);
    }
}