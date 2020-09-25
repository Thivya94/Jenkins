package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ATI_Test_Baseclass.Baseclass;


public class Login_MP {

	public Login_MP() {
		
		PageFactory.initElements(Baseclass.driver, this);
	}

	@FindBy(how = How.ID, using = "Username")
	public WebElement userName;

	@FindBy(how = How.ID, using = "Password")
	public WebElement Password;

	
	  
	  public static By wait_signIn() {return By.xpath("//button[@title='Sign in']");}
		
			
		

}
