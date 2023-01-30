package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ReadXLS;

public class BaseClass {
	public ResourceBundle rb;;
	public WebDriver driver;
	public Logger logger;

	@BeforeMethod
	@Parameters("browser")
	public void setup(String br) {
		rb = ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());// Initialized logs
//		ChromeOptions options = new ChromeOptions();// remove "Chrome controlled by automation tool msg"
//		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.get(rb.getString("appUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod // AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result) {
		// using ITestResult.FAILURE is equals to result.getStatus then it enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location
				// result.getName() will return name of test case so that screenshot name will
				// be same as test case name
				FileUtils.copyFile(src, new File("C:\\Users\\HP\\eclipse-workspace\\Guru99\\ScreenShots\\" + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		}
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}