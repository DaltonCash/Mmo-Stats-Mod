package com.daltoncash.mmostats.entities;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Beetle;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Crab;
import com.daltoncash.mmostats.entities.mod_entities.enemies.DivineTrader;
import com.daltoncash.mmostats.entities.mod_entities.enemies.KingCoal;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Krok;
import com.daltoncash.mmostats.entities.mod_entities.enemies.LordOfTheLandfill;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Mole;
import com.daltoncash.mmostats.entities.mod_entities.enemies.ObsidianObserver;
import com.daltoncash.mmostats.entities.mod_entities.enemies.Rat;
import com.daltoncash.mmostats.entities.mod_entities.enemies.RedstoneRunner;
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

	
	
	public static final RegistryObject<EntityType<Beetle>> BEETLE = Entities.register("beetle",
			() -> EntityType.Builder.of(Beetle::new, MobCategory.MONSTER).sized(1f, 0.6f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "beetle").toString()));
	
	public static final RegistryObject<EntityType<Crab>> CRAB = Entities.register("crab",
			() -> EntityType.Builder.of(Crab::new, MobCategory.MONSTER).sized(0.8f, 0.4f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "crab").toString()));
	
	public static final RegistryObject<EntityType<DivineTrader>> DIVINETRADER = Entities.register("divinetrader",
			() -> EntityType.Builder.of(DivineTrader::new, MobCategory.MONSTER).sized(1.4f, 5f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "divinetrader").toString()));
	
	public static final RegistryObject<EntityType<KingCoal>> KINGCOAL = Entities.register("kingcoal",
			() -> EntityType.Builder.of(KingCoal::new, MobCategory.MONSTER).sized(2.2f, 4.2f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "kingcoal").toString()));
	
	public static final RegistryObject<EntityType<Krok>> KROK = Entities.register("krok",
			() -> EntityType.Builder.of(Krok::new, MobCategory.MONSTER).sized(0.8f, 2.2f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "krok").toString()));
	
	public static final RegistryObject<EntityType<LordOfTheLandfill>> LORDOFTHELANDFILL = Entities.register("lordofthelandfill",
			() -> EntityType.Builder.of(LordOfTheLandfill::new, MobCategory.MONSTER).sized(0.8f, 1.2f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "lordofthelandfill").toString()));
	
	public static final RegistryObject<EntityType<Mole>> MOLE = Entities.register("mole",
			() -> EntityType.Builder.of(Mole::new, MobCategory.MONSTER).sized(0.5f, 0.6f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "mole").toString()));
	
	public static final RegistryObject<EntityType<ObsidianObserver>> OBSIDIANOBSERVER = Entities.register("obsidianobserver",
			() -> EntityType.Builder.of(ObsidianObserver::new, MobCategory.MONSTER).sized(5f, 4f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "obsidianobserver").toString()));
	
	public static final RegistryObject<EntityType<Rat>> RAT = Entities.register("rat",
			() -> EntityType.Builder.of(Rat::new, MobCategory.MONSTER).sized(0.8f, 0.6f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "rat").toString()));
	
	public static final RegistryObject<EntityType<RedstoneRunner>> REDSTONERUNNER = Entities.register("redstonerunner",
			() -> EntityType.Builder.of(RedstoneRunner::new, MobCategory.MONSTER).sized(1.8f, 3f)
					.build(new ResourceLocation(MmoStatsMod.MODID, "redstonerunner").toString()));
	
	public static void register(IEventBus eventBus) {
		Entities.register(eventBus);
	}
}
