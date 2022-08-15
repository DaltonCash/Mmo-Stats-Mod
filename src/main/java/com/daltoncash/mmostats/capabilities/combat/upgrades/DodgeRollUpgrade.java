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

public class DodgeRollUpgrade extends UpgradeCapability{
	
	public DodgeRollUpgrade() {
		this.setNbtString("isupgradeddodgerollupgrade");
	}
	
	public class DodgeRollUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<DodgeRollUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<DodgeRollUpgrade>() {});


		private DodgeRollUpgrade isUpgraded = null;
		private final LazyOptional<DodgeRollUpgrade> optional = LazyOptional
				.of(this::createDodgeRollUpgrade);

		private DodgeRollUpgrade createDodgeRollUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new DodgeRollUpgrade();
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
			createDodgeRollUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createDodgeRollUpgrade().loadNBTData(nbt);
		}
	}
}