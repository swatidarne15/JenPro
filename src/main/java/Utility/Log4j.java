package Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public  class Log4j {
	public static Logger loggerr() {
		Logger log = Logger.getLogger("Employee Management Service");
		PropertyConfigurator.configure("log4j.properties");
		return log;
	}
}