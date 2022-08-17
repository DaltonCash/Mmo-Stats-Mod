package com.daltoncash.mmostats.networking.packets.c2s.miningUpgrades;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;

public class SpawnTntC2SPacket {
	 public SpawnTntC2SPacket() {

	    }

	    public SpawnTntC2SPacket(FriendlyByteBuf buf) {

	    }

	    public void toBytes(FriendlyByteBuf buf) {

	    }

	    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
	        NetworkEvent.Context context = supplier.get();
	        context.enqueueWork(() -> {
	            // HERE WE ARE ON THE SERVER!
	            ServerPlayer player = context.getSender();
	            ServerLevel level = player.getLevel();

	            EntityType.TNT.spawn(level, null, null, player.blockPosition().offset(0, player.getEyeHeight(), 0),
	                    MobSpawnType.COMMAND, true, false).setDeltaMovement(player.getLookAngle());
	        });

	        return true;
	    }
}
