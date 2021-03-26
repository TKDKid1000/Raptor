package net.tkdkid1000.atlas;

import javafx.application.Application;
import net.tkdkid1000.atlas.util.Settings;

public class Main {

	public static void main(String[] args) {
		Application.launch(App.class, args);
		Settings.reload();
	}
}
