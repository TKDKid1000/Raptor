package net.tkdkid1000.atlas.items;

import net.tkdkid1000.atlas.sprites.Player;

public class Food extends Item {

	private double food;

	public Food(String id, int uses, String icon, double food) {
		super(id, uses, icon);
		this.food = food;
	}

	@Override
	public void use(Player player) {
		player.setFood(player.getFood()+food);
	}
}
