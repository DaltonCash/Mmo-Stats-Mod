package com.daltoncash.mmostats.capabilities;

public class ClientCapabilityData {
	private static int playerMana;
	private static int playerMiningLevel;
	private static int playerMiningExp;

	//Mana
	public static int getPlayerMana() {
		return playerMana;
	}

	public static void setPlayerMana(int playerMana) {
		ClientCapabilityData.playerMana = playerMana;
	}
	
	//Mining Level
	public static int getPlayerMiningLevel() {
		return playerMiningLevel;
	}

	public static void setPlayerMiningLevel(int playerMiningLevel) {
		ClientCapabilityData.playerMiningLevel = playerMiningLevel;
	}
	
	//Mining Exp
	public static int getPlayerMiningExp() {
		return playerMiningExp;
	}

	public static void setPlayerMiningExp(int playerMiningExp) {
		ClientCapabilityData.playerMiningExp = playerMiningExp;
	}
	
}
