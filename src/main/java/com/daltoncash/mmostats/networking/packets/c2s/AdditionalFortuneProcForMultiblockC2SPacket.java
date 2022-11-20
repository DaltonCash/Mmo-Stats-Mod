package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.daltoncash.mmostats.events.ClientEvents.ClientForgeEvents;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.network.NetworkEvent;

public class AdditionalFortuneProcForMultiblockC2SPacket {

	public AdditionalFortuneProcForMultiblockC2SPacket() {

	}

	public AdditionalFortuneProcForMultiblockC2SPacket(FriendlyByteBuf buf) {

	}

	public void toBytes(FriendlyByteBuf buf) {

	}

	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
		NetworkEvent.Context context = supplier.get();
		context.enqueueWork(() -> {
			// HERE WE ARE ON THE SERVER!
			ServerPlayer player = context.getSender();
			ServerLevel level = player.getLevel();
			List<Block> blocks = ClientForgeEvents.multiblockBlockList;
			Map<Enchantment, Integer> map = player.getItemInHand(InteractionHand.MAIN_HAND).getAllEnchantments();
			for(Block block : blocks) {
				List<ItemStack> drops = Block.getDrops(block.defaultBlockState(), level, new BlockPos(player.position()), null);
		
				// Takes the player's item's enchants and finds if it has fortune.
				// It then applies Minecraft's fortune equation to find correct drops to add to
				// player's inventory.
				if (map.containsKey(Enchantments.BLOCK_FORTUNE)) {
					double rand = Math.random();
	
					if (map.get(Enchantments.BLOCK_FORTUNE).equals(1)) {
						if (rand <= (double) 1 / 3) {
							for (ItemStack item : drops) {
								item.setCount(item.getCount() * 2);
								level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item));
							}
						} else {
							for (ItemStack item : drops) {
								item.setCount(item.getCount() * 1);
								level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item));
							}
						}
					} else if (map.get(Enchantments.BLOCK_FORTUNE).equals(2)) {
						if (rand <= .25) {
							for (ItemStack item : drops) {
								item.setCount(item.getCount() * 2);
								level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item));
							}
						} else if (rand <= .50 && rand > .25) {
							for (ItemStack item : drops) {
								item.setCount(item.getCount() * 3);
								level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item));
							}
						} else {
							for (ItemStack item : drops) {
								item.setCount(item.getCount() * 1);
								level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item));
							}
						}
					} else if (map.get(Enchantments.BLOCK_FORTUNE).equals(3)) {
						if (rand <= .20) {
							for (ItemStack item : drops) {
								item.setCount(item.getCount() * 2);
								level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item));
							}
						} else if (rand <= .40 && rand > .20) {
							for (ItemStack item : drops) {
								item.setCount(item.getCount() * 3);
								level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item));
							}
						} else if (rand <= .60 && rand > .40) {
							for (ItemStack item : drops) {
								item.setCount(item.getCount() * 4);
								level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item));
							}
						} else {
							for (ItemStack item : drops) {
								item.setCount(item.getCount() * 1);
								level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item));
							}
						}
					}
					
				// Applies when player has no fortune.
				} else {
					for (ItemStack item : drops) {
						item.setCount(item.getCount() * 1);
						level.addFreshEntity(new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item));
					}
				}
			}
		});
		return true;
	}
}
