package com.daltoncash.mmostats.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    //making a creative mode tab
    //TUTORIAL_TAB is name
    public static final CreativeModeTab MMO_TAB = new CreativeModeTab("mmostatsmodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BONK_STICK.get());
        }
    };

}
