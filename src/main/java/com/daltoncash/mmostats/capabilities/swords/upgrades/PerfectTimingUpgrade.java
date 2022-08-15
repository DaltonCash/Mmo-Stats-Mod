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

public class PerfectTimingUpgrade extends UpgradeCapability{
	
	public PerfectTimingUpgrade() {
		this.setNbtString("isupgradedperfecttimingupgrade");
	}
	
	public class PerfectTimingUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<PerfectTimingUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<PerfectTimingUpgrade>() {});


		private PerfectTimingUpgrade isUpgraded = null;
		private final LazyOptional<PerfectTimingUpgrade> optional = LazyOptional
				.of(this::createPerfectTimingUpgrade);

		private PerfectTimingUpgrade createPerfectTimingUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new PerfectTimingUpgrade();
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
			createPerfectTimingUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createPerfectTimingUpgrade().loadNBTData(nbt);
		}
	}
}