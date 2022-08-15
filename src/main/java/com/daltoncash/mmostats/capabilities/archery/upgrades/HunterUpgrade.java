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

public class HunterUpgrade extends UpgradeCapability{
	
	public HunterUpgrade() {
		this.setNbtString("isupgradedhunterupgrade");
	}
	
	public class HunterUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<HunterUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<HunterUpgrade>() {});


		private HunterUpgrade isUpgraded = null;
		private final LazyOptional<HunterUpgrade> optional = LazyOptional
				.of(this::createHunterUpgrade);

		private HunterUpgrade createHunterUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new HunterUpgrade();
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
			createHunterUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createHunterUpgrade().loadNBTData(nbt);
		}
	}
}