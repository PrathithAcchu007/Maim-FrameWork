package com.crm.autodesk.generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * It is directly connect tp java and used to fetch the data directly
 * @author Prathith paul
 *
 */
public class PropertiesFileUtility {
	/**
	 * @author Prathith paul
	 * this is used to fetch the data from properties file 
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
	public String accessTheDatafromPropertiesFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(".//src//main//resources//credentials.properties");
		Properties prop_obj= new Properties();
		prop_obj.load(fis);
		return prop_obj.getProperty(key);
	}

}
