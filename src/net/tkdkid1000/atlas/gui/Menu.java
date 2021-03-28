package net.tkdkid1000.atlas.gui;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import net.tkdkid1000.atlas.util.Settings;

public class Menu extends Gui {

	public Menu(KeyCode key) {
		super(key);
	}

	@Override
	public void openGui() {
		super.nodes.add(new Rectangle(Settings.GAME_WIDTH/2-50, Settings.GAME_HEIGHT/2-100, 100, 20));
	}
}
