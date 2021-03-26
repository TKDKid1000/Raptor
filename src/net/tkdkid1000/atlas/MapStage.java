package net.tkdkid1000.atlas;

import java.util.Map;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class MapStage {

	private char[][] map;
	private double size;
	private Pane layer;
	private Map<Character, Paint> colors;

	public MapStage(Pane layer, char[][] map, double size, Map<Character, Paint> colors) {
		this.map = map;
		this.size = size;
		this.layer = layer;
		this.colors = colors;
		load();
	}
	
	private void load() {
		for (int x=0; x<map.length; x++) {
			for (int y=0; y<map[y].length; y++) {
				Rectangle rect = new Rectangle(y*size, x*size, y+1*size, x+1*size);
				rect.setFill(colors.get(map[x][y]));
				layer.getChildren().add(rect);
			}
		}
	}
}
