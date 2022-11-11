package com.daltoncash.mmostats.capabilities;

public class ClientCapabilityData {
	//Core Levels
	private static int playerExp;
	private static int playerLevel;
	private static int playerUpgradePoints;
	private static int playerAttributePoints;
	private static int playerHealth;
	private static int playerHealthExp;
	private static int playerAgility;
	private static int playerAgilityExp;
	private static int playerMana;
	private static int playerCurrentMana;
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
	private static int isUpgradedEfficientMarksman;
	private static int isUpgradedHunter;
	private static int isUpgradedInsecurity;
	private static int isUpgradedLeftClick;
	private static int isUpgradedQuickshot;
	private static int isUpgradedSharpshooter;
	private static int isUpgradedSniper;
	private static int isUpgradedSweetSpotArchery;
	private static int isUpgradedUnabated;
	//chopping
	private static int isUpgradedGrannySmith;
	private static int isUpgradedHardWood;
	private static int isUpgradedHighGround;
	private static int isUpgradedStrongArms;
	//combat
	private static int isUpgradedDodgeRoll;
	private static int isUpgradedFreeArrows;
	private static int isUpgradedOvercome;
	private static int isUpgradedRagnorok;
	private static int isUpgradedStableFooting;
	private static int isUpgradedTakeStance;
	//farming
	private static int isUpgradedCarnivore;
	private static int isUpgradedEgger;
	private static int isUpgradedSugarRush;
	private static int isUpgradedWellFed;
	private static int isUpgradedFastFood;
	private static int isUpgradedInsatiable;
	//swords
	private static int isUpgradedCritastic;
	private static int isUpgradedFleshWound;
	private static int isUpgradedPerfectTiming;
	private static int isUpgradedRightClick;
	private static int isUpgradedShieldBash;
	private static int isUpgradedSweetSpotSwords;
	//mining
	private static int isUpgradedNightVision;
	private static int isUpgradedNoJunkBlocks;
	private static int isUpgradedJunkBlocksDropExp;
	private static int isUpgradedObsidianBreaker;
	private static int isUpgradedBigSwings;
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
	private static int obsidianMined;
	private static int quartzMined;
	private static int redstoneMined;
	//Foods Eaten
	private static int applesEaten;
	private static int beefEaten;
	private static int beetrootEaten;
	private static int breadEaten;
	private static int cakeEaten;
	private static int carrotsEaten;
	private static int chickenEaten;
	private static int cookiesEaten;
	private static int fishEaten;
	private static int glowBerriesEaten;
	private static int goldApplesEaten;
	private static int goldenCarrotsEaten;
	private static int honeyEaten;
	private static int kelpEaten;
	private static int melonEaten;
	private static int mushroomStewEaten;
	private static int muttonEaten;
	private static int poisonousPotatoEaten;
	private static int porkEaten;
	private static int potatoEaten;
	private static int pufferfishEaten;
	private static int pumpkinPieEaten;
	private static int rabbitEaten;
	private static int rawFoodEaten;
	private static int rottenFleshEaten;
	private static int spiderEyeEaten;
	//Logs Chopped
	private static int AcaciaChopped;
	private static int BirchChopped;
	private static int CrimsonStemChopped;
	private static int DarkOakChopped;
	private static int JungleChopped;
	private static int MangroveChopped;
	private static int OakChopped;
	private static int SpruceChopped;
	private static int WarpedStemChopped;
	
	public static int getTotalsLevel(int total) {
		int i = 32;
		int j = 0;
		while(total >= i) {
			i *= 2;
			j++;
		}
		return j;
	}
	
	public static int getPlayerExp() {
		return playerExp;
	}

	public static void setPlayerExp(int playerExp) {
		ClientCapabilityData.playerExp = playerExp;
	}

	public static int getPlayerLevel() {
		return playerLevel;
	}

	public static void setPlayerLevel(int playerLevel) {
		ClientCapabilityData.playerLevel = playerLevel;
	}

	public static int getPlayerHealth() {
		return playerHealth;
	}

	public static void setPlayerHealth(int playerHealth) {
		ClientCapabilityData.playerHealth = playerHealth;
	}

	public static int getPlayerHealthExp() {
		return playerHealthExp;
	}

	public static void setPlayerHealthExp(int playerHealthExp) {
		ClientCapabilityData.playerHealthExp = playerHealthExp;
	}

	public static int getPlayerAgility() {
		return playerAgility;
	}

	public static void setPlayerAgility(int playerAgility) {
		ClientCapabilityData.playerAgility = playerAgility;
	}

	public static int getPlayerAgilityExp() {
		return playerAgilityExp;
	}

	public static void setPlayerAgilityExp(int playerAgilityExp) {
		ClientCapabilityData.playerAgilityExp = playerAgilityExp;
	}

	public static int getPlayerMana() {
		return playerMana;
	}

	public static void setPlayerMana(int playerMana) {
		ClientCapabilityData.playerMana = playerMana;
	}
	
	public static int getPlayerCurrentMana() {
		return playerCurrentMana;
	}

	public static void setPlayerCurrentMana(int playerCurrentMana) {
		ClientCapabilityData.playerCurrentMana = playerCurrentMana;
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
	public static int isUpgradedNightVision() {
		return isUpgradedNightVision;
	}

	public static void setUpgradedNightVision(int isUpgradedNightVision) {
		ClientCapabilityData.isUpgradedNightVision = isUpgradedNightVision;
	}

	public static int isUpgradedNoJunkBlocks() {
		return isUpgradedNoJunkBlocks;
	}

	public static void setUpgradedNoJunkBlocks(int isUpgradedNoJunkBlocks) {
		ClientCapabilityData.isUpgradedNoJunkBlocks = isUpgradedNoJunkBlocks;
	}

	public static int isUpgradedJunkBlocksDropExp() {
		return isUpgradedJunkBlocksDropExp;
	}

	public static void setUpgradedJunkBlocksDropExp(int isUpgradedJunkBlocksDropExp) {
		ClientCapabilityData.isUpgradedJunkBlocksDropExp = isUpgradedJunkBlocksDropExp;
	}

	public static int isUpgradedObsidianBreaker() {
		return isUpgradedObsidianBreaker;
	}

	public static void setUpgradedObsidianBreaker(int isUpgradedObsidianBreaker) {
		ClientCapabilityData.isUpgradedObsidianBreaker = isUpgradedObsidianBreaker;
	}

	public static int getIsUpgradedBigSwings() {
		return isUpgradedBigSwings;
	}

	public static void setIsUpgradedBigSwings(int isUpgradedBigSwings) {
		ClientCapabilityData.isUpgradedBigSwings = isUpgradedBigSwings;
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

	public static int isUpgradedEfficientMarksman() {
		return isUpgradedEfficientMarksman;
	}

	public static void setUpgradedEfficientMarksman(int isUpgradedEfficientMarksman) {
		ClientCapabilityData.isUpgradedEfficientMarksman = isUpgradedEfficientMarksman;
	}

	public static int isUpgradedHunter() {
		return isUpgradedHunter;
	}

	public static void setUpgradedHunter(int isUpgradedHunter) {
		ClientCapabilityData.isUpgradedHunter = isUpgradedHunter;
	}

	public static int isUpgradedInsecurity() {
		return isUpgradedInsecurity;
	}

	public static void setUpgradedInsecurity(int isUpgradedInsecurity) {
		ClientCapabilityData.isUpgradedInsecurity = isUpgradedInsecurity;
	}

	public static int isUpgradedLeftClick() {
		return isUpgradedLeftClick;
	}

	public static void setUpgradedLeftClick(int isUpgradedLeftClick) {
		ClientCapabilityData.isUpgradedLeftClick = isUpgradedLeftClick;
	}

	public static int isUpgradedQuickshot() {
		return isUpgradedQuickshot;
	}

	public static void setUpgradedQuickshot(int isUpgradedQuickshot) {
		ClientCapabilityData.isUpgradedQuickshot = isUpgradedQuickshot;
	}

	public static int isUpgradedSharpshooter() {
		return isUpgradedSharpshooter;
	}

	public static void setUpgradedSharpshooter(int isUpgradedSharpshooter) {
		ClientCapabilityData.isUpgradedSharpshooter = isUpgradedSharpshooter;
	}

	public static int isUpgradedSniper() {
		return isUpgradedSniper;
	}

	public static void setUpgradedSniper(int isUpgradedSniper) {
		ClientCapabilityData.isUpgradedSniper = isUpgradedSniper;
	}

	public static int isUpgradedSweetSpotArchery() {
		return isUpgradedSweetSpotArchery;
	}

	public static void setUpgradedSweetSpotArchery(int isUpgradedSweetSpotArchery) {
		ClientCapabilityData.isUpgradedSweetSpotArchery = isUpgradedSweetSpotArchery;
	}

	public static int isUpgradedUnabated() {
		return isUpgradedUnabated;
	}

	public static void setUpgradedUnabated(int isUpgradedUnabated) {
		ClientCapabilityData.isUpgradedUnabated = isUpgradedUnabated;
	}

	public static int isUpgradedGrannySmith() {
		return isUpgradedGrannySmith;
	}

	public static void setUpgradedGrannySmith(int isUpgradedGrannySmith) {
		ClientCapabilityData.isUpgradedGrannySmith = isUpgradedGrannySmith;
	}

	public static int isUpgradedHardWood() {
		return isUpgradedHardWood;
	}

	public static void setUpgradedHardWood(int isUpgradedHardWood) {
		ClientCapabilityData.isUpgradedHardWood = isUpgradedHardWood;
	}

	public static int isUpgradedHighGround() {
		return isUpgradedHighGround;
	}

	public static void setUpgradedHighGround(int isUpgradedHighGround) {
		ClientCapabilityData.isUpgradedHighGround = isUpgradedHighGround;
	}

	public static int isUpgradedStrongArms() {
		return isUpgradedStrongArms;
	}

	public static void setUpgradedStrongArms(int isUpgradedStrongArms) {
		ClientCapabilityData.isUpgradedStrongArms = isUpgradedStrongArms;
	}

	public static int isUpgradedDodgeRoll() {
		return isUpgradedDodgeRoll;
	}

	public static void setUpgradedDodgeRoll(int isUpgradedDodgeRoll) {
		ClientCapabilityData.isUpgradedDodgeRoll = isUpgradedDodgeRoll;
	}

	public static int isUpgradedFreeArrows() {
		return isUpgradedFreeArrows;
	}

	public static void setUpgradedFreeArrows(int isUpgradedFreeArrows) {
		ClientCapabilityData.isUpgradedFreeArrows = isUpgradedFreeArrows;
	}

	public static int isUpgradedOvercome() {
		return isUpgradedOvercome;
	}

	public static void setUpgradedOvercome(int isUpgradedOvercome) {
		ClientCapabilityData.isUpgradedOvercome = isUpgradedOvercome;
	}

	public static int isUpgradedRagnorok() {
		return isUpgradedRagnorok;
	}

	public static void setUpgradedRagnorok(int isUpgradedRagnorok) {
		ClientCapabilityData.isUpgradedRagnorok = isUpgradedRagnorok;
	}

	public static int isUpgradedStableFooting() {
		return isUpgradedStableFooting;
	}

	public static void setUpgradedStableFooting(int isUpgradedStableFooting) {
		ClientCapabilityData.isUpgradedStableFooting = isUpgradedStableFooting;
	}

	public static int isUpgradedTakeStance() {
		return isUpgradedTakeStance;
	}

	public static void setUpgradedTakeStance(int isUpgradedTakeStance) {
		ClientCapabilityData.isUpgradedTakeStance = isUpgradedTakeStance;
	}

	public static int isUpgradedCarnivore() {
		return isUpgradedCarnivore;
	}

	public static void setUpgradedCarnivore(int isUpgradedCarnivore) {
		ClientCapabilityData.isUpgradedCarnivore = isUpgradedCarnivore;
	}

	public static int isUpgradedEgger() {
		return isUpgradedEgger;
	}

	public static void setUpgradedEgger(int isUpgradedEgger) {
		ClientCapabilityData.isUpgradedEgger = isUpgradedEgger;
	}

	public static int isUpgradedSugarRush() {
		return isUpgradedSugarRush;
	}

	public static void setUpgradedSugarRush(int isUpgradedSugarRush) {
		ClientCapabilityData.isUpgradedSugarRush = isUpgradedSugarRush;
	}

	public static int isUpgradedWellFed() {
		return isUpgradedWellFed;
	}

	public static void setUpgradedWellFed(int isUpgradedWellFed) {
		ClientCapabilityData.isUpgradedWellFed = isUpgradedWellFed;
	}

	public static int isUpgradedCritastic() {
		return isUpgradedCritastic;
	}

	public static void setUpgradedCritastic(int isUpgradedCritastic) {
		ClientCapabilityData.isUpgradedCritastic = isUpgradedCritastic;
	}

	public static int isUpgradedFleshWound() {
		return isUpgradedFleshWound;
	}

	public static void setUpgradedFleshWound(int isUpgradedFleshWound) {
		ClientCapabilityData.isUpgradedFleshWound = isUpgradedFleshWound;
	}

	public static int isUpgradedPerfectTiming() {
		return isUpgradedPerfectTiming;
	}

	public static void setUpgradedPerfectTiming(int isUpgradedPerfectTiming) {
		ClientCapabilityData.isUpgradedPerfectTiming = isUpgradedPerfectTiming;
	}

	public static int isUpgradedRightClick() {
		return isUpgradedRightClick;
	}

	public static void setUpgradedRightClick(int isUpgradedRightClick) {
		ClientCapabilityData.isUpgradedRightClick = isUpgradedRightClick;
	}

	public static int isUpgradedShieldBash() {
		return isUpgradedShieldBash;
	}

	public static void setUpgradedShieldBash(int isUpgradedShieldBash) {
		ClientCapabilityData.isUpgradedShieldBash = isUpgradedShieldBash;
	}

	public static int isUpgradedSweetSpotSwords() {
		return isUpgradedSweetSpotSwords;
	}

	public static void setUpgradedSweetSpotSwords(int isUpgradedSweetSpotSwords) {
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

	public static int getApplesEaten() {
		return applesEaten;
	}

	public static void setApplesEaten(int applesEaten) {
		ClientCapabilityData.applesEaten = applesEaten;
	}

	public static int getBeefEaten() {
		return beefEaten;
	}

	public static void setBeefEaten(int beefEaten) {
		ClientCapabilityData.beefEaten = beefEaten;
	}

	public static int getBeetrootEaten() {
		return beetrootEaten;
	}

	public static void setBeetrootEaten(int beetrootEaten) {
		ClientCapabilityData.beetrootEaten = beetrootEaten;
	}

	public static int getBreadEaten() {
		return breadEaten;
	}

	public static void setBreadEaten(int breadEaten) {
		ClientCapabilityData.breadEaten = breadEaten;
	}

	public static int getCakeEaten() {
		return cakeEaten;
	}

	public static void setCakeEaten(int cakeEaten) {
		ClientCapabilityData.cakeEaten = cakeEaten;
	}

	public static int getCarrotsEaten() {
		return carrotsEaten;
	}

	public static void setCarrotsEaten(int carrotsEaten) {
		ClientCapabilityData.carrotsEaten = carrotsEaten;
	}

	public static int getChickenEaten() {
		return chickenEaten;
	}

	public static void setChickenEaten(int chickenEaten) {
		ClientCapabilityData.chickenEaten = chickenEaten;
	}

	public static int getCookiesEaten() {
		return cookiesEaten;
	}

	public static void setCookiesEaten(int cookiesEaten) {
		ClientCapabilityData.cookiesEaten = cookiesEaten;
	}

	public static int getFishEaten() {
		return fishEaten;
	}

	public static void setFishEaten(int fishEaten) {
		ClientCapabilityData.fishEaten = fishEaten;
	}

	public static int getGlowBerriesEaten() {
		return glowBerriesEaten;
	}

	public static void setGlowBerriesEaten(int glowBerriesEaten) {
		ClientCapabilityData.glowBerriesEaten = glowBerriesEaten;
	}

	public static int getGoldApplesEaten() {
		return goldApplesEaten;
	}

	public static void setGoldApplesEaten(int goldApplesEaten) {
		ClientCapabilityData.goldApplesEaten = goldApplesEaten;
	}

	public static int getGoldenCarrotsEaten() {
		return goldenCarrotsEaten;
	}

	public static void setGoldenCarrotsEaten(int goldenCarrotsEaten) {
		ClientCapabilityData.goldenCarrotsEaten = goldenCarrotsEaten;
	}

	public static int getHoneyEaten() {
		return honeyEaten;
	}

	public static void setHoneyEaten(int honeyEaten) {
		ClientCapabilityData.honeyEaten = honeyEaten;
	}

	public static int getKelpEaten() {
		return kelpEaten;
	}

	public static void setKelpEaten(int kelpEaten) {
		ClientCapabilityData.kelpEaten = kelpEaten;
	}

	public static int getMelonEaten() {
		return melonEaten;
	}

	public static void setMelonEaten(int melonEaten) {
		ClientCapabilityData.melonEaten = melonEaten;
	}

	public static int getMushroomStewEaten() {
		return mushroomStewEaten;
	}

	public static void setMushroomStewEaten(int mushroomStewEaten) {
		ClientCapabilityData.mushroomStewEaten = mushroomStewEaten;
	}

	public static int getMuttonEaten() {
		return muttonEaten;
	}

	public static void setMuttonEaten(int muttonEaten) {
		ClientCapabilityData.muttonEaten = muttonEaten;
	}

	public static int getPoisonousPotatoEaten() {
		return poisonousPotatoEaten;
	}

	public static void setPoisonousPotatoEaten(int poisonousPotatoEaten) {
		ClientCapabilityData.poisonousPotatoEaten = poisonousPotatoEaten;
	}

	public static int getPorkEaten() {
		return porkEaten;
	}

	public static void setPorkEaten(int porkEaten) {
		ClientCapabilityData.porkEaten = porkEaten;
	}

	public static int getPotatoEaten() {
		return potatoEaten;
	}

	public static void setPotatoEaten(int potatoEaten) {
		ClientCapabilityData.potatoEaten = potatoEaten;
	}

	public static int getPufferfishEaten() {
		return pufferfishEaten;
	}

	public static void setPufferfishEaten(int pufferfishEaten) {
		ClientCapabilityData.pufferfishEaten = pufferfishEaten;
	}

	public static int getPumpkinPieEaten() {
		return pumpkinPieEaten;
	}

	public static void setPumpkinPieEaten(int pumpkinPieEaten) {
		ClientCapabilityData.pumpkinPieEaten = pumpkinPieEaten;
	}

	public static int getRabbitEaten() {
		return rabbitEaten;
	}

	public static void setRabbitEaten(int rabbitEaten) {
		ClientCapabilityData.rabbitEaten = rabbitEaten;
	}

	public static int getRawFoodEaten() {
		return rawFoodEaten;
	}

	public static void setRawFoodEaten(int rawFoodEaten) {
		ClientCapabilityData.rawFoodEaten = rawFoodEaten;
	}

	public static int getRottenFleshEaten() {
		return rottenFleshEaten;
	}

	public static void setRottenFleshEaten(int rottenFleshEaten) {
		ClientCapabilityData.rottenFleshEaten = rottenFleshEaten;
	}

	public static int getSpiderEyeEaten() {
		return spiderEyeEaten;
	}

	public static void setSpiderEyeEaten(int spiderEyeEaten) {
		ClientCapabilityData.spiderEyeEaten = spiderEyeEaten;
	}

	public static int getAcaciaChopped() {
		return AcaciaChopped;
	}

	public static void setAcaciaChopped(int acaciaChopped) {
		AcaciaChopped = acaciaChopped;
	}

	public static int getBirchChopped() {
		return BirchChopped;
	}

	public static void setBirchChopped(int birchChopped) {
		BirchChopped = birchChopped;
	}

	public static int getCrimsonStemChopped() {
		return CrimsonStemChopped;
	}

	public static void setCrimsonStemChopped(int crimsonStemChopped) {
		CrimsonStemChopped = crimsonStemChopped;
	}

	public static int getDarkOakChopped() {
		return DarkOakChopped;
	}

	public static void setDarkOakChopped(int darkOakChopped) {
		DarkOakChopped = darkOakChopped;
	}

	public static int getJungleChopped() {
		return JungleChopped;
	}

	public static void setJungleChopped(int jungleChopped) {
		JungleChopped = jungleChopped;
	}

	public static int getMangroveChopped() {
		return MangroveChopped;
	}

	public static void setMangroveChopped(int mangroveChopped) {
		MangroveChopped = mangroveChopped;
	}

	public static int getOakChopped() {
		return OakChopped;
	}

	public static void setOakChopped(int oakChopped) {
		OakChopped = oakChopped;
	}

	public static int getSpruceChopped() {
		return SpruceChopped;
	}

	public static void setSpruceChopped(int spruceChopped) {
		SpruceChopped = spruceChopped;
	}

	public static int getWarpedStemChopped() {
		return WarpedStemChopped;
	}

	public static void setWarpedStemChopped(int warpedStemChopped) {
		WarpedStemChopped = warpedStemChopped;
	}

	public static int getIsUpgradedFastFood() {
		return isUpgradedFastFood;
	}

	public static void setUpgradedFastFood(int isUpgradedFastFood) {
		ClientCapabilityData.isUpgradedFastFood = isUpgradedFastFood;
	}

	public static int getIsUpgradedInsatiable() {
		return isUpgradedInsatiable;
	}

	public static void setUpgradedInsatiable(int isUpgradedInsatiable) {
		ClientCapabilityData.isUpgradedInsatiable = isUpgradedInsatiable;
	}

	public static int getPlayerUpgradePoints() {
		return playerUpgradePoints;
	}

	public static void setPlayerUpgradePoints(int playerUpgradePoints) {
		ClientCapabilityData.playerUpgradePoints = playerUpgradePoints;
	}

	public static int getPlayerAttributePoints() {
		return playerAttributePoints;
	}

	public static void setPlayerAttributePoints(int playerAttributePoints) {
		ClientCapabilityData.playerAttributePoints = playerAttributePoints;
	}

	public static int getObsidianMined() {
		return obsidianMined;
	}

	public static void setObsidianMined(int obsidianMined) {
		ClientCapabilityData.obsidianMined = obsidianMined;
	}

}
