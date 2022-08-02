package com.daltoncash.mmostats.capabilities;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.daltoncash.mmostats.MmoStatsMod;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
public class MyCapabilityAttacher{
	
	private static class MyCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag>, com.daltoncash.mmostats.capabilities.MyCapabilityProvider {

		public static final ResourceLocation IDENTIFIER = new ResourceLocation(MmoStatsMod.MODID, "capabilities/mana");

		private final IMyCapability backend = new MyCapabilityImplementation();
		private final LazyOptional<IMyCapability> optionalData = LazyOptional.of(() -> backend);

		@NotNull
		@Override
		public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
			return Capabilities.PLAYER_CAPABILITIES.orEmpty(cap, this.optionalData);
		}

		@SuppressWarnings("unused")
		void invalidate() {
			this.optionalData.invalidate();
		}

		@Override
		public CompoundTag serializeNBT() {
			return this.backend.serializeNBT();
		}

		@Override
		public void deserializeNBT(CompoundTag nbt) {
			this.backend.deserializeNBT(nbt);
		}
	}

public static void attach(final AttachCapabilitiesEvent<Entity> event) {
    final MyCapabilityProvider provider = new MyCapabilityProvider();

    event.addCapability(MyCapabilityProvider.IDENTIFIER, provider);
}

	private MyCapabilityAttacher() {
	}
}
