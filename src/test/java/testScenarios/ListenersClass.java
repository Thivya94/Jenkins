package testScenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import resources.Base;

public class ListenersClass extends Base implements ITestListener {

	//ExtentReports extent=reports();
//	public ExtentTest test;
//	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started");
	//test = extent.createTest(result.getMethod().getMethodName());
//		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		//test.log(Status.PASS, testMethodName + " " + "Passed");
		System.out.println(testMethodName+" "+"Test success");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		//WebDriver driver = null;
		// screenshot
//		test.fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName();

		try {

			//driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					//.get(result.getInstance());
			
		} catch (Exception e) {

		}

		try {
			test.addScreenCaptureFromPath(getScreenshotPath(testMethodName, Td.get()), testMethodName);
	

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("Test Failure");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test failed within success percentage");

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Before Test started");

	}

	@Override
	public void onFinish(ITestContext context) {
		
		  
		System.out.println("last execution");

	}

}
