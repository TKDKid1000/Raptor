package net.tkdkid1000.atlas.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import net.tkdkid1000.atlas.App;
import net.tkdkid1000.atlas.items.Inventory;
import net.tkdkid1000.atlas.items.Item;
import net.tkdkid1000.atlas.util.Settings;

public class InventoryGui extends Gui {

	public InventoryGui(KeyCode key) {
		super(key);
	}

	@Override
	public void openGui() {
		Rectangle background = new Rectangle(Settings.GAME_WIDTH/2-200, Settings.GAME_HEIGHT/2-200, 400, 400);
		background.setFill(Color.rgb(51, 57, 232, 0.5));
		super.nodes.add(background);
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
				super.nodes.add(view);
			}
		}
	}	
}
