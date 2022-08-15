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

public class RightClickUpgrade extends UpgradeCapability{
	
	public RightClickUpgrade() {
		this.setNbtString("isupgradedrightclickupgrade");
	}
	
	public class RightClickUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<RightClickUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<RightClickUpgrade>() {});


		private RightClickUpgrade isUpgraded = null;
		private final LazyOptional<RightClickUpgrade> optional = LazyOptional
				.of(this::createRightClickUpgrade);

		private RightClickUpgrade createRightClickUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new RightClickUpgrade();
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
			createRightClickUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createRightClickUpgrade().loadNBTData(nbt);
		}
	}
}