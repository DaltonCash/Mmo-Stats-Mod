package com.daltoncash.mmostats.capabilities.playerlevel.stats.mana;

import com.daltoncash.mmostats.events.ModStats;

import net.minecraft.nbt.CompoundTag;

public class PlayerMana {
	private int mana;
	private final int MIN_MANA = 0;
	private final static int MAX_MANA = ModStats.getMaxMana();

	public int getMana() {
		return mana;
	}

	public static int getMaxMana() {
		return MAX_MANA;
	}

	public void addMana(int add) {
		this.mana = Math.min(mana + add, MAX_MANA);
	}

	public void subMana(int sub) {
		this.mana = Math.max(mana - sub, MIN_MANA);
	}

	public void copyFrom(PlayerMana source) {
		this.mana = source.mana;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("mana", mana);
	}

	public void loadNBTData(CompoundTag nbt) {
		mana = nbt.getInt("mana");
	}
}
