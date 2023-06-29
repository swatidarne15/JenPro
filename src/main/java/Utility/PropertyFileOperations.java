package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public class PropertyFileOperations {
	
	/* load and read property file and return the file*/
	
	static Properties prop=null;

	public static Properties propertyfileRead(String propFileName) throws IOException{
		File f = new File(propFileName );
		FileInputStream fis = new FileInputStream(f);
		prop= new Properties();
		prop.load(fis);
		
		return prop;
		
		
	}
	
//	public static void updateConfig(String propertyKey, Object propertyValue) throws ConfigurationException, IOException, Exception {
//		File f = new File(FilePaths.configFile);
//		PropertiesConfiguration config = new PropertiesConfiguration();
//		PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout();
//		
//			layout.load(config, new InputStreamReader(new FileInputStream(f)));
//		
//		config.setProperty(propertyKey, propertyValue);
//		
//			layout.save(config, new FileWriter(FilePaths.configFile,false));
//		
//		
//	}
	
}
