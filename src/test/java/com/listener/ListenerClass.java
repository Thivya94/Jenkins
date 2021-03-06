package com.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.extentManager.ExtentManager;

import ATI_Test_Baseclass.Baseclass;

public class ListenerClass extends ExtentManager implements ITestListener {
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Pass Test case is: " + result.getName());

	}

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

		String pathString = Baseclass.screenShot(Baseclass.driver, result.getName());
		try {
			test.addScreenCaptureFromPath(pathString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, "Skipped Test case is: " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
