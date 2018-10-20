package TestNGProject.TestNG;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestNGClass {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;
	PageFactoryGmailLogin pageFactoryGmailLogin;

	@BeforeTest
	public void startReport() {

		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
		extent.addSystemInfo("Host Name", "SoftwareTestingMaterial").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "Saurabh Sharma");
		// loading the external xml file (i.e., extent-config.xml) which was
		// placed under the base directory
		// You could find the xml file below. Create xml file in your project
		// and copy past the code mentioned below
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\test-output\\extent-config.xml"));

	}

	@BeforeMethod
	public void beforeMethod() {

		// if (driver instanceof ChromeDriver) {
		//
		// System.setProperty("webdriver.chrome.driver",
		// System.getProperty("user.dir") + "\\server\\chromedriver.exe");
		// driver = new ChromeDriver();
		//
		// } else if (driver instanceof InternetExplorerDriver) {
		//
		// System.setProperty("webdriver.ie.driver",
		// System.getProperty("user.dir") + "\\server\\IEDriverServer.exe");
		// }
		// else if(driver instanceof FirefoxDriver){
		//
		// driver = new FirefoxDriver();
		// }

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\server\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	 @Test
	 public void failTest() {
	 logger = extent.startTest("failTest");
	 Assert.assertTrue(false);
	 logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	 }
	//
	// @Test
	// public void skipTest() {
	// logger = extent.startTest("skipTest");
	// throw new SkipException("Skipping - This is not ready for testing ");
	// }

	@Test
	public void loginAndLogoutGmail()  {

		WebDriverWait excplicitWait = new WebDriverWait(driver, 30);

		WebElement mailID, password, logout;

		logger = extent.startTest("passTest");
		Assert.assertTrue(true);
		// To generate the log when the test case is passed
		logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		System.out.println("Executing my script : ");

		mailID = excplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		mailID.sendKeys("saurabhsharma.it14@gmail.com");

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		password = excplicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.sendKeys("Mahakaal@2910");

		driver.findElement(By.xpath("//span[text()='Next']")).click();

		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		logout = excplicitWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='gb_db gbii']")));
		logout.click();

		driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
		Reporter.log("Case Closed");

	}

	@Test
	public void pageFactoryGmailloginAndLogout() {

		pageFactoryGmailLogin = new PageFactoryGmailLogin(driver);
		
//		WebDriverWait excplicitWait = new WebDriverWait(driver, 30);
//		pageFactoryGmailLogin.txtGmailEmailId = excplicitWait.until(ExpectedConditions.visibilityOfElementLocated((By) pageFactoryGmailLogin.txtGmailEmailId));
		
		pageFactoryGmailLogin.loginToGmail("saurabhsharma.it14@gmail.com", "Mahakaal@2910");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test case passed is : " + result.getMethod());

		}

		extent.endTest(logger);

		extent.flush();
		extent.close();
		driver.quit();

	}

}
