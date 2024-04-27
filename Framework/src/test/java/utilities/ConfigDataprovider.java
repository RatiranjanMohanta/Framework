package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataprovider {
	
	Properties pro;
	
	public ConfigDataprovider() {
		File src=new File("./Configuration/Config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} 
	
		catch (Exception e) {
			
			System.out.println("Not able to load config file:Error msg is "+e.getMessage());
		}
		
	}
	
	public String getDataFromConfig(String keyTOSearch) {
		return pro.getProperty(keyTOSearch);
	}
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	public String getURL() {
		return pro.getProperty("URL");
	}

}
