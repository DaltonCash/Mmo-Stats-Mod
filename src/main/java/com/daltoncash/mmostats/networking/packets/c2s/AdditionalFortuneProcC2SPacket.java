package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.daltoncash.mmostats.events.ClientEvents.ClientForgeEvents;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.network.NetworkEvent;

public class AdditionalFortuneProcC2SPacket {
	
	public AdditionalFortuneProcC2SPacket() {

    }

    public AdditionalFortuneProcC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();
            BlockEvent event = ClientForgeEvents.blockevent;
            Map<Enchantment, Integer> map = player.getItemInHand(InteractionHand.MAIN_HAND).getAllEnchantments();
            List<ItemStack> drops = Block.getDrops(event.getState(), level, event.getPos(), null);
            
            if(map.containsKey(Enchantments.BLOCK_FORTUNE)) {
            	
            	double rand = Math.random();
            	if(map.get(Enchantments.BLOCK_FORTUNE).equals(1)) {
            		if(rand <= (double) 1/3) {
            			for(ItemStack item : drops) {
            				item.setCount(item.getCount() * 2);
            				player.addItem(item);
            			}
            		}
            	}else if(map.get(Enchantments.BLOCK_FORTUNE).equals(2)) {
            		if(rand <= .25 ) {
            			for(ItemStack item : drops) {
            				item.setCount(item.getCount() * 2);
            				player.addItem(item);
            			}
            		}else if(rand <= .50 && rand > .25) {
            			for(ItemStack item : drops) {
            				item.setCount(item.getCount() * 3);
            				player.addItem(item);
            			}
            		}
            	}else if(map.get(Enchantments.BLOCK_FORTUNE).equals(3)) {
            		if(rand <= .20) {
            			for(ItemStack item : drops) {
            				item.setCount(item.getCount() * 2);
            				player.addItem(item);
            			}
            		}else if(rand <= .40 && rand > .20) {
            			for(ItemStack item : drops) {
            				item.setCount(item.getCount() * 3);
            				player.addItem(item);
            			}
            		}else if(rand <= .60 && rand > .40) {
            			for(ItemStack item : drops) {
            				item.setCount(item.getCount() * 4);
            				player.addItem(item);
            			}
            		}
            	}
            }
        });
        return true;
    }
}
