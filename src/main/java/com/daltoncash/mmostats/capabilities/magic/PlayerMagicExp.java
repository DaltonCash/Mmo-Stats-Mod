package com.daltoncash.mmostats.capabilities.magic;

import net.minecraft.nbt.CompoundTag;

public class PlayerMagicExp {

	private int magicExp;

	public int getMagicExp() {
		return magicExp;
	}

	public void addMagicExp(int add) {
		this.magicExp = magicExp + add;
	}

	public void subMagicExp(int sub) {
		this.magicExp = Math.max(magicExp - sub, 0);
	}

	public void copyFrom(PlayerMagicExp source) {
		this.magicExp = source.magicExp;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("magicexp", magicExp);
	}

	public void loadNBTData(CompoundTag nbt) {
		magicExp = nbt.getInt("magicexp");
	}  
}
