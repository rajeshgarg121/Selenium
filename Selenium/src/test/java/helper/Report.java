package helper;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
	
	 ExtentHtmlReporter htmlReporter;
	 ExtentReports extent;
	 ExtentTest test;
	 public static Report report;
	 public static  Report getinstance()
	 { if(report==null)
		 {
			 synchronized(Report.class)
			 {
				 if(report==null)
				  report=new Report();
			 }
		 }
		return report;
	 }
	 public void startReport(){
		    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\test-output\\testReport.html");
	        
	        //initialize ExtentReports and attach the HtmlReporter
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	         
	        //To add system or environment info by using the setSystemInfo method.
	       // extent.setSystemInfo("OS", OS);
	        //extent.setSystemInfo("Browser", browser);
	        
	        //configuration items to change the look and feel
	        //add content, manage tests etc
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("Extent Report Demo");
	        htmlReporter.config().setReportName("Test Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.STANDARD);
		 }
	 public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }
	 public void setTest(ITestResult result)
	 {
		 test = extent.createTest(result.getMethod().getId()+"_"+result.getMethod().getRealClass().toString());
	 }
	 public void endReport(){
	     extent.flush();
		 extent.close();
		    }
}
