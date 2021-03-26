package net.tkdkid1000.raptor.items;

public abstract class Tool extends Item {
	
	protected double damage;

	public Tool(String id, int uses, double damage) {
		super(id, uses);
		this.damage = damage;
	}
	
	public double getDamage() {
		return damage;
	}
}
