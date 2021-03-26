package net.tkdkid1000.atlas;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import net.tkdkid1000.atlas.items.tools.Sword;
import net.tkdkid1000.atlas.sprites.Player;
import net.tkdkid1000.atlas.util.Settings;

public class Commands {

	public static boolean uiOpen = false;
	public static List<String> history = new ArrayList<String>();
	public static List<String> chatLines = new ArrayList<String>();
	
	public static void handle() {
		if ((Input.keys.contains(KeyCode.SLASH) || Input.keys.contains(KeyCode.T)) && !uiOpen) {
			TextField commandprompt = new TextField();
			if (Input.keys.contains(KeyCode.SLASH)) {
				commandprompt.appendText("/");
			}
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
				if (commandprompt.getText().startsWith("/")) {
					String cmd = commandprompt.getText().substring(1);
					if (cmd.equalsIgnoreCase("sword")) {
						App.getInstance().sprites.forEach(sprite -> {
							if (sprite instanceof Player) {
								Player player = (Player) sprite;
								player.getInventory().setTool(new Sword());
							}
						});
					} else if (cmd.equalsIgnoreCase("help")) {
						sendChat("Commands:");
						sendChat("1. /help");
						sendChat("2. /sword");
					} else {
						sendChat("No command named \"/" + cmd + "\" Please perform \"/help\"");
					}
				} // chat handling
				else {
					if (!commandprompt.getText().strip().equals("")) {
						sendChat("<Player> " + commandprompt.getText());
					}
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
	
	public static void sendChat(String chat) {
		chatLines.add(chat);
		App.getInstance().chat.setText("");
		chatLines.forEach(line -> {
			App.getInstance().chat.setText(
				App.getInstance().chat.getText() +
				"\n" + line
			);
		});
		if (chatLines.size() == 7) {
			chatLines.remove(0);
		}
		new Timeline(new KeyFrame(Duration.seconds(3), event -> {
			chatLines.remove(chat);
			App.getInstance().chat.setText("");
			chatLines.forEach(line -> {
				App.getInstance().chat.setText(
					App.getInstance().chat.getText() +
					"\n" + line
				);
			});
		}
		)).play();
		
	}
}
