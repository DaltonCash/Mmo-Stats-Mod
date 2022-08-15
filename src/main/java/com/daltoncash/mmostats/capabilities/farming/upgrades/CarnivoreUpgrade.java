package com.daltoncash.mmostats.capabilities.farming.upgrades;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.daltoncash.mmostats.capabilities.UpgradeCapability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class CarnivoreUpgrade extends UpgradeCapability{
	
	public CarnivoreUpgrade() {
		this.setNbtString("isupgradedcarnivoreupgrade");
	}
	
	public class CarnivoreUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<CarnivoreUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<CarnivoreUpgrade>() {});


		private CarnivoreUpgrade isUpgraded = null;
		private final LazyOptional<CarnivoreUpgrade> optional = LazyOptional
				.of(this::createCarnivoreUpgrade);

		private CarnivoreUpgrade createCarnivoreUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new CarnivoreUpgrade();
			}
			return this.isUpgraded;
		}

		@Override
		public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
			if (cap == IS_UPGRADED) {
				return optional.cast();
			}
			return LazyOptional.empty();
		}

		@Override
		public CompoundTag serializeNBT() {
			CompoundTag nbt = new CompoundTag();
			createCarnivoreUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createCarnivoreUpgrade().loadNBTData(nbt);
		}
	}
}