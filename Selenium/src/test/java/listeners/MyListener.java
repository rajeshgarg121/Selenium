package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import base.BaseTest;
import helper.Report;
import helper.ScreenShot;

public class MyListener	implements ITestListener,IAnnotationTransformer{
	//public Report report=Report.getinstance();
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(listeners.Retry.class);
    }
		@Override
		public void onTestStart(ITestResult result) {
			System.out.println("test started");
			//report.setTest(result);
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			System.out.println("test passed");
			
		}

		@Override
		public void onTestFailure(ITestResult result) {
			ScreenShot.getScreenShot(((BaseTest)result.getInstance()).driver,result.getName());
			System.out.println("test FAILED");
			
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			System.out.println("test skipped");
			
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			//report.setTest(context);
			
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}		
	}

