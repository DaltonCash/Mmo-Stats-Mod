package com.daltoncash.mmostats.networking.packets.c2s.magicAbilities;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SpawnNatureMagnetItemC2SPacket {

    public SpawnNatureMagnetItemC2SPacket() {

    }

    public SpawnNatureMagnetItemC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            ItemStack natureStack = new ItemStack(Items.DIAMOND);
            ItemEntity natureLoot = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), natureStack);
            level.addFreshEntity(natureLoot);
        });

        return true;
    }

}
