package com.daltoncash.mmostats.item;

import com.daltoncash.mmostats.MmoStatsMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MmoStatsMod.MODID);

    //presi's bonk stick test item
    public static final RegistryObject<Item> BONK_STICK = ITEMS.register("bonk_stick",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<Item> BONK_STICK_V2 = ITEMS.register("bonk_stick_v2",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
