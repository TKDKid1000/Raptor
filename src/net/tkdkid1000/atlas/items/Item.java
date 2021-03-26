package net.tkdkid1000.atlas.items;

import javafx.scene.image.Image;
import net.tkdkid1000.atlas.sprites.Player;

public abstract class Item {
	
	protected String id;
	protected int uses;
	protected String icon;

	public Item(String id, int uses, String icon) {
		this.id = id;
		this.uses = uses;
		this.icon = icon;
	}
	
	public String getId() {
		return id;
	}
	
	public int getUses() {
		return uses;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public Image getImage() {
		return new Image(icon, 20, 20, false, false);
	}
	
	public void setUses(int uses) {
		this.uses = uses;
	}
	
	public abstract void use(Player player);
}
