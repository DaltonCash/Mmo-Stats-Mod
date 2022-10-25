package com.daltoncash.mmostats.entities;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.taming.Companion;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedBee;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedFrog;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedGoat;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedLlama;
import com.daltoncash.mmostats.entities.mod_entities.taming.TamedTurtle;

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
	
	public static final RegistryObject<EntityType<TamedLlama>> LLAMA = Entities.register("tamed_llama",
			() -> EntityType.Builder.of(TamedLlama::new, MobCategory.CREATURE).sized(0.8f, 0.6f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "tamed_llama").toString()));
	
	public static final RegistryObject<EntityType<TamedTurtle>> TURTLE = Entities.register("tamed_turtle",
			() -> EntityType.Builder.of(TamedTurtle::new, MobCategory.CREATURE).sized(0.8f, 0.6f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "tamed_turtle").toString()));
	
	public static final RegistryObject<EntityType<TamedGoat>> GOAT = Entities.register("tamed_goat",
			() -> EntityType.Builder.of(TamedGoat::new, MobCategory.CREATURE).sized(0.8f, 0.6f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "tamed_goat").toString()));
	
	public static final RegistryObject<EntityType<TamedBee>> BEE = Entities.register("tamed_bee",
			() -> EntityType.Builder.of(TamedBee::new, MobCategory.CREATURE).sized(0.8f, 0.6f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "tamed_bee").toString()));

	public static void register(IEventBus eventBus) {
		Entities.register(eventBus);
	}
}
