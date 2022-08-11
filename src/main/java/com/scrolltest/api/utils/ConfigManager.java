package com.scrolltest.api.utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import io.restassured.config.Config;

public class ConfigManager {
	//the purpose of this class is to fetch/read data from the config.properties file
	
	//create an instance of config manager
	private static ConfigManager manager;
	private static final Properties prop = new Properties();
	
	//create a private constructor to read the input stream
	private ConfigManager() throws IOException {
		
		InputStream inputStream = Config.class.getResourceAsStream("../resources/config.properties");
		prop.load(inputStream);
	}
	
	//create a get instance method 
	public static ConfigManager getInstance() {
		//if manager is null, only then we want to create something
		if(manager == null) { 
			//we use synchronized method so its thread safe. Only one thread can access at a time
			//Only one object can be created at a time.  
			synchronized(ConfigManager.class) { 
				try {
					manager = new ConfigManager();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		return manager; 
	}
	
	//create a get string method 
	public String getString(String key) {
		//This will load from the config.properties file
		return System.getProperty(key, prop.getProperty(key));
	}
	
	
	
	

}
