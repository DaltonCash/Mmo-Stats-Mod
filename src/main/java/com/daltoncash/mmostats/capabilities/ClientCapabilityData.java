package com.daltoncash.mmostats.capabilities;

public class ClientCapabilityData {
	//Core Levels
	private static int playerMana;
	private static int playerMiningLevel;
	private static int playerMiningExp;
	private static int playerArcheryLevel;
	private static int playerArcheryExp;
	private static int playerChoppingLevel;
	private static int playerChoppingExp;
	private static int playerCombatLevel;
	private static int playerCombatExp;
	private static int playerFarmingLevel;
	private static int playerFarmingExp;
	private static int playerSwordsLevel;
	private static int playerSwordsExp;
	private static int playerMagicLevel;
	private static int playerMagicExp;
	
	//archery
	private static boolean isUpgradedEfficientMarksman;
	private static boolean isUpgradedHunter;
	private static boolean isUpgradedInsecurity;
	private static boolean isUpgradedLeftClick;
	private static boolean isUpgradedQuickshot;
	private static boolean isUpgradedSharpshooter;
	private static boolean isUpgradedSniper;
	private static boolean isUpgradedSweetSpotArchery;
	private static boolean isUpgradedUnabated;
	//chopping
	private static boolean isUpgradedGrannySmith;
	private static boolean isUpgradedHardWood;
	private static boolean isUpgradedHighGround;
	private static boolean isUpgradedStrongArms;
	//combat
	private static boolean isUpgradedDodgeRoll;
	private static boolean isUpgradedFreeArrows;
	private static boolean isUpgradedOvercome;
	private static boolean isUpgradedRagnorok;
	private static boolean isUpgradedStableFooting;
	private static boolean isUpgradedTakeStance;
	//farming
	private static boolean isUpgradedCarnivore;
	private static boolean isUpgradedEgger;
	private static boolean isUpgradedSugarRush;
	private static boolean isUpgradedWellFed;
	//swords
	private static boolean isUpgradedCritastic;
	private static boolean isUpgradedFleshWound;
	private static boolean isUpgradedPerfectTiming;
	private static boolean isUpgradedRightClick;
	private static boolean isUpgradedShieldBash;
	private static boolean isUpgradedSweetSpotSwords;
	//mining
	private static boolean isUpgradedNightVision;
	private static boolean isUpgradedNoJunkBlocks;
	private static boolean isUpgradedJunkBlocksDropExp;
	private static boolean isUpgradedObsidianBreaker;
	//Blocks Mined
	private static int ancientDebrisMined;
	private static int coalMined;
	private static int copperMined;
	private static int diamondMined;
	private static int emeraldMined;
	private static int glowstoneMined;
	private static int goldMined;
	private static int ironMined;
	private static int lapisMined;
	private static int netherGoldMined;
	private static int quartzMined;
	private static int redstoneMined;

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

	public static int getAncientDebrisMined() {
		return ancientDebrisMined;
	}

	public static void setAncientDebrisMined(int ancientDebrisMined) {
		ClientCapabilityData.ancientDebrisMined = ancientDebrisMined;
	}

	public static int getCoalMined() {
		return coalMined;
	}

	public static void setCoalMined(int coalMined) {
		ClientCapabilityData.coalMined = coalMined;
	}

	public static int getCopperMined() {
		return copperMined;
	}

	public static void setCopperMined(int copperMined) {
		ClientCapabilityData.copperMined = copperMined;
	}

	public static int getDiamondMined() {
		return diamondMined;
	}

	public static void setDiamondMined(int diamondMined) {
		ClientCapabilityData.diamondMined = diamondMined;
	}

	public static int getEmeraldMined() {
		return emeraldMined;
	}

	public static void setEmeraldMined(int emeraldMined) {
		ClientCapabilityData.emeraldMined = emeraldMined;
	}

	public static int getGlowstoneMined() {
		return glowstoneMined;
	}

	public static void setGlowstoneMined(int glowstoneMined) {
		ClientCapabilityData.glowstoneMined = glowstoneMined;
	}

	public static int getGoldMined() {
		return goldMined;
	}

	public static void setGoldMined(int goldMined) {
		ClientCapabilityData.goldMined = goldMined;
	}

	public static int getIronMined() {
		return ironMined;
	}

	public static void setIronMined(int ironMined) {
		ClientCapabilityData.ironMined = ironMined;
	}

	public static int getLapisMined() {
		return lapisMined;
	}

	public static void setLapisMined(int lapisMined) {
		ClientCapabilityData.lapisMined = lapisMined;
	}

	public static int getNetherGoldMined() {
		return netherGoldMined;
	}

	public static void setNetherGoldMined(int netherGoldMined) {
		ClientCapabilityData.netherGoldMined = netherGoldMined;
	}

	public static int getQuartzMined() {
		return quartzMined;
	}

	public static void setQuartzMined(int quartzMined) {
		ClientCapabilityData.quartzMined = quartzMined;
	}

	public static int getRedstoneMined() {
		return redstoneMined;
	}

	public static void setRedstoneMined(int redstoneMined) {
		ClientCapabilityData.redstoneMined = redstoneMined;
	}

	public static int getPlayerArcheryLevel() {
		return playerArcheryLevel;
	}

	public static void setPlayerArcheryLevel(int playerArcheryLevel) {
		ClientCapabilityData.playerArcheryLevel = playerArcheryLevel;
	}

	public static int getPlayerArcheryExp() {
		return playerArcheryExp;
	}

	public static void setPlayerArcheryExp(int playerArcheryExp) {
		ClientCapabilityData.playerArcheryExp = playerArcheryExp;
	}

	public static int getPlayerChoppingLevel() {
		return playerChoppingLevel;
	}

	public static void setPlayerChoppingLevel(int playerChoppingLevel) {
		ClientCapabilityData.playerChoppingLevel = playerChoppingLevel;
	}

	public static int getPlayerChoppingExp() {
		return playerChoppingExp;
	}

	public static void setPlayerChoppingExp(int playerChoppingExp) {
		ClientCapabilityData.playerChoppingExp = playerChoppingExp;
	}

	public static int getPlayerCombatLevel() {
		return playerCombatLevel;
	}

	public static void setPlayerCombatLevel(int playerCombatLevel) {
		ClientCapabilityData.playerCombatLevel = playerCombatLevel;
	}

	public static int getPlayerFarmingLevel() {
		return playerFarmingLevel;
	}

	public static void setPlayerFarmingLevel(int playerFarmingLevel) {
		ClientCapabilityData.playerFarmingLevel = playerFarmingLevel;
	}

	public static int getPlayerCombatExp() {
		return playerCombatExp;
	}

	public static void setPlayerCombatExp(int playerCombatExp) {
		ClientCapabilityData.playerCombatExp = playerCombatExp;
	}

	public static int getPlayerFarmingExp() {
		return playerFarmingExp;
	}

	public static void setPlayerFarmingExp(int playerFarmingExp) {
		ClientCapabilityData.playerFarmingExp = playerFarmingExp;
	}

	public static int getPlayerSwordsLevel() {
		return playerSwordsLevel;
	}

	public static void setPlayerSwordsLevel(int playerSwordsLevel) {
		ClientCapabilityData.playerSwordsLevel = playerSwordsLevel;
	}

	public static int getPlayerSwordsExp() {
		return playerSwordsExp;
	}

	public static void setPlayerSwordsExp(int playerSwordsExp) {
		ClientCapabilityData.playerSwordsExp = playerSwordsExp;
	}

	public static boolean isUpgradedEfficientMarksman() {
		return isUpgradedEfficientMarksman;
	}

	public static void setUpgradedEfficientMarksman(boolean isUpgradedEfficientMarksman) {
		ClientCapabilityData.isUpgradedEfficientMarksman = isUpgradedEfficientMarksman;
	}

	public static boolean isUpgradedHunter() {
		return isUpgradedHunter;
	}

	public static void setUpgradedHunter(boolean isUpgradedHunter) {
		ClientCapabilityData.isUpgradedHunter = isUpgradedHunter;
	}

