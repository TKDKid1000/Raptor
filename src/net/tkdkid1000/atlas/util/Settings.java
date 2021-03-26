package net.tkdkid1000.atlas.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Settings {
	
	public static Integer GAME_HEIGHT;
	public static Integer GAME_WIDTH;
	public static Paint PLATFORM_COLOR = Color.BLACK;
	public static Paint LAVA_COLOR = Color.RED;
	public static Paint WALL_COLOR = Color.BROWN;
	public static Integer PLATFORM_SIZE = 100;
	
	public static void reload() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("game.properties"));
			GAME_HEIGHT = Integer.parseInt((String) properties.get("height"));
			GAME_WIDTH = Integer.parseInt((String) properties.get("width"));
		} catch (IOException e) {
			
		}
		
	}
}
