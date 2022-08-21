package assets.mmostats.entities.EntityData.render;

import javax.naming.Context;
import org.antlr.v4.parse.ANTLRParser.finallyClause_return;
import com.daltoncash.mmostats.MmoStatsMod;
import assets.mmostats.entities.client.Companion;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CompanionRenderer <Companion> extends MobRenderer<Companion, CompanionModel<Companion>> {
	
	private static final ResourceLocation Texture = new ResourceLocation(MmoStatsMod.MODID, "textures/ententies/Companion");

	public CompanionRenderer(Context context) {
		super(context, new CompanionModel<type>(context.bakeLayer(ModelLayers.WOLF)), 0.5F);
		//bakeLayer(CompanionModel.LAYER_LOCATION))
	}

	@Override
	public ResourceLocation getTextureLocation(Companion entity) {
		return Texture;
	}
		
	
}   