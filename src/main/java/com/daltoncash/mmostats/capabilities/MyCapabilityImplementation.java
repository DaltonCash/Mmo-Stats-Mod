package com.daltoncash.mmostats.capabilities;

import net.minecraft.nbt.CompoundTag;

public class MyCapabilityImplementation implements IMyCapability{

	 private int HLT = 1;

	    @Override
	    public int getHLT() {
	        return HLT;
	    }

	    @Override
	    public void setHLT(int HLT) {
	        this.HLT = HLT;
	    }

	    @Override
	    public CompoundTag serializeNBT() {
	        CompoundTag nbt = new CompoundTag();
	        nbt.putInt("hlt", this.HLT);
	        return nbt;
	    }

	    @Override
	    public void deserializeNBT(CompoundTag nbt) {
	        this.HLT = nbt.getInt("hlt");
	    }
}
