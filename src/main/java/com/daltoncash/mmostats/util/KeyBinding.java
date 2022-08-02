package com.daltoncash.mmostats.util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBinding {
	public static final String KEY_CATEGORY_MMOSTATS = "key.category.mmostatsmod.mmostats";
	public static final String KEY_OPEN_UPGRADE_GUI = "key.mmostats.open_upgrade_gui";
	public static final String KEY_GO_FAST = "key.mmostats.go_fast";
	
	public static final KeyMapping OPEN_UPGRADE_GUI_KEY = new KeyMapping(
			KEY_OPEN_UPGRADE_GUI,
			KeyConflictContext.IN_GAME,
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_U,
			KEY_CATEGORY_MMOSTATS);
	public static final KeyMapping GO_FAST_KEY = new KeyMapping(
			KEY_GO_FAST,
			KeyConflictContext.IN_GAME,
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_I,
			KEY_CATEGORY_MMOSTATS);
}
