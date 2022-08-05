package com.daltoncash.mmostats.events;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ListOfMiningBlocks {
	public static List<Block> getBlocks(){
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
		return list;
	}
}
