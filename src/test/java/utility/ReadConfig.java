package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	public ReadConfig() throws Exception
	{
		FileInputStream fis = new FileInputStream("./TestData/data.properties");
		prop = new Properties();
		prop.load(fis);
	}
	 public String appURL() {

	        return prop.getProperty("appURL");

	    }

	    public String getEmail() {

	        return prop.getProperty("adminUserName");

	    }

	    public String getPass() {

	        return prop.getProperty("adminPassword");

	    }

}
