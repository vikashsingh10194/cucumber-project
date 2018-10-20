package CucumberProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberSteps {

	static WebDriver driver;

	@Given("^user launches Gmail website$")
	public void user_launches_Gmail_website() throws Throwable {

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user login to gmail$")
	public void user_login_to_gmail() throws Throwable {

		WebDriverWait excplicitWait = new WebDriverWait(driver, 20);

		WebElement mailID, password;

		mailID = excplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		mailID.sendKeys("saurabhsharma.it14@gmail.com");

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		password = excplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.sendKeys("Mahakaal@2910");

		driver.findElement(By.xpath("//span[text()='Next']")).click();

	}

	@Then("^user logout from Gmail$")
	public void user_logout_from_Gmail() throws Throwable {

		WebElement logout;
		WebDriverWait excplicitWait = new WebDriverWait(driver, 15);
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		logout = excplicitWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='gb_db gbii']")));
		logout.click();

		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		
		driver.quit();
	}

}
