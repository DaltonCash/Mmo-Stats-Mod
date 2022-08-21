package assets.mmostats.entities.client;

import com.daltoncash.mmostats.MmoStatsMod;
import com.daltoncash.mmostats.MmoStatsMod.ClientModEvents;

import assets.mmostats.entities.EntityData.render.CompanionModel;
import assets.mmostats.entities.EntityData.render.CompanionRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = MmoStatsMod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientEvent {
	
	private ClientEvent() {
	}
	
	@SubscribeEvent
	public static void clintSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(CompanionModel.LAYER_LOCATION, CompanionModel::createBodyLayer);
	}
	
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityInit.COMPANION.get(), CompanionRenderer::new);
	} 
	

}
