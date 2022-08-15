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

public class HardwoodUpgrade extends UpgradeCapability{
	
	public HardwoodUpgrade() {
		this.setNbtString("isupgradedhardwoodupgrade");
	}
	
	public class HardwoodUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<HardwoodUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<HardwoodUpgrade>() {});


		private HardwoodUpgrade isUpgraded = null;
		private final LazyOptional<HardwoodUpgrade> optional = LazyOptional
				.of(this::createHardwoodUpgrade);

		private HardwoodUpgrade createHardwoodUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new HardwoodUpgrade();
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
			createHardwoodUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createHardwoodUpgrade().loadNBTData(nbt);
		}
	}
}