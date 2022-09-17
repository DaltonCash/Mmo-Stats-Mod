package com.daltoncash.mmostats.entities;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.Companion;
import com.daltoncash.mmostats.entities.mod_entities.TamedFrog;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
	public static final DeferredRegister<EntityType<?>> Entities = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
			MmoStatsMod.MODID);

	public static final RegistryObject<EntityType<Companion>> COMPANION = Entities.register("companion",
			() -> EntityType.Builder.of(Companion::new, MobCategory.CREATURE).sized(0.8f, 0.6f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "companion").toString()));

	public static final RegistryObject<EntityType<TamedFrog>> TAMEDFROG = Entities.register("tamed_frog",
			() -> EntityType.Builder.of(TamedFrog::new, MobCategory.CREATURE).sized(0.8f, 0.6f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "tamed_frog").toString()));

	public static void register(IEventBus eventBus) {
		Entities.register(eventBus);
	}
}
