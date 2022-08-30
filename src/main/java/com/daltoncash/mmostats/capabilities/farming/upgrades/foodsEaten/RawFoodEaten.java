package com.daltoncash.mmostats.capabilities.farming.upgrades.foodsEaten;

import com.daltoncash.mmostats.capabilities.SumCapability;

public class RawFoodEaten extends SumCapability{
	
	public RawFoodEaten() {
		this.setNbtString("raw_food_eaten");
	}
}