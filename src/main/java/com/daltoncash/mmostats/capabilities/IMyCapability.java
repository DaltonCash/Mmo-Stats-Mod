package com.daltoncash.mmostats.capabilities;

import net.minecraft.nbt.CompoundTag;

public interface IMyCapability {
	
	 int getHLT();
     void setHLT(int HLT);

     CompoundTag serializeNBT();

     void deserializeNBT(CompoundTag nbt);
     
}
