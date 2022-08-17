package com.daltoncash.mmostats.networking.packets.c2s.magicAbilities;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

public class SpawnNatureMagnetItemC2SPacket {

    public SpawnNatureMagnetItemC2SPacket() {

    }

    public SpawnNatureMagnetItemC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    @SuppressWarnings("resource")
	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            ArrayList<ItemStack>  dropTable = new ArrayList<ItemStack>();
            dropTable.add(new ItemStack(Items.DIAMOND));
            dropTable.add(new ItemStack(Items.GOLD_BLOCK));
            dropTable.add(new ItemStack(Items.EGG));
            dropTable.add(new ItemStack(Items.DIRT));
            dropTable.add(new ItemStack(Items.GLASS));

            Random r = new Random();

            ItemStack natureStack = dropTable.get(r.nextInt(5));
            ItemEntity natureLoot = new ItemEntity(level, player.getX() + r.nextInt(10 + 5) - 10,
                    player.getY() + r.nextInt(3), player.getZ() + r.nextInt(10 + 5) - 10, natureStack);
            level.addFreshEntity(natureLoot);
            Minecraft.getInstance().player.sendSystemMessage(Component.literal(
                    "Nature's Magnet looted you a " + natureStack.getItem().toString() + "!"));
        });

        return true;
    }

}
