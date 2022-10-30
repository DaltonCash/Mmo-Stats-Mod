package com.daltoncash.mmostats.events;

import java.util.ArrayList;
import java.util.List;

import com.daltoncash.mmostats.entities.ModEntityTypes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

// List of Blocks that will give Mining Experience to the player

public class ExpYieldList {
	public static List<Block> getMiningBlocks() {
		List<Block> list = new ArrayList<>();
		list.add(Blocks.SAND);
		list.add(Blocks.SANDSTONE);
		list.add(Blocks.STONE);
		list.add(Blocks.DIORITE);
		list.add(Blocks.ANDESITE);
		list.add(Blocks.GRANITE);
		list.add(Blocks.DEEPSLATE);
		list.add(Blocks.COAL_ORE);
		list.add(Blocks.DEEPSLATE_COAL_ORE);
		list.add(Blocks.COPPER_ORE);
		list.add(Blocks.DEEPSLATE_COPPER_ORE);
		list.add(Blocks.IRON_ORE);
		list.add(Blocks.DEEPSLATE_IRON_ORE);
		list.add(Blocks.GOLD_ORE);
		list.add(Blocks.DEEPSLATE_GOLD_ORE);
		list.add(Blocks.REDSTONE_ORE);
		list.add(Blocks.DEEPSLATE_REDSTONE_ORE);
		list.add(Blocks.LAPIS_ORE);
		list.add(Blocks.DEEPSLATE_LAPIS_ORE);
		list.add(Blocks.EMERALD_ORE);
		list.add(Blocks.DEEPSLATE_EMERALD_ORE);
		list.add(Blocks.DIAMOND_ORE);
		list.add(Blocks.DEEPSLATE_DIAMOND_ORE);
		list.add(Blocks.ANCIENT_DEBRIS);
		list.add(Blocks.OBSIDIAN);
		list.add(Blocks.CRYING_OBSIDIAN);
		list.add(Blocks.END_STONE);
		list.add(Blocks.END_STONE_BRICKS);
		list.add(Blocks.NETHER_GOLD_ORE);
		list.add(Blocks.NETHER_QUARTZ_ORE);
		list.add(Blocks.NETHERRACK);
		list.add(Blocks.NETHER_BRICKS);
		list.add(Blocks.GLOWSTONE);
		return list;
	}
	public static List<Block> getChoppingBlocks(){
		List<Block> list = new ArrayList<>();
		list.add(Blocks.OAK_LOG);
		list.add(Blocks.BIRCH_LOG);
		list.add(Blocks.SPRUCE_LOG);
		list.add(Blocks.JUNGLE_LOG);
		list.add(Blocks.DARK_OAK_LOG);
		list.add(Blocks.MANGROVE_LOG);
		list.add(Blocks.ACACIA_LOG);
		list.add(Blocks.OAK_LEAVES);
		list.add(Blocks.BIRCH_LEAVES);
		list.add(Blocks.SPRUCE_LEAVES);
		list.add(Blocks.JUNGLE_LEAVES);
		list.add(Blocks.DARK_OAK_LEAVES);
		list.add(Blocks.MANGROVE_LEAVES);
		list.add(Blocks.ACACIA_LEAVES);

		list.add(Blocks.CRIMSON_STEM);
		list.add(Blocks.WARPED_STEM);
		list.add(Blocks.WARPED_WART_BLOCK);
		list.add(Blocks.NETHER_WART_BLOCK);
		return list;
	}
	public static List<Block> getFarmingBlocks(){
		List<Block> list = new ArrayList<>();
		list.add(Blocks.GRASS);
		list.add(Blocks.TALL_GRASS);
		list.add(Blocks.WHEAT);
		list.add(Blocks.POTATOES);
		list.add(Blocks.CARROTS);
		list.add(Blocks.BEETROOTS);
		list.add(Blocks.COCOA);
		
		list.add(Blocks.PUMPKIN);
		list.add(Blocks.MELON);
		list.add(Blocks.CACTUS);
		list.add(Blocks.SUGAR_CANE);
		list.add(Blocks.BAMBOO);
		list.add(Blocks.KELP);
		list.add(Blocks.BROWN_MUSHROOM);
		list.add(Blocks.RED_MUSHROOM);
		list.add(Blocks.CRIMSON_FUNGUS);
		list.add(Blocks.WARPED_FUNGUS);
		list.add(Blocks.BROWN_MUSHROOM_BLOCK);
		list.add(Blocks.RED_MUSHROOM_BLOCK);
		list.add(Blocks.MUSHROOM_STEM);
		list.add(Blocks.SHROOMLIGHT);
		return list;
	}
	//Shows list of entities that the player can gain exp from
	public static List<EntityType<?>> getCombatEntities(){
		List<EntityType<?>> list = new ArrayList<>();
		//Passive mobs
		list.add(EntityType.ALLAY);
		list.add(EntityType.AXOLOTL);
		list.add(EntityType.BAT);
		list.add(EntityType.CHICKEN);
		list.add(EntityType.COD);
		list.add(EntityType.COW);
		list.add(EntityType.DONKEY);
		list.add(EntityType.FOX);
		list.add(EntityType.FROG);
		list.add(EntityType.GLOW_SQUID);
		list.add(EntityType.HORSE);
		list.add(EntityType.MOOSHROOM);
		list.add(EntityType.MULE);
		list.add(EntityType.OCELOT);
		list.add(EntityType.PARROT);
		list.add(EntityType.PIG);
		list.add(EntityType.PUFFERFISH);
		list.add(EntityType.RABBIT);
		list.add(EntityType.SALMON);
		list.add(EntityType.SHEEP);
		list.add(EntityType.SKELETON_HORSE);
		list.add(EntityType.SQUID);
		list.add(EntityType.STRIDER);
		list.add(EntityType.TADPOLE);
		list.add(EntityType.TROPICAL_FISH);
		list.add(EntityType.TURTLE);
		list.add(EntityType.WANDERING_TRADER);
		list.add(EntityType.ZOMBIE_HORSE);
		//Neutral mobs
		list.add(EntityType.BEE);
		list.add(EntityType.DOLPHIN);
		list.add(EntityType.GOAT);
		list.add(EntityType.LLAMA);
		list.add(EntityType.PANDA);
		list.add(EntityType.POLAR_BEAR);
		list.add(EntityType.TRADER_LLAMA);
		list.add(EntityType.WOLF);
		//Hostile mobs(includes spiders)
		list.add(EntityType.BLAZE);
		list.add(EntityType.CAVE_SPIDER);
		list.add(EntityType.CREEPER);
		list.add(EntityType.DROWNED);
		list.add(EntityType.ELDER_GUARDIAN);
		list.add(EntityType.ENDER_DRAGON);
		list.add(EntityType.ENDERMAN);
		list.add(EntityType.ENDERMITE);
		list.add(EntityType.EVOKER);
		list.add(EntityType.GHAST);
		list.add(EntityType.GUARDIAN);
		list.add(EntityType.HOGLIN);
		list.add(EntityType.HUSK);
		list.add(EntityType.IRON_GOLEM);
		list.add(EntityType.MAGMA_CUBE);
		list.add(EntityType.PHANTOM);
		list.add(EntityType.PIGLIN);
		list.add(EntityType.PIGLIN_BRUTE);
		list.add(EntityType.PILLAGER);
		list.add(EntityType.RAVAGER);
		list.add(EntityType.SHULKER);
		list.add(EntityType.SILVERFISH);
		list.add(EntityType.SKELETON);
		list.add(EntityType.SLIME);
		list.add(EntityType.SPIDER);
		list.add(EntityType.STRAY);
		list.add(EntityType.VEX);
		list.add(EntityType.VINDICATOR);
		list.add(EntityType.WARDEN);
		list.add(EntityType.WITCH);
		list.add(EntityType.WITHER);
		list.add(EntityType.WITHER_SKELETON);
		list.add(EntityType.ZOGLIN);
		list.add(EntityType.ZOMBIE);
		list.add(EntityType.ZOMBIE_VILLAGER);
		list.add(EntityType.ZOMBIFIED_PIGLIN);
		//Modded entities
		list.add(ModEntityTypes.BEETLE.get());
		list.add(ModEntityTypes.CARROT.get());
		list.add(ModEntityTypes.CRAB.get());
		list.add(ModEntityTypes.DIAMONDDEFENDER.get());
		list.add(ModEntityTypes.DIVINETRADER.get());
		list.add(ModEntityTypes.GOLDGOLEM.get());
		list.add(ModEntityTypes.KINGCOAL.get());
		list.add(ModEntityTypes.KROK.get());
		list.add(ModEntityTypes.LORDOFTHELANDFILL.get());
		list.add(ModEntityTypes.MELONMAN.get());
		list.add(ModEntityTypes.MOLE.get());
		list.add(ModEntityTypes.MUSHROOMMAN.get());
		list.add(ModEntityTypes.NIGHTBAT.get());
		list.add(ModEntityTypes.OBSIDIANOBSERVER.get());
		list.add(ModEntityTypes.RAT.get());
		list.add(ModEntityTypes.REDSTONERUNNER.get());
		list.add(ModEntityTypes.SKULL.get());
		list.add(ModEntityTypes.URCHIN.get());
		return list;
	}
}
