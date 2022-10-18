package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.function.Supplier;

import com.daltoncash.mmostats.capabilities.ClientCapabilityData;
import com.daltoncash.mmostats.events.ClientEvents.ClientForgeEvents;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;

public class HunterDropsMeatC2SPacket {
	 public HunterDropsMeatC2SPacket() {

	 }

	 public HunterDropsMeatC2SPacket(FriendlyByteBuf buf) {

	 }

	 public void toBytes(FriendlyByteBuf buf) {

	 }

	 public boolean handle(Supplier<NetworkEvent.Context> supplier) {
	     NetworkEvent.Context context = supplier.get();
	     context.enqueueWork(() -> {
	         // HERE WE ARE ON THE SERVER!
	         ServerPlayer player = context.getSender();
	         ServerLevel level = player.getLevel();
	         Entity entity = ClientForgeEvents.clientEntity;
	         double x = ClientForgeEvents.clientEntity.position().x;
	         double y = ClientForgeEvents.clientEntity.position().y;
	         double z = ClientForgeEvents.clientEntity.position().z;
	         int porkchopEatenLevel = ClientCapabilityData.getTotalsLevel(ClientCapabilityData.getPorkEaten());
	         int hunterUpgradeLevel = ClientCapabilityData.isUpgradedHunter();
	         int meatToDrop = hunterUpgradeLevel > 0 ? porkchopEatenLevel + hunterUpgradeLevel : 0;
	         if(entity.getType().equals(EntityType.COW)) {
	        	 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.BEEF, meatToDrop * 2)));
	         }else if(entity.getType().equals(EntityType.SHEEP)) {
	        	 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.MUTTON, meatToDrop * 2))); 
	         }else if(entity.getType().equals(EntityType.PIG)) {
	        	 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.PORKCHOP, meatToDrop * 2))); 
	         }else if(entity.getType().equals(EntityType.RABBIT)) {
	        	 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.RABBIT, meatToDrop * 1))); 
	         }else if(entity.getType().equals(EntityType.CHICKEN)) {
	        	 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.CHICKEN, meatToDrop * 1))); 
	         }else {
	        	 int efficientMarksmanLevel = ClientCapabilityData.isUpgradedEfficientMarksman();
	        	 while(efficientMarksmanLevel > 0){
	        		 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.ARROW)));
	        		 efficientMarksmanLevel--;
	        	 }
	         }
	     });

	     return true;
	 }
}
