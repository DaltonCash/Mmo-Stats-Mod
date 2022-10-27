package com.daltoncash.mmostats;


import com.daltoncash.mmostats.common.handler.Sounds;
import com.daltoncash.mmostats.entities.ModEntityTypes;
import com.daltoncash.mmostats.entities.client.enemies.beetle.BeetleRenderer;
import com.daltoncash.mmostats.entities.client.enemies.crab.CrabRenderer;
import com.daltoncash.mmostats.entities.client.enemies.divinetrader.DivineTraderRenderer;
import com.daltoncash.mmostats.entities.client.enemies.kingCoal.KingCoalRenderer;
import com.daltoncash.mmostats.entities.client.enemies.krok.KrokRenderer;
import com.daltoncash.mmostats.entities.client.enemies.lordOfTheLandfill.LordOfTheLandfillRenderer;
import com.daltoncash.mmostats.entities.client.enemies.mole.MoleRenderer;
import com.daltoncash.mmostats.entities.client.enemies.obsidianobserver.ObsidianObserverRenderer;
import com.daltoncash.mmostats.entities.client.enemies.rat.RatRenderer;
import com.daltoncash.mmostats.entities.client.enemies.redstoneRunner.RedstoneRunnerRenderer;
import com.daltoncash.mmostats.entities.client.taming.bee.TamedBeeRenderer;
import com.daltoncash.mmostats.entities.client.taming.companion.CompanionRenderer;
import com.daltoncash.mmostats.entities.client.taming.frog.TamedFrogRenderer;
import com.daltoncash.mmostats.entities.client.taming.goat.TamedGoatRenderer;
import com.daltoncash.mmostats.entities.client.taming.llama.TamedLlamaRenderer;
import com.daltoncash.mmostats.entities.client.taming.turtle.TamedTurtleRenderer;
import com.daltoncash.mmostats.item.ModItems;
import com.daltoncash.mmostats.networking.ModMessages;
import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MmoStatsMod.MODID)
public class MmoStatsMod {
	// Define mod id in a common place for everything to reference
	public static final String MODID = "mmostats";
	// Directly reference a slf4j logger
	private static final Logger LOGGER = LogUtils.getLogger();
	// Create a Deferred Register to hold Blocks which will all be registered under
	// the "mmostats" namespace
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	// Create a Deferred Register to hold Items which will all be registered under
	// the "mmostats" namespace
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	// Creates a new Block with the id "examplemod:example_block", combining the
	// namespace and path
	public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
	// Creates a new BlockItem with the id "examplemod:example_block", combining the
	// namespace and path
	public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block",
			() -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	public MmoStatsMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register the commonSetup method for modloading
		modEventBus.addListener(this::commonSetup);
		// Register the Deferred Register to the mod event bus so blocks get registered
		BLOCKS.register(modEventBus);
		// Register the Deferred Register to the mod event bus so items get registered
		ITEMS.register(modEventBus);

		//register
		ModItems.register(modEventBus);
		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
		
		//entities
		ModEntityTypes.register(modEventBus);

		GeckoLib.initialize();
		
		Sounds.Sounds.register(modEventBus);
	}

	

	private void commonSetup(final FMLCommonSetupEvent event) {
		
		event.enqueueWork(() -> {
			
			SpawnPlacements.register(ModEntityTypes.BEETLE.get(), 
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(ModEntityTypes.CRAB.get(), 
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(ModEntityTypes.DIVINETRADER.get(), 
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(ModEntityTypes.KINGCOAL.get(), 
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(ModEntityTypes.KROK.get(), 
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(ModEntityTypes.LORDOFTHELANDFILL.get(), 
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(ModEntityTypes.MOLE.get(), 
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(ModEntityTypes.OBSIDIANOBSERVER.get(), 
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(ModEntityTypes.RAT.get(), 
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					Monster::checkMonsterSpawnRules);
			SpawnPlacements.register(ModEntityTypes.REDSTONERUNNER.get(), 
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					Monster::checkMonsterSpawnRules);
			
			ModMessages.register();
		});
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {
		// Do something when the server starts
		LOGGER.info("HELLO from server starting");
	}

	// You can use EventBusSubscriber to automatically register all static methods
	// in the class annotated with @SubscribeEvent
	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			// Some client setup code
			EntityRenderers.register(ModEntityTypes.COMPANION.get(), CompanionRenderer::new);
			EntityRenderers.register(ModEntityTypes.TAMEDFROG.get(), TamedFrogRenderer::new);
			EntityRenderers.register(ModEntityTypes.LLAMA.get(), TamedLlamaRenderer::new);
			EntityRenderers.register(ModEntityTypes.TURTLE.get(), TamedTurtleRenderer::new);
			EntityRenderers.register(ModEntityTypes.GOAT.get(), TamedGoatRenderer::new);
			EntityRenderers.register(ModEntityTypes.BEE.get(), TamedBeeRenderer::new);
			
			EntityRenderers.register(ModEntityTypes.BEETLE.get(), BeetleRenderer::new);
			EntityRenderers.register(ModEntityTypes.CRAB.get(), CrabRenderer::new);
			EntityRenderers.register(ModEntityTypes.DIVINETRADER.get(), DivineTraderRenderer::new);
			EntityRenderers.register(ModEntityTypes.KINGCOAL.get(), KingCoalRenderer::new);
			EntityRenderers.register(ModEntityTypes.KROK.get(), KrokRenderer::new);
			EntityRenderers.register(ModEntityTypes.LORDOFTHELANDFILL.get(), LordOfTheLandfillRenderer::new);
			EntityRenderers.register(ModEntityTypes.MOLE.get(), MoleRenderer::new);
			EntityRenderers.register(ModEntityTypes.OBSIDIANOBSERVER.get(), ObsidianObserverRenderer::new);
			EntityRenderers.register(ModEntityTypes.RAT.get(), RatRenderer::new);
			EntityRenderers.register(ModEntityTypes.REDSTONERUNNER.get(), RedstoneRunnerRenderer::new);
			LOGGER.info("HELLO FROM CLIENT SETUP");
			LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
		}
	}
	
	public static ResourceLocation prefix(String name) {
		return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
	}
	
}
