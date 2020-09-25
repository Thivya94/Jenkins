package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import pages.login;

public class Base {

	public WebDriverWait wait;
	public Properties prop;

	public ExtentReports extent;
	public ExtentTest test;

	public WebDriver dr;
	public static ThreadLocal<WebDriver> Td = new ThreadLocal<WebDriver>();

	public WebDriver initializeDriver(String browserName) throws IOException {

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "chromedriver.exe");
			
			dr = new ChromeDriver();
			Td.set(dr);
		}

		else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\" + "geckodriver.exe");
			//driver = new FirefoxDriver();
			dr = new FirefoxDriver();
			Td.set(dr);
		}

		//return driver;
		return dr;
	}

	public void Login(WebDriver driver, String pagename, ExtentTest test) throws IOException, InterruptedException {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "\\" + "src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);

		Td.get().manage().window().maximize();
		Td.get().manage().deleteAllCookies();
		wait = new WebDriverWait(driver, 30);

		test.log(Status.INFO, "[Navigate to URL] - URL :: " + prop.getProperty("url"));
		Td.get().get(prop.getProperty("url"));

		login lgn=new login();
		lgn.userName.sendKeys("administrator");
		lgn.Password.sendKeys("Wbcuser_1");
		lgn.Signin.click();

	}

	 @BeforeSuite
	public void Reports() {
		String Path = System.getProperty("user.dir") + "\\" + "reports\\index.html";
		//ExtentSparkReporter reporter = new ExtentSparkReporter(Path);
		
		//reporter.config().setReportName("Web Automation Results");
		//reporter.config().setDocumentTitle("Test Results");
	

         
		//extent = new ExtentReports();
		//extent.attachReporter(reporter);
		//extent.setSystemInfo("TesterName", "Thivya");

	}



	public String getScreenshotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir") + "\\reports\\" + testcaseName + ".png";
		FileUtils.copyFile(source, new File(destinationPath));
		return destinationPath;
	}

}
