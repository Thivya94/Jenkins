package Learning;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandling 
{
	@Test
	 public void test3() throws IOException, InterruptedException
	 {
		//debug and see the results and manually click the ok button in privacy 
		//inorder to understand window handling we have done this
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Multiple Windows")).click();
		
		driver.findElement(By.linkText("Click Here")).click();
		
	Set<String> ids=driver.getWindowHandles();
	Iterator<String> it=ids.iterator();
	String parentid=it.next();
	String Childid=it.next();
	driver.switchTo().window(Childid);
	
	System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	driver.switchTo().window(parentid);
	System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
	
	
	
	
	
	
	/*	
	 * Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parentid=it.next();
		String Childid=it.next();
		
		System.out.println(parentid+Childid);
		driver.switchTo().window(Childid);
		driver.findElement(By.xpath("//div[@class='popup_close']")).click();
		driver.findElement(By.xpath("(//img[@title='WBC Facebook'])[3]")).click();
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentid);
		System.out.println(driver.getTitle());
		
		
		Set<String> ids1=driver.getWindowHandles();
		Iterator<String> it1=ids1.iterator();
	
		String[] win= {it1.next(),it1.next(),it1.next()};
		
		
		
		driver.switchTo().window(win[2]);
		System.out.println(driver.getTitle());
*/
		
		
	 }

}
