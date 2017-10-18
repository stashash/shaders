package project.shaders.engine;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Utils {

	public static String loadResourse(String fileName) throws IOException {
		 String result;
	        try (InputStream in = Utils.class.getClass().getResourceAsStream(fileName);
	                Scanner scanner = new Scanner(in, "UTF-8")) {
	            result = scanner.useDelimiter("\\A").next();
	        }
	        return result;
	}

}
