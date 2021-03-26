package net.tkdkid1000.atlas.util;

import javafx.animation.AnimationTimer;
import net.tkdkid1000.atlas.App;
import net.tkdkid1000.atlas.Commands;
import net.tkdkid1000.atlas.InventoryGui;
import net.tkdkid1000.atlas.sprites.Player;

public class GameLoop extends AnimationTimer {

	int playermovetimer = 0;
	InventoryGui inv = new InventoryGui();
	
	@Override
	public void handle(long now) {
		if (!App.isPaused()) {
			playermovetimer++;
			App.getInstance().sprites.forEach((sprite) -> {
				sprite.updateUI();
				sprite.checkRemovability();
				if (sprite instanceof Player) {
					Player player = (Player) sprite;
					if (playermovetimer == 1) {
						player.handleInput();
						playermovetimer = 0;
					}
				} else {
					sprite.move();
				}
			});
			Commands.handle();
		}
		inv.input();
	}

}
