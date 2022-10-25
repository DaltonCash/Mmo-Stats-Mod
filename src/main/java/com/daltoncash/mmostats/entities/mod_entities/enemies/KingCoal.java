package com.daltoncash.mmostats.entities.mod_entities.enemies;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class KingCoal extends Monster implements IAnimatable {

	protected KingCoal(EntityType<? extends Monster> p_33002_, Level p_33003_) {
		super(p_33002_, p_33003_);
	}

	@Override
	public void registerControllers(AnimationData data) {
		
	}

	@Override
	public AnimationFactory getFactory() {
		return null;
	}
}