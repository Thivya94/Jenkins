package ATI_Test_Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.extentManager.ExtentManager;

import Pages.Login_MP;
import Testcases.mpDriver_centralClass;

public class Baseclass {
	public static WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;

	@BeforeSuite
	public void BeforeSuite() {
		ExtentManager.setExtent();
	}

	@AfterSuite
	public void AfterSuite() {
		ExtentManager.endReport();
	}

	@BeforeMethod
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		wait=new WebDriverWait(driver,10);

		prop = new Properties();
		String path = System.getProperty("user.dir") + "\\" + "src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();}
	
	public void Login(String UserName,String Password)
	{

		ExtentManager.test.log(Status.INFO,"[Navigate to URL]");
		driver.get(prop.getProperty("url"));
		ExtentManager.test.log(Status.PASS,"[Navigated to URL]"+" " +":"+ prop.getProperty("url"));
		
		ExtentManager.test.log(Status.INFO,"[Pass the Username]");
		mpDriver_centralClass.getLogin_MP().userName.sendKeys(UserName);
		ExtentManager.test.log(Status.PASS,"[UserName is Passed]");
		
		ExtentManager.test.log(Status.INFO,"[Pass the Password]");
		mpDriver_centralClass.getLogin_MP().Password.sendKeys(Password);
		ExtentManager.test.log(Status.PASS,"[Password is passed]");
		
		ExtentManager.test.log(Status.INFO,"[Click the signIn button]");
		wait.until(ExpectedConditions.presenceOfElementLocated(Login_MP.wait_signIn())).click();
		ExtentManager.test.log(Status.PASS,"[Clicked the signIn button]");
		
	}

	@AfterMethod
	public void tearDown() throws IOException {
		driver.close();
	}

	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return destination;
	}

	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
}
