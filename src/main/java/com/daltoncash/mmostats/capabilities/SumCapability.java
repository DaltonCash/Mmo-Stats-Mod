package com.daltoncash.mmostats.capabilities;

import net.minecraft.nbt.CompoundTag;

public class SumCapability {
	private int sum;
	private String nbtString;

	protected SumCapability(String nbtString){
		this.nbtString = nbtString;
	}
	
	public SumCapability() {
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public void addSum(int sum) {
		this.sum += sum;
	}

	public void copyFrom(SumCapability source) {
		this.sum = source.sum;
	}
	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt(getNbtString(), getSum());
	}

	public void loadNBTData(CompoundTag nbt) {
		setSum(nbt.getInt(getNbtString()));
	}

	public String getNbtString() {
		return nbtString;
	}

	public void setNbtString(String nbtString) {
		this.nbtString = nbtString;
	}
}
