package net.tkdkid1000.atlas;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Input {

	private Scene scene;
	public static List<KeyCode> keys = new ArrayList<KeyCode>();
	
	public Input(Scene scene) {
		this.scene = scene;
		register();
	}
	
	public void register() {
		scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (!keys.contains(event.getCode())) {
					keys.add(event.getCode());					
				}
			}
			
		});
		scene.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				keys.remove(event.getCode());
			}
			
		});
	}
	
}
