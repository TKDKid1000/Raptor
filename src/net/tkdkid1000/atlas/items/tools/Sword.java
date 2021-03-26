package net.tkdkid1000.atlas.items.tools;

import net.tkdkid1000.atlas.items.Tool;
import net.tkdkid1000.atlas.sprites.Player;

public class Sword extends Tool {

	public Sword() {
		super("sword", 10, "file:images/items/sword.png", 1.0);
	}

	@Override
	public void use(Player player) {
		uses--;
		if (uses == 0) {
			player.getInventory().setTool(new None());
		}
	}
}
