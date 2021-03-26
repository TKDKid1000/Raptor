package net.tkdkid1000.raptor.items;

import net.tkdkid1000.raptor.sprites.Player;

public abstract class Item {
	
	protected String id;
	protected int uses;

	public Item(String id, int uses) {
		this.id = id;
		this.uses = uses;
	}
	
	public String getId() {
		return id;
	}
	
	public int getUses() {
		return uses;
	}
	
	public void setUses(int uses) {
		this.uses = uses;
	}
	
	public abstract void use(Player player);
}
