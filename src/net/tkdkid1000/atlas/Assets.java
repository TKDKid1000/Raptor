package net.tkdkid1000.atlas;

import java.io.File;

public class Assets {

	public static File getAssetsFolder() {
		String userDirectory = System.getProperty("user.dir");
		return new File(userDirectory, "src");
	}
}
