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

public class SugarRushUpgrade extends UpgradeCapability{
	
	public SugarRushUpgrade() {
		this.setNbtString("isupgradedsugarrushupgrade");
	}
	
	public class SugarRushUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<SugarRushUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<SugarRushUpgrade>() {});


		private SugarRushUpgrade isUpgraded = null;
		private final LazyOptional<SugarRushUpgrade> optional = LazyOptional
				.of(this::createSugarRushUpgrade);

		private SugarRushUpgrade createSugarRushUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new SugarRushUpgrade();
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
			createSugarRushUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createSugarRushUpgrade().loadNBTData(nbt);
		}
	}
}