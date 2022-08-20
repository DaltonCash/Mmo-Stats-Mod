package com.daltoncash.mmostats.networking.packets.c2s;

import java.util.function.Supplier;

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

public class EntityDropsAnArrowC2SPacket {
	 public EntityDropsAnArrowC2SPacket() {

	 }

	 public EntityDropsAnArrowC2SPacket(FriendlyByteBuf buf) {

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
	         
	         if(entity.getType().equals(EntityType.COW)) {
	        	 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.BEEF, 2)));
	         }else if(entity.getType().equals(EntityType.SHEEP)) {
	        	 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.MUTTON, 2))); 
	         }else if(entity.getType().equals(EntityType.PIG)) {
	        	 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.PORKCHOP, 2))); 
	         }else if(entity.getType().equals(EntityType.RABBIT)) {
	        	 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.RABBIT, 1))); 
	         }else if(entity.getType().equals(EntityType.CHICKEN)) {
	        	 level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.CHICKEN, 1))); 
	         }else {
	         level.addFreshEntity(new ItemEntity(level, x, y, z, new ItemStack(Items.ARROW)));
	         }
	     });

	     return true;
	 }
}
