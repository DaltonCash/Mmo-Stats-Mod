package com.daltoncash.mmostats.capabilities.mining.upgrades.blocksMined;

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

public class NetherGoldMinedProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
	public static Capability<NetherGoldMined> NETHER_GOLD_MINED = CapabilityManager
			.get(new CapabilityToken<NetherGoldMined>() {
			});

	private NetherGoldMined total = null;
	private final LazyOptional<NetherGoldMined> optional = LazyOptional.of(this::createNetherGoldMined);

	private NetherGoldMined createNetherGoldMined() {
		if (this.total == null) {
			this.total = new NetherGoldMined();
		}

		return this.total;
	}

	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if (cap == NETHER_GOLD_MINED) {
			return optional.cast();
		}

		return LazyOptional.empty();
	}

	@Override
	public CompoundTag serializeNBT() {
		CompoundTag nbt = new CompoundTag();
		createNetherGoldMined().saveNBTData(nbt);
		return nbt;
	}

	@Override
	public void deserializeNBT(CompoundTag nbt) {
		createNetherGoldMined().loadNBTData(nbt);
	}

}
