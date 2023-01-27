package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "uid")
	WebElement userID;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "btnLogin")
	WebElement loginBtn;

	public void enterUserID(String username) {
		userID.sendKeys(username);
	}

	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickLogin() {
		loginBtn.click();
	}

}
