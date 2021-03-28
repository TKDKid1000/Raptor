package net.tkdkid1000.atlas.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import net.tkdkid1000.atlas.App;
import net.tkdkid1000.atlas.Input;

public abstract class Gui {

	protected List<Node> nodes;
	protected boolean guiOpen;
	protected boolean openDelay;
	protected KeyCode key;
	
	public Gui(KeyCode key) {
		this.guiOpen = false;
		this.openDelay = false;
		this.key = key;
		nodes = new ArrayList<Node>();
	}
	
	public void input() {
		if (Input.keys.contains(key) && !openDelay) {
			openDelay = true;
			if (guiOpen) {
				close();
			} else {
				open();
			}
			new Timeline(new KeyFrame(Duration.millis(500), event -> {
				openDelay = false;
			})).play();
		}
	}
	
	public void open() {
		nodes.clear();
		guiOpen = true;
		openGui();
		nodes.forEach(node -> {
			App.getInstance().guiLayer.getChildren().add(node);
		});
		App.setPaused(true);
	}
	
	public void close() {
		nodes.clear();
		guiOpen = false;
		App.getInstance().guiLayer.getChildren().clear();
		App.setPaused(false);
	}
	
	public abstract void openGui();
}
