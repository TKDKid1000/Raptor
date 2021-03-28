package net.tkdkid1000.atlas.util;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import net.tkdkid1000.atlas.App;
import net.tkdkid1000.atlas.Commands;
import net.tkdkid1000.atlas.gui.InventoryGui;
import net.tkdkid1000.atlas.gui.Menu;
import net.tkdkid1000.atlas.sprites.Player;

public class GameLoop extends AnimationTimer {

	InventoryGui inv = new InventoryGui(KeyCode.E);
	int playermovetimer = 0;
	Menu menu = new Menu(KeyCode.ESCAPE);
	
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
		if (!Commands.uiOpen) {
			inv.input();
		}
		menu.input();
	}
}
