package Testcases;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.extentManager.ExtentManager;

import ATI_Test_Baseclass.Baseclass;
import Pages.ICD;
import packageDB.dbConnection;

public class TestClass extends Baseclass {

	@Test
	@Parameters({ "UserName", "Password" })
	public void loginPageTest(String UserName, String Password) throws Exception {

		
		mpDriver_centralClass.getExcel().readExcel(0, "ICD");
		
		ExtentManager.test.log(Status.INFO, "[Start the test by logging in]");
		Login(UserName, Password);
		ExtentManager.test.log(Status.PASS, "[Successfully logging in]");

		ExtentManager.test.log(Status.INFO, "[Click the Manage button]");
		mpDriver_centralClass.getICD().Manage.click();
		ExtentManager.test.log(Status.PASS, "[Clicked the Manage button]");

		ExtentManager.test.log(Status.INFO, "[Click the ICD button]");
		mpDriver_centralClass.getICD().ICD.click();
		ExtentManager.test.log(Status.PASS, "[Clicked the ICD button]");

		ExtentManager.test.log(Status.INFO, "[Click the ICD Add button]");
		mpDriver_centralClass.getICD().Add.click();
		ExtentManager.test.log(Status.PASS, "[Clicked the ICD Add button]");

		Thread.sleep(3000);
		ExtentManager.test.log(Status.INFO, "[Send the icd number]");
		wait.until(ExpectedConditions.presenceOfElementLocated(ICD.wait_ICDnum())).sendKeys(Excel.ICD_numbers);
		ExtentManager.test.log(Status.PASS, "[Sent the icd number]");

		ExtentManager.test.log(Status.INFO, "[Choose the icd type]");
		mpDriver_centralClass.getICD().ICD_codeType.click();
		Select icd_dropdown = new Select(mpDriver_centralClass.getICD().ICD_codeType);
		icd_dropdown.selectByValue(Excel.ICD_code);
		ExtentManager.test.log(Status.PASS, "[ICD Type is chosen]");

		ExtentManager.test.log(Status.INFO, "[Send the icd name]");
		mpDriver_centralClass.getICD().ICD_codeName.sendKeys(Excel.ICD_name);
		ExtentManager.test.log(Status.PASS, "[Sent the icd name]");

		ExtentManager.test.log(Status.INFO, "[Click the submit button]");
		mpDriver_centralClass.getICD().ICD_submit.click();
		ExtentManager.test.log(Status.PASS, "[Submit button clicked]");

		ExtentManager.test.log(Status.INFO, "[Click the submit button]");
		String successMsg = wait.until(ExpectedConditions.presenceOfElementLocated(ICD.wait_successMsg())).getText();
		SoftAssert a = new SoftAssert();

		a.assertEquals(successMsg, "ICD Code added successfully");
		ExtentManager.test.log(Status.PASS, "[Submit button clicked]");
		a.assertAll();
		
		String[] UIvalues= {Excel.ICD_numbers,Excel.ICD_code,Excel.ICD_name};
		String query= String.format("SELECT * from mp_icd_codes where icd_code_number= '%1$s'",Excel.ICD_numbers);
		
		mpDriver_centralClass.getDbConnection().DB("ICD",query, UIvalues);

	}

}
