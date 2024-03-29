package com.daltoncash.mmostats.events;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;

//This class holds the values that all events and attributes derive modded stats from
//Note that any modifications to this class can have unintended consequences.

public class ModStats {
	
	public static double getHealth() {
		int goldApplesEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getGoldApplesEaten());
		int oakChoppedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getOakChopped());
		int obsidianMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getObsidianMined());
		int healthUpgrade = ClientCapabilityData.getPlayerHealth();
		return (20 + healthUpgrade + obsidianMinedLevel) * (0.99 + ((1 + goldApplesEatenLevel) * (1 + oakChoppedLevel)) / 100.0d);
	}

	public static int getHealthRegenModifier() {
		return (5000) / (4 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getRottenFleshEaten()));
	}

	public static float getFlatArmorModifier() {
		return ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPumpkinPieEaten());
	}

	public static float getArmorModifier() {
		int diamondMinedLevel = 1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getDiamondMined());
		int potatoEatenLevel = 1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPotatoEaten());
		int darkOakChoppedLevel = 1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getDarkOakChopped());
		return (diamondMinedLevel * potatoEatenLevel * darkOakChoppedLevel) / ((diamondMinedLevel * potatoEatenLevel * darkOakChoppedLevel) + 100f) - 1f/100f;
	}
	
	public static int getFlatDamage() {
		int beefEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getBeefEaten());
		int ancientDebrisMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getAncientDebrisMined());
		return 1 + beefEatenLevel * (1 + ancientDebrisMinedLevel);
	}
	
	public static float getPercentIncreaseDamage() {
			
		return 1 + ClientCapabilityData.getPlayerCombatLevel()  / 100.0f;
	}
	
	
	public static float getCritMultiplier() {
		int emeraldMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getEmeraldMined());
		return 1.0f + (0.5f * (emeraldMinedLevel + 1));
	}
	
	public static double getMoveSpeed() {
		int redstoneMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getRedstoneMined());
		int acaciaChoppedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getAcaciaChopped());
		int agility = ClientCapabilityData.getPlayerAgility();
		return (.09 + (((agility + 1) / 200d) + ((redstoneMinedLevel + 1) * (acaciaChoppedLevel + 1)) / 200.0d));
	}

	public static double getLuckyModifier() {
		int goldMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getGoldMined());
		return (1 + ((goldMinedLevel * 5) / 100f));
	}

	public static float getFallDamageModifier() {
		int chickenEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getChickenEaten());
		return chickenEatenLevel / (chickenEatenLevel + 4f);
	}
	
	public static double getKnockbackModifier() {
		int beetrootEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getBeetrootEaten());
		return 1 - (4 / (4 + beetrootEatenLevel));
	}
	
	
	public static float getMiningModifier() {
		int coalMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getCoalMined());
		int glowBerriesEaten = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getGlowBerriesEaten());
		return 0.99f + (((coalMinedLevel + 1) * (glowBerriesEaten + 1)) / 100f);
	}
	
	public static float getFarmingModifier() {
		int copperMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getCopperMined());
		int breadEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getBreadEaten());
		int birchChoppedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getBirchChopped());
		return 0.99f + (((copperMinedLevel + 1) * (breadEatenLevel + 1) * (birchChoppedLevel + 1)) / 100f);
	}
	
	public static float getCombatModifier() {
		int ironMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getIronMined());
		int rawFoodsEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getRawFoodEaten());
		return 0.99f + (((ironMinedLevel + 1) * (rawFoodsEatenLevel + 1)) / 100f);
	}

	public static float getArcheryModifier() {
		int quartzMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getQuartzMined());
		int goldenCarrotEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getGoldenCarrotsEaten());
		return 0.99f + (((quartzMinedLevel + 1) * (goldenCarrotEatenLevel + 1)) / 100f);
	}

	public static float getChoppingModifier() {
		int applesEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getApplesEaten());
		int jungleWoodChopped = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getJungleChopped());
		return 0.99f + (((applesEatenLevel + 1) * (jungleWoodChopped+ 1)) / 100f);
	}
	//WIP
	public static double getTamingModifier() {
		return 1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getSpruceChopped());
	}

	public static double getExpModifier() {
		int lapisMinedLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getLapisMined());
		return (lapisMinedLevel * lapisMinedLevel) / 100f;
	}
	
	
	
	//Below is not for display on the UpgradeMenu screen.
	public static int getEatCooldownReduction() {
		int fastFoodUpgradeAddition = ClientCapabilityData.getIsUpgradedFastFood() == 0 ? 0 : 2;
		if(ClientCapabilityData.getIsUpgradedFastFood() == 2) {
			fastFoodUpgradeAddition += 3;
		}
		return 1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMelonEaten()) + fastFoodUpgradeAddition;
	}
	
	public static int getRagnorokDuration() {
		int mushroomStewEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMushroomStewEaten());
		return 1200 * (2 + mushroomStewEatenLevel);
	}

	//eat duration should = (32 / fastfoodlevel) - melonsEaten
	public static int getEatDuration() {
		return 32/(1 + ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMelonEaten()));
	}
	
	public static double getMiningFortuneCalculation() {
		
		return (ClientCapabilityData.getPlayerMiningLevel() / 100f) * getLuckyModifier();
	}
	
	public static double getChoppingFortuneCalculation() {
		return (ClientCapabilityData.getPlayerChoppingLevel() / 100f) * getLuckyModifier();
	}
	
	public static float getDamageTakenCalculation(float damage) {
		return Math.max(0, (damage - getFlatArmorModifier()) * (1 - (getArmorModifier() / (getArmorModifier() + 100))));
	}
	
	public static float getDamageDealtCalculation(float damage) {
		return (damage + getFlatDamage()) * getPercentIncreaseDamage();
	}
	
	public static float getKnockbackCalculation(float amount) {
		int potatoesEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPotatoEaten());
		return (amount * 4) / (4 + potatoesEatenLevel);
	}
	
	public static int toNextLevelExp(int level) {
		return (level * 40) + 400;
	}

	public static int getMaxMana() {
		int kelpEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getKelpEaten());
		int manaAttributeLevel = ClientCapabilityData.getPlayerMana() * 5;
		
		return (int)((30 + manaAttributeLevel) * (1 + (kelpEatenLevel * 0.1)));
	}
	
	public static double getManaRegen() {
		int muttonEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMuttonEaten());
		
		return (120 / (getMaxMana() * (1 + (muttonEatenLevel * 0.1))));
	}
	
	public static double getManaRegenPerTenSeconds() {
		int muttonEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getMuttonEaten());
		
		return ((getMaxMana() * (1 + (muttonEatenLevel * 0.1))) / 12);
	}
	
	public static double getCastCostReduction() {
		int honeyEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getHoneyEaten());
		
		return 1 - (honeyEatenLevel * 0.1);
	}
	public static int getToolDamage(int enchantLevel, int potentialDamage) {
		double rand = Math.random();
		if(enchantLevel == 1) {
			if(rand > 1/2) return 0;
		}else if(enchantLevel == 2) {
			if(rand > 1/3) return 0;
		}else if(enchantLevel == 3) {
			if(rand > 1/4) return 0;
		}
		return potentialDamage;
	}
	
	public static float getArcheryDamage() {
		int archeryLevel = ClientCapabilityData.getPlayerArcheryLevel();
		int goldenCarrotLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getGoldenCarrotsEaten());
		
		return (archeryLevel / 100f) + (goldenCarrotLevel / 5f);
	}
}
