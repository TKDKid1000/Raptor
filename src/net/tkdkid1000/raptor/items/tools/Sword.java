package net.tkdkid1000.raptor.items.tools;

import net.tkdkid1000.raptor.items.Tool;
import net.tkdkid1000.raptor.sprites.Player;

public class Sword extends Tool {

	public Sword(int uses, double damage) {
		super("sword", uses, damage);
	}

	@Override
	public void use(Player player) {
		uses--;
		if (uses == 0) {
			player.getInventory().setTool(new None(1, 0));
		}
	}
}
