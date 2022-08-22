package com.daltoncash.mmostats.entities.client;

import com.daltoncash.mmostats.MmoStatsMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
	
	private EntityInit() {}
	
	public static final DeferredRegister<EntityType<?>> Entities = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MmoStatsMod.MODID);

	public static final RegistryObject<EntityType<Companion>> COMPANION = 
			Entities.register("Companion", () -> EntityType.Builder.of(Companion::new, MobCategory.CREATURE).sized(0.6f, 0.85f)
			.build(new ResourceLocation(MmoStatsMod.MODID, "models/entities/companion_model.bbmodel").toString()));
	} 