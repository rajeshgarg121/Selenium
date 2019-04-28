package listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class MyListener	implements ITestListener,IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(listeners.Retry.class);
    }
		@Override
		public void onTestStart(ITestResult result) {
			System.out.println("test started");
			
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			System.out.println("test passed");
			
		}

		@Override
		public void onTestFailure(ITestResult result) {
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
			
		}

		@Override
		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}		
	}

