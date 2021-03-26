package net.tkdkid1000.atlas;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import net.tkdkid1000.atlas.items.Inventory;
import net.tkdkid1000.atlas.items.Item;
import net.tkdkid1000.atlas.util.Settings;

public class InventoryGui {

	private Rectangle background;
	private List<ImageView> images;
	private boolean guiOpen;
	private boolean openDelay;
	
	public InventoryGui() {
		this.guiOpen = false;
		this.openDelay = false;
		images = new ArrayList<ImageView>();
	}
	
	public void input() {
		if (Input.keys.contains(KeyCode.E) && !openDelay) {
			openDelay = true;
			if (guiOpen) {
				close();
			} else {
				open();
			}
			new Timeline(new KeyFrame(Duration.millis(500), event -> {
				openDelay = false;
			})).play();
		}
	}
	
	public void open() {
		images.clear();
		guiOpen = true;
		background = new Rectangle(Settings.GAME_WIDTH/2-200, Settings.GAME_HEIGHT/2-200, 400, 400);
		background.setFill(Color.rgb(51, 57, 232, 0.5));
		Inventory inv = App.getInstance().player.getInventory();
		List<Item> items = new ArrayList<Item>();
		inv.getItems().forEach((item, count) -> {
			items.add(item);
		});
		for (int x=0; x<9; x++) {
			if (!(x >= items.size())) {
				ImageView view = new ImageView(items.get(x).getImage());
				view.relocate((Settings.GAME_WIDTH/2-200)+(x*20), Settings.GAME_HEIGHT/2+200);
				view.setOnMouseClicked(event -> {
					if (event.getButton() == MouseButton.PRIMARY) {
						
					}
				});
				images.add(view);
			}
		}
		App.getInstance().guiLayer.getChildren().add(background);
		images.forEach(image -> {
			App.getInstance().guiLayer.getChildren().add(image);
		});
		App.setPaused(true);
	}
	
	public void close() {
		images.clear();
		guiOpen = false;
		App.getInstance().guiLayer.getChildren().clear();
		App.setPaused(false);
	}
}
