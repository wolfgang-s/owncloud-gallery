package library;

import java.util.ResourceBundle;

import javax.management.openmbean.InvalidKeyException;

public class Properties {
	private static ResourceBundle MSG = ResourceBundle.getBundle("messages");
	private static ResourceBundle APP = ResourceBundle.getBundle("application");
	
	public static String getString(String key) {
		if(MSG.containsKey(key)) {
			return MSG.getString(key);
		} else {
			return key;
		}
	}
	
	public static Integer getAppInt(String key) {
		if(APP.containsKey(key)) {
			return Integer.parseInt(APP.getString(key));
		} else {
			throw new InvalidKeyException(String.format("%s not found in app settings.", key));
		}
	}
}