	public static boolean isUpgradedInsecurity() {
		return isUpgradedInsecurity;
	}

	public static void setUpgradedInsecurity(boolean isUpgradedInsecurity) {
		ClientCapabilityData.isUpgradedInsecurity = isUpgradedInsecurity;
	}

	public static boolean isUpgradedLeftClick() {
		return isUpgradedLeftClick;
	}

	public static void setUpgradedLeftClick(boolean isUpgradedLeftClick) {
		ClientCapabilityData.isUpgradedLeftClick = isUpgradedLeftClick;
	}

	public static boolean isUpgradedQuickshot() {
		return isUpgradedQuickshot;
	}

	public static void setUpgradedQuickshot(boolean isUpgradedQuickshot) {
		ClientCapabilityData.isUpgradedQuickshot = isUpgradedQuickshot;
	}

	public static boolean isUpgradedSharpshooter() {
		return isUpgradedSharpshooter;
	}

	public static void setUpgradedSharpshooter(boolean isUpgradedSharpshooter) {
		ClientCapabilityData.isUpgradedSharpshooter = isUpgradedSharpshooter;
	}

	public static boolean isUpgradedSniper() {
		return isUpgradedSniper;
	}

	public static void setUpgradedSniper(boolean isUpgradedSniper) {
		ClientCapabilityData.isUpgradedSniper = isUpgradedSniper;
	}

	public static boolean isUpgradedSweetSpotArchery() {
		return isUpgradedSweetSpotArchery;
	}

	public static void setUpgradedSweetSpotArchery(boolean isUpgradedSweetSpotArchery) {
		ClientCapabilityData.isUpgradedSweetSpotArchery = isUpgradedSweetSpotArchery;
	}

	public static boolean isUpgradedUnabated() {
		return isUpgradedUnabated;
	}

	public static void setUpgradedUnabated(boolean isUpgradedUnabated) {
		ClientCapabilityData.isUpgradedUnabated = isUpgradedUnabated;
	}

	public static boolean isUpgradedGrannySmith() {
		return isUpgradedGrannySmith;
	}

	public static void setUpgradedGrannySmith(boolean isUpgradedGrannySmith) {
		ClientCapabilityData.isUpgradedGrannySmith = isUpgradedGrannySmith;
	}

	public static boolean isUpgradedHardWood() {
		return isUpgradedHardWood;
	}

	public static void setUpgradedHardWood(boolean isUpgradedHardWood) {
		ClientCapabilityData.isUpgradedHardWood = isUpgradedHardWood;
	}

	public static boolean isUpgradedHighGround() {
		return isUpgradedHighGround;
	}

	public static void setUpgradedHighGround(boolean isUpgradedHighGround) {
		ClientCapabilityData.isUpgradedHighGround = isUpgradedHighGround;
	}

	public static boolean isUpgradedStrongArms() {
		return isUpgradedStrongArms;
	}

	public static void setUpgradedStrongArms(boolean isUpgradedStrongArms) {
		ClientCapabilityData.isUpgradedStrongArms = isUpgradedStrongArms;
	}

	public static boolean isUpgradedDodgeRoll() {
		return isUpgradedDodgeRoll;
	}

	public static void setUpgradedDodgeRoll(boolean isUpgradedDodgeRoll) {
		ClientCapabilityData.isUpgradedDodgeRoll = isUpgradedDodgeRoll;
	}

	public static boolean isUpgradedFreeArrows() {
		return isUpgradedFreeArrows;
	}

	public static void setUpgradedFreeArrows(boolean isUpgradedFreeArrows) {
		ClientCapabilityData.isUpgradedFreeArrows = isUpgradedFreeArrows;
	}

	public static boolean isUpgradedOvercome() {
		return isUpgradedOvercome;
	}

	public static void setUpgradedOvercome(boolean isUpgradedOvercome) {
		ClientCapabilityData.isUpgradedOvercome = isUpgradedOvercome;
	}

	public static boolean isUpgradedRagnorok() {
		return isUpgradedRagnorok;
	}

	public static void setUpgradedRagnorok(boolean isUpgradedRagnorok) {
		ClientCapabilityData.isUpgradedRagnorok = isUpgradedRagnorok;
	}

	public static boolean isUpgradedStableFooting() {
		return isUpgradedStableFooting;
	}

	public static void setUpgradedStableFooting(boolean isUpgradedStableFooting) {
		ClientCapabilityData.isUpgradedStableFooting = isUpgradedStableFooting;
	}

	public static boolean isUpgradedTakeStance() {
		return isUpgradedTakeStance;
	}

	public static void setUpgradedTakeStance(boolean isUpgradedTakeStance) {
		ClientCapabilityData.isUpgradedTakeStance = isUpgradedTakeStance;
	}

	public static boolean isUpgradedCarnivore() {
		return isUpgradedCarnivore;
	}

	public static void setUpgradedCarnivore(boolean isUpgradedCarnivore) {
		ClientCapabilityData.isUpgradedCarnivore = isUpgradedCarnivore;
	}

	public static boolean isUpgradedEgger() {
		return isUpgradedEgger;
	}

	public static void setUpgradedEgger(boolean isUpgradedEgger) {
		ClientCapabilityData.isUpgradedEgger = isUpgradedEgger;
	}

	public static boolean isUpgradedSugarRush() {
		return isUpgradedSugarRush;
	}

	public static void setUpgradedSugarRush(boolean isUpgradedSugarRush) {
		ClientCapabilityData.isUpgradedSugarRush = isUpgradedSugarRush;
	}

	public static boolean isUpgradedWellFed() {
		return isUpgradedWellFed;
	}

	public static void setUpgradedWellFed(boolean isUpgradedWellFed) {
		ClientCapabilityData.isUpgradedWellFed = isUpgradedWellFed;
	}

	public static boolean isUpgradedCritastic() {
		return isUpgradedCritastic;
	}

	public static void setUpgradedCritastic(boolean isUpgradedCritastic) {
		ClientCapabilityData.isUpgradedCritastic = isUpgradedCritastic;
	}

	public static boolean isUpgradedFleshWound() {
		return isUpgradedFleshWound;
	}

	public static void setUpgradedFleshWound(boolean isUpgradedFleshWound) {
		ClientCapabilityData.isUpgradedFleshWound = isUpgradedFleshWound;
	}

	public static boolean isUpgradedPerfectTiming() {
		return isUpgradedPerfectTiming;
	}

	public static void setUpgradedPerfectTiming(boolean isUpgradedPerfectTiming) {
		ClientCapabilityData.isUpgradedPerfectTiming = isUpgradedPerfectTiming;
	}

	public static boolean isUpgradedRightClick() {
		return isUpgradedRightClick;
	}

	public static void setUpgradedRightClick(boolean isUpgradedRightClick) {
		ClientCapabilityData.isUpgradedRightClick = isUpgradedRightClick;
	}

	public static boolean isUpgradedShieldBash() {
		return isUpgradedShieldBash;
	}

	public static void setUpgradedShieldBash(boolean isUpgradedShieldBash) {
		ClientCapabilityData.isUpgradedShieldBash = isUpgradedShieldBash;
	}

	public static boolean isUpgradedSweetSpotSwords() {
		return isUpgradedSweetSpotSwords;
	}

	public static void setUpgradedSweetSpotSwords(boolean isUpgradedSweetSpotSwords) {
		ClientCapabilityData.isUpgradedSweetSpotSwords = isUpgradedSweetSpotSwords;
	}
	
	public static int getPlayerMagicExp() {
		return playerMagicExp;
	}

	public static void setPlayerMagicExp(int playerMagicExp) {
		ClientCapabilityData.playerMagicExp = playerMagicExp;
	}


	public static int getPlayerMagicLevel(){
		return playerMagicLevel;
	}

	public static void setPlayerMagicLevel(int playerMagicLevel) {

		ClientCapabilityData.playerMagicLevel = playerMagicLevel;
	}

}
