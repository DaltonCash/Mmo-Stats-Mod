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

public class RagnorokUpgrade extends UpgradeCapability{
	
	public RagnorokUpgrade() {
		this.setNbtString("isupgradedragnorokupgrade");
	}
	
	public class RagnorokUpgradeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

		public static Capability<RagnorokUpgrade> IS_UPGRADED = CapabilityManager
				.get(new CapabilityToken<RagnorokUpgrade>() {});


		private RagnorokUpgrade isUpgraded = null;
		private final LazyOptional<RagnorokUpgrade> optional = LazyOptional
				.of(this::createRagnorokUpgrade);

		private RagnorokUpgrade createRagnorokUpgrade() {
			if (this.isUpgraded == null) {
				this.isUpgraded = new RagnorokUpgrade();
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
			createRagnorokUpgrade().saveNBTData(nbt);
			return nbt;
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			createRagnorokUpgrade().loadNBTData(nbt);
		}
	}
}