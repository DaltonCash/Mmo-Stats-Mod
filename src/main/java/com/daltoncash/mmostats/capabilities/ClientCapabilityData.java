package com.daltoncash.mmostats.capabilities;

public class ClientCapabilityData {
	private static int playerMana;
	private static int playerMiningLevel;
	private static int playerMiningExp;
	private static boolean isUpgradedNightVision;
	private static boolean isUpgradedNoJunkBlocks;
	private static boolean isUpgradedJunkBlocksDropExp;
	private static boolean isUpgradedObsidianBreaker;

	// Mana
	public static int getPlayerMana() {
		return playerMana;
	}

	public static void setPlayerMana(int playerMana) {
		ClientCapabilityData.playerMana = playerMana;
	}

	// Mining Level
	public static int getPlayerMiningLevel() {
		return playerMiningLevel;
	}

	public static void setPlayerMiningLevel(int playerMiningLevel) {
		ClientCapabilityData.playerMiningLevel = playerMiningLevel;
	}

	// Mining Exp
	public static int getPlayerMiningExp() {
		return playerMiningExp;
	}

	public static void setPlayerMiningExp(int playerMiningExp) {
		ClientCapabilityData.playerMiningExp = playerMiningExp;
	}
    //Upgrades
	public static boolean isUpgradedNightVision() {
		return isUpgradedNightVision;
	}

	public static void setUpgradedNightVision(boolean isUpgradedNightVision) {
		ClientCapabilityData.isUpgradedNightVision = isUpgradedNightVision;
	}

	public static boolean isUpgradedNoJunkBlocks() {
		return isUpgradedNoJunkBlocks;
	}

	public static void setUpgradedNoJunkBlocks(boolean isUpgradedNoJunkBlocks) {
		ClientCapabilityData.isUpgradedNoJunkBlocks = isUpgradedNoJunkBlocks;
	}

	public static boolean isUpgradedJunkBlocksDropExp() {
		return isUpgradedJunkBlocksDropExp;
	}

	public static void setUpgradedJunkBlocksDropExp(boolean isUpgradedJunkBlocksDropExp) {
		ClientCapabilityData.isUpgradedJunkBlocksDropExp = isUpgradedJunkBlocksDropExp;
	}

	public static boolean isUpgradedObsidianBreaker() {
		return isUpgradedObsidianBreaker;
	}

	public static void setUpgradedObsidianBreaker(boolean isUpgradedObsidianBreaker) {
		ClientCapabilityData.isUpgradedObsidianBreaker = isUpgradedObsidianBreaker;
	}

}
