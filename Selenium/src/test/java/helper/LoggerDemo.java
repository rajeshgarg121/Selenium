package helper;

import org.apache.log4j.Logger;

public class LoggerDemo {
	
	public static Logger getLogger(String className)
	{
		return Logger.getLogger(className);
	}
	
}
