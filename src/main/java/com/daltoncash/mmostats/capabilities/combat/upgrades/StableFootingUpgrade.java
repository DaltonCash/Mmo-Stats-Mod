package com.daltoncash.mmostats.capabilities.combat.upgrades;

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

public class StableFootingUpgrade extends UpgradeCapability{
	
	public StableFootingUpgrade() {
		this.setNbtString("isupgradedstablefootingupgrade");
	}
	
	public class StableFootingUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<StableFootingUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<StableFootingUpgrade>() {});


		private StableFootingUpgrade isUpgraded = null;
		private final LazyOptional<StableFootingUpgrade> optional = LazyOptional
				.of(this::createStableFootingUpgrade);

		private StableFootingUpgrade createStableFootingUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new StableFootingUpgrade();
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
			createStableFootingUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createStableFootingUpgrade().loadNBTData(nbt);
		}
	}
}