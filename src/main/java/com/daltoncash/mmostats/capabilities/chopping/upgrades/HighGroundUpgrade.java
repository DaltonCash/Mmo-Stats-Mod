package com.daltoncash.mmostats.capabilities.chopping.upgrades;

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

public class HighGroundUpgrade extends UpgradeCapability{
	
	public HighGroundUpgrade() {
		this.setNbtString("isupgradedhighgroundupgrade");
	}
	
	public class HighGroundUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<HighGroundUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<HighGroundUpgrade>() {});


		private HighGroundUpgrade isUpgraded = null;
		private final LazyOptional<HighGroundUpgrade> optional = LazyOptional
				.of(this::createHighGroundUpgrade);

		private HighGroundUpgrade createHighGroundUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new HighGroundUpgrade();
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
			createHighGroundUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createHighGroundUpgrade().loadNBTData(nbt);
		}
	}
}