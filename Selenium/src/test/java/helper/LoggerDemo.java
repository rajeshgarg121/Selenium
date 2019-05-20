package helper;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import base.BaseTest;
import static base.BaseTest.*;

public class LoggerDemo {
	
	public LoggerDemo()
	{
		FileAppender file_appender = null;
		PatternLayout layout=new PatternLayout();
		String pattern="%t %d{dd/MM/yyyy HH:mm:ss}>><<%c>%M>>%m%n";
		layout.setConversionPattern(pattern);
		ConsoleAppender console_appender=new ConsoleAppender();
		console_appender.setLayout(layout);
		console_appender.activateOptions();
		try {
		 file_appender=new FileAppender(layout,getLogFileName(),false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		file_appender.activateOptions();
		log=Logger.getLogger(getClass());
		log.setLevel(Level.ALL);
		log.addAppender(console_appender);
		log.addAppender(file_appender);
		
	}

	private String getLogFileName(){
		// TODO Auto-generated method stub
		long date=System.currentTimeMillis();
		SimpleDateFormat dateFormat =new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		String formattedDate=dateFormat.format(date);
		String scriptLogFilePath =System.getProperty("user.dir")+"\\src\\main\\logs\\scriptLogs_"+formattedDate+".log";
		return scriptLogFilePath;
	}
	
}
