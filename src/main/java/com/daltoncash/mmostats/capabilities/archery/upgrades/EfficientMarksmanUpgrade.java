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

public class EfficientMarksmanUpgrade extends UpgradeCapability{
	
	public EfficientMarksmanUpgrade() {
		this.setNbtString("isupgradedefficientmarksmanupgrade");
	}
	
	public class EfficientMarksmanUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<EfficientMarksmanUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<EfficientMarksmanUpgrade>() {});


		private EfficientMarksmanUpgrade isUpgraded = null;
		private final LazyOptional<EfficientMarksmanUpgrade> optional = LazyOptional
				.of(this::createEfficientMarksmanUpgrade);

		private EfficientMarksmanUpgrade createEfficientMarksmanUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new EfficientMarksmanUpgrade();
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
			createEfficientMarksmanUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createEfficientMarksmanUpgrade().loadNBTData(nbt);
		}
	}
}
