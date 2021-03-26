package net.tkdkid1000.raptor.items.tools;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import net.tkdkid1000.raptor.items.Tool;
import net.tkdkid1000.raptor.sprites.Player;

public class None extends Tool {

	public None() {
		super("none", 1, "file:images/items/none.png", 0.0);
	}

	@Override
	public void use(Player player) {
		new Timeline(new KeyFrame(Duration.millis(50), event -> player.setX(player.getX()+10))).play();
		new Timeline(new KeyFrame(Duration.millis(100), event -> player.setX(player.getX()-10))).play();
		new Timeline(new KeyFrame(Duration.millis(150), event -> player.setX(player.getX()-10))).play();
		new Timeline(new KeyFrame(Duration.millis(200), event -> player.setX(player.getX()+10))).play();
	}
}
