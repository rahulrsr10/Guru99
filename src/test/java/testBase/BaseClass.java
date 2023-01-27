package testBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	@BeforeClass
	public void setup() {
		logger=LogManager.getLogger(this.getClass());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V1/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
