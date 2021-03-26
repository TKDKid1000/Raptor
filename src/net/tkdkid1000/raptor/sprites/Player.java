package net.tkdkid1000.raptor.sprites;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import net.tkdkid1000.raptor.App;
import net.tkdkid1000.raptor.Input;
import net.tkdkid1000.raptor.Sprite;
import net.tkdkid1000.raptor.items.Inventory;
import net.tkdkid1000.raptor.util.Settings;

public class Player extends Sprite {

	private int speed;
	private Inventory inv;
	private boolean tooldelay;
	
	public Player(Pane layer, Image image, double x, double y, double r, double dx, double dy, double dr, double health,
			double damage, int speed) {
		super(layer, image, x, y, r, dx, dy, dr, health, damage);
//		cancelexit();
		this.speed = speed;
		this.inv = new Inventory();
		this.tooldelay = false;
	}
	
 
	
	@Override
	public void move() {
		
	}
	
	public void handleInput() {
		handlemovement();
		handleitems();
	}
	
	public void handleitems() {
		App.getInstance().weapon.setText(inv.getTool().getId() + " " + inv.getTool().getUses());
		if (Input.keys.contains(KeyCode.SPACE)) {
			if (!tooldelay) {
				getInventory().getTool().use(this);
				tooldelay = true;
				new Timeline(new KeyFrame(Duration.millis(500), event -> tooldelay = false)).play();
			}
		}
	}
	
	public void handlemovement() {
		if (Input.keys.contains(KeyCode.W)) {
			App.getInstance().sprites.forEach((sprite) -> {
				if (sprite instanceof MapSprite || sprite instanceof Background) {
					sprite.setY(sprite.getY()+speed);
				}
			});
		} else if (Input.keys.contains(KeyCode.S)) {
			App.getInstance().sprites.forEach((sprite) -> {
				if (sprite instanceof MapSprite || sprite instanceof Background) {
					sprite.setY(sprite.getY()-speed);
				}
			});
		} else if (Input.keys.contains(KeyCode.A)) {
			App.getInstance().sprites.forEach((sprite) -> {
				if (sprite instanceof MapSprite || sprite instanceof Background) {
					sprite.setX(sprite.getX()+speed);
				}
			});
		} else if (Input.keys.contains(KeyCode.D)) {
			App.getInstance().sprites.forEach((sprite) -> {
				if (sprite instanceof MapSprite || sprite instanceof Background) {
					sprite.setX(sprite.getX()-speed);
				}
			});
		}
	}
	
	@Override
	public void checkRemovability() {
		
	}
	
	public Inventory getInventory() {
		return inv;
	}
	
	public void setInventory(Inventory inv) {
		this.inv = inv;
	}

}
