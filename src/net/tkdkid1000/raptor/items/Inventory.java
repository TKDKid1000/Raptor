package net.tkdkid1000.raptor.items;

import java.util.HashMap;
import java.util.Map;

import net.tkdkid1000.raptor.items.tools.None;

public class Inventory {

	private Map<Item, Integer> items;
	private Tool tool;
	
	public Inventory() {
		this.items = new HashMap<Item, Integer>();
		this.tool = new None();
	}
	
	public Tool getTool() {
		return this.tool;
	}
	
	public Inventory setTool(Tool tool) {
		this.tool = tool;
		return this;
	}
	
	public Inventory setToolFromInventory(Tool tool) {
		if (items.containsKey(tool)) {
			setTool(tool);
			removeItem(tool);
		}
		return this;
	}
	
	public Map<Item, Integer> getItems() {
		return items;
	}
	
	public Inventory setItems(Map<Item, Integer> items) {
		this.items = items;
		return this;
	}
	
	public Inventory addItem(Item item, int count) {
		this.items.put(item, count);
		return this;
	}
	
	public Inventory removeItem(Item item) {
		this.items.remove(item);
		return this;
	}
	
	public Inventory clear() {
		this.items.clear();
		this.tool = new None();
		return this;
	}
}
