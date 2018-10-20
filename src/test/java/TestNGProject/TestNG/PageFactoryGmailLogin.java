package TestNGProject.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryGmailLogin {

	WebDriver driver;

	@FindBy(id = "identifierId")
	WebElement txtGmailEmailId;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement btnGmailContinue;

	@FindBy(name = "password")
	WebElement txtGmailPassword;

	@FindBy(xpath = "//span[text()='Next']")
	WebElement btnGmailLogin;

	@FindBy(xpath = "//span[@class='gb_db gbii']")
	WebElement btnGmailLogout;

	@FindBy(xpath = "//a[contains(text(),'Sign out')]")
	WebElement clickGmailSignOut;

	public PageFactoryGmailLogin(WebDriver driver) {

		this.driver = driver;
		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	public void setUserName(String userName) {

		txtGmailEmailId.sendKeys(userName);

	}

	public void clickContinue() {

		btnGmailContinue.click();

	}

	public void enterPassword(String passWord) {

		txtGmailPassword.sendKeys(passWord);

	}

	public void clickLogin() {

		btnGmailLogin.click();
	}

	public void clickLogout() {

		btnGmailLogout.click();
		CommonMethods.Wait(3000);
		clickGmailSignOut.click();
	}

	public void loginToGmail(String userName, String passWord) {

		System.out.println("test stared :------");
		
		setUserName(userName);

		CommonMethods.Wait(5000);

		clickContinue();

		CommonMethods.Wait(5000);

		enterPassword(passWord);

		clickLogin();

		CommonMethods.Wait(5000);

		clickLogout();
		
		System.out.println("test ended :------");

	}

}
