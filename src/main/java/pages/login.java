package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class login {
	
	

	public login() {
		
		PageFactory.initElements(Base.Td.get(), this);
	}

	@FindBy(how = How.ID, using = "Usernname")
	public WebElement userName;

	@FindBy(how = How.ID, using = "Password")
	public WebElement Password;

	@FindBy(how = How.XPATH, using = "//button[@title='Sign in']")
	public WebElement Signin;
}
