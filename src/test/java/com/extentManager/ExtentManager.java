package com.extentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ATI_Test_Baseclass.Baseclass;

public class ExtentManager {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setExtent() {
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\" + "reports\\" + "index_" + Baseclass.getCurrentTime() + ".html");

		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "OrangeHRM");
		extent.setSystemInfo("Tester", "Hitendra");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		extent.flush();
	}
}
