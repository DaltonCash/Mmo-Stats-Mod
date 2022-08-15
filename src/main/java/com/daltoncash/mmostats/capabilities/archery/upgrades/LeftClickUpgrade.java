package com.daltoncash.mmostats.capabilities.archery.upgrades;

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

public class LeftClickUpgrade extends UpgradeCapability{
	
	public LeftClickUpgrade() {
		this.setNbtString("isupgradedleftclickupgrade");
	}
	
	public class LeftClickUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<LeftClickUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<LeftClickUpgrade>() {});


		private LeftClickUpgrade isUpgraded = null;
		private final LazyOptional<LeftClickUpgrade> optional = LazyOptional
				.of(this::createLeftClickUpgrade);

		private LeftClickUpgrade createLeftClickUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new LeftClickUpgrade();
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
			createLeftClickUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createLeftClickUpgrade().loadNBTData(nbt);
		}
	}
} 