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

public class OvercomeUpgrade extends UpgradeCapability{
	
	public OvercomeUpgrade() {
		this.setNbtString("isupgradedovercomeupgrade");
	}
	
	public class OvercomeUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<OvercomeUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<OvercomeUpgrade>() {});


		private OvercomeUpgrade isUpgraded = null;
		private final LazyOptional<OvercomeUpgrade> optional = LazyOptional
				.of(this::createOvercomeUpgrade);

		private OvercomeUpgrade createOvercomeUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new OvercomeUpgrade();
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
			createOvercomeUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createOvercomeUpgrade().loadNBTData(nbt);
		}
	}
}