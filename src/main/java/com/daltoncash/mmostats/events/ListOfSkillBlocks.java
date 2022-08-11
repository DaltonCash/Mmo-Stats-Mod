package com.daltoncash.mmostats.events;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ListOfSkillBlocks {
	public static List<Block> getMiningBlocks() {
		List<Block> list = new ArrayList<>();
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
		list.add(Blocks.SHROOMLIGHT);
		return list;
	}
}
