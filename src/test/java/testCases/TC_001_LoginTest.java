package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_LoginTest extends BaseClass {
	LoginPage login;
	@Test (priority=1 )
	public void successful_Login() throws Exception {
		logger.info("-----** Starting TC_001_LoginTest **-----");
		login = new LoginPage(driver);
		login.enterUserID("mngr473610");
		logger.info("User Name Entered");
		login.enterPassword("aparynu");
		logger.info("Password Entered");
		login.clickLogin();
		logger.info("Clicked on Login Button");
		logger.info("-----** Test Case PASSED **-----");
	}
	
	@Test(priority=2)
	public void click_leftmenu() throws Exception {
		successful_Login();
		List<WebElement> leftmenu=driver.findElements(By.xpath("//ul[@class=\"menusubnav\"]/li/a"));
		
		for(WebElement list:leftmenu) {
			System.out.println(list.getAttribute("href"));
		}
	}
	
}
