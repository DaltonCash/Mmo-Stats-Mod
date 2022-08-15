package com.daltoncash.mmostats.capabilities.swords.upgrades;

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

public class FleshWoundUpgrade extends UpgradeCapability{
	
	public FleshWoundUpgrade() {
		this.setNbtString("isupgradedfleshwoundupgrade");
	}
	
	public class FleshWoundUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<FleshWoundUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<FleshWoundUpgrade>() {});


		private FleshWoundUpgrade isUpgraded = null;
		private final LazyOptional<FleshWoundUpgrade> optional = LazyOptional
				.of(this::createFleshWoundUpgrade);

		private FleshWoundUpgrade createFleshWoundUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new FleshWoundUpgrade();
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
			createFleshWoundUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createFleshWoundUpgrade().loadNBTData(nbt);
		}
	}
}