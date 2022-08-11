package com.daltoncash.mmostats.capabilities.chopping;

import net.minecraft.nbt.CompoundTag;

public class PlayerChoppingExp {
	private int choppingExp;

	public int getChoppingExp() {
		return choppingExp;
	}

	public void addChoppingExp(int add) {
		this.choppingExp = choppingExp + add;
	}
	
	public void subChoppingExp(int sub) {
		this.choppingExp = Math.max(choppingExp - sub, 0);
	}

	public void copyFrom(PlayerChoppingExp source) {
		this.choppingExp = source.choppingExp;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("choppingexp", choppingExp);
	}

	public void loadNBTData(CompoundTag nbt) {
		choppingExp = nbt.getInt("choppingexp");
	}
}
