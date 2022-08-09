package com.daltoncash.mmostats.capabilities.combat;



import net.minecraft.nbt.CompoundTag;

public class PlayerCombatExp {
	private int combatExp;

	public int getCombatExp() {
		return combatExp;
	}

	public void addCombatExp(int add) {
		this.combatExp = combatExp + add;
	}

	public void copyFrom(PlayerCombatExp source) {
		this.combatExp = source.combatExp;
	}

	public void saveNBTData(CompoundTag nbt) {
		nbt.putInt("combatexp", combatExp);
	}

	public void loadNBTData(CompoundTag nbt) {
		combatExp = nbt.getInt("combatexp");
	}
}
