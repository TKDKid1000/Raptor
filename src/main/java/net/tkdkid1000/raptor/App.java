package net.tkdkid1000.raptor;

import com.jme3.app.SimpleApplication;
import com.jme3.system.AppSettings;

public class App extends SimpleApplication {

	@Override
	public void simpleInitApp() {
		
	}

	public static void main(String[] args) {
		App app = new App();
		AppSettings settings = new AppSettings(true);
		settings.setTitle("Raptor");
		app.setSettings(settings);
		app.start();
	}
	
}
