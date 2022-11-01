package com.daltoncash.mmostats.util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public class KeyBinding {
	public static final String KEY_CATEGORY_MMOSTATS = "key.category.mmostatsmod.mmostats";
	public static final String KEY_OPEN_UPGRADE_GUI = "key.mmostats.open_upgrade_gui";
	public static final String KEY_NIGHT_VISION = "key.mmostats.night_vision";
	public static final String KEY_TOGGLE_JUNK = "key.mmostats.toggle_junk";
	public static final String KEY_DODGE_ROLL = "key.mmostats.dodge_roll";
	public static final String KEY_XPLOSIVE_MINER = "key.mmostats.xplosive_miner";

	//public static final String KEY_NATURE_MAGNET = "key.mmostats.nature_magnet";
	
	public static final KeyMapping OPEN_UPGRADE_GUI_KEY = new KeyMapping(
			KEY_OPEN_UPGRADE_GUI,
			KeyConflictContext.IN_GAME,
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_U,
			KEY_CATEGORY_MMOSTATS);
	public static final KeyMapping NIGHT_VISION_KEY = new KeyMapping(
			KEY_NIGHT_VISION,
			KeyConflictContext.IN_GAME,
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_Z,
			KEY_CATEGORY_MMOSTATS);
	public static final KeyMapping TOGGLE_JUNK_KEY = new KeyMapping(
			KEY_TOGGLE_JUNK,
			KeyConflictContext.IN_GAME,
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_B,
			KEY_CATEGORY_MMOSTATS);
	public static final KeyMapping DODGE_ROLL_KEY = new KeyMapping(
			KEY_DODGE_ROLL,
			KeyConflictContext.IN_GAME,
			InputConstants.Type.KEYSYM,
			GLFW.GLFW_KEY_V,
			KEY_CATEGORY_MMOSTATS);
	
	//public static final KeyMapping X_PLOSIVE_MINER_KEY = new KeyMapping(
			//KEY_XPLOSIVE_MINER,
			//KeyConflictContext.IN_GAME,
			//InputConstants.Type.KEYSYM,
			//GLFW.GLFW_KEY_B,
			//KEY_CATEGORY_MMOSTATS);

	//public static final KeyMapping NATURE_MAGNET_KEY = new KeyMapping(
			//KEY_NATURE_MAGNET,
			//KeyConflictContext.IN_GAME,
			//InputConstants.Type.KEYSYM,
			//GLFW.GLFW_KEY_M,
			//KEY_CATEGORY_MMOSTATS);
}
