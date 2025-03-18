package com.myntra.utility;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties properties;

	public ConfigReader() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("Config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file. The encountered error is: ", e);
        }
    }

    public String getProperty(String key) {
	        return properties.getProperty(key);
    }
}
