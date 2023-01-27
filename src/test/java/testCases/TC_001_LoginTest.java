package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_001_LoginTest extends BaseClass {
	@Test
	public void successful_Login() {
		logger.info("-----** Starting TC_001_LoginTest **-----");
		LoginPage login = new LoginPage(driver);
		login.enterUserID("mngr473610");
		logger.info("User Name Entered");
		login.enterPassword("aparynu");
		logger.info("Password Entered");
		login.clickLogin();
		logger.info("Clicked on Login Button");
		logger.info("-----** Test Case PASSED **-----");
	}

}
