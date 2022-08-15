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

public class FreeArrowsUpgrade extends UpgradeCapability{
	
	public FreeArrowsUpgrade() {
		this.setNbtString("isupgradedfreearrowsupgrade");
	}
	
	public class FreeArrowsUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<FreeArrowsUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<FreeArrowsUpgrade>() {});


		private FreeArrowsUpgrade isUpgraded = null;
		private final LazyOptional<FreeArrowsUpgrade> optional = LazyOptional
				.of(this::createFreeArrowsUpgrade);

		private FreeArrowsUpgrade createFreeArrowsUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new FreeArrowsUpgrade();
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
			createFreeArrowsUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createFreeArrowsUpgrade().loadNBTData(nbt);
		}
	}
}