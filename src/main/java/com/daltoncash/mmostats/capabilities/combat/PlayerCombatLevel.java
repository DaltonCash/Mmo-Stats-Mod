package com.daltoncash.mmostats.capabilities.combat;

import net.minecraft.nbt.CompoundTag;

public class PlayerCombatLevel {
	private int combatLevel;

	public int getCombatLevel() {
		return combatLevel;
	}

	public void addCombatLevel(int add) {
		this.combatLevel = combatLevel + add;
	}

	public void copyFrom(PlayerCombatLevel source) {
		this.combatLevel = source.combatLevel;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("combatlevel", combatLevel);
	}

	public void loadNBTData(CompoundTag nbt) {
		combatLevel = nbt.getInt("combatlevel");
	}
}
