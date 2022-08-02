package com.daltoncash.mmostats.capabilities;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;


import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;

public class Capabilities {
	
	public static final Capability<IMyCapability> PLAYER_CAPABILITIES = null;

    public static IMyCapability getPlayer(Player player) {
        LazyOptional<IMyCapability> playerData = player.getCapability(Capabilities.PLAYER_CAPABILITIES, null);
        return playerData.orElse(null);
    }

    public static void register(RegisterCapabilitiesEvent event) {
        event.register(IMyCapability.class);
    }

    public Capabilities() {
    	
    }
	
}