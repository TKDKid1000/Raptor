package net.tkdkid1000.raptor;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import net.tkdkid1000.raptor.items.tools.Sword;
import net.tkdkid1000.raptor.sprites.Player;
import net.tkdkid1000.raptor.util.Settings;

public class Commands {

	public static boolean uiOpen = false;
	public static List<String> history = new ArrayList<String>();
	
	public static void handle() {
		if (Input.keys.contains(KeyCode.SLASH) && !uiOpen) {
			TextField commandprompt = new TextField();
			commandprompt.appendText("/");
			uiOpen = true;
			App.pause();
			commandprompt.setLayoutX(0);
			commandprompt.setLayoutY(Settings.GAME_HEIGHT-25);
			commandprompt.setPrefWidth(Settings.GAME_WIDTH);
			App.getInstance().playfieldLayer.getChildren().add(commandprompt);
			commandprompt.setOnAction(event -> {
				App.pause();
				uiOpen = false;
				App.getInstance().playfieldLayer.getChildren().remove(commandprompt);
				history.add(commandprompt.getText());
				// command handling here
				String cmd = commandprompt.getText().substring(1);
				if (cmd.equalsIgnoreCase("sword")) {
					App.getInstance().sprites.forEach(sprite -> {
						if (sprite instanceof Player) {
							Player player = (Player) sprite;
							player.getInventory().setTool(new Sword(10, 1.0));
						}
					});
				} else {
					App.shownotification(commandprompt.getText(), 1000);
				}
			});
			commandprompt.setOnKeyPressed(event -> {
				if (event.getCode() == KeyCode.ESCAPE) {
					App.pause();
					uiOpen = false;
					App.getInstance().playfieldLayer.getChildren().remove(commandprompt);
				} else if (event.getCode() == KeyCode.UP) {
					if (history.size() > 0) {
						commandprompt.setText("");
						commandprompt.appendText(history.get(history.size()-1));
					}
				}
			});
		}
	}
}
