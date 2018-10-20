package JavaConcepts;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.UserAndPassword;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

interface basicOne {

	public void menthodOne();
	public void menthodOne(int a);        // method overloading in interface
}

interface basicTwo {

	public void menthodOne();
	public void menthodOne(int a);        // method overloading in interface
}

public class InterfaceConcept implements basicOne, basicTwo {

	public static void main(String[] args) {
		
		WebDriver driver = null;
		Actions actions = new Actions(driver);
		WebElement toElement = null;
		actions.moveToElement(toElement).contextClick();               // move to element and right click...
		WebElement source = null;
		WebElement target = null;
		actions.dragAndDrop(source, target).build().perform();         // drag and drop...
		
		////////// another way to use action interface
		Action mouseHover = actions.moveToElement(toElement).build(); // compiles all the methods and steps...
		mouseHover.perform();                                         // execute the action by .perform() method of Action interface...

		///////// Alerts ////////////////////////////////
		
		Alert alert = driver.switchTo().alert();
		alert.authenticateUsing(new UserAndPassword("username", "password")); // HTTP auth alert box....basic one......
		alert.accept();                                     // to accept/click on OK alert pop up...
		alert.dismiss();                                    // to dismiss.click on Cancel alert pop up...
		
		//////////// how to make a Javascript click /////////////
		
		((JavascriptExecutor)driver).executeScript("argument[0].click()", toElement);
		Assert.assertTrue(true);
		SoftAssert soft = new SoftAssert();
		assertTrue(true, "");
		
	}

	@Override
	public void menthodOne(int a) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void menthodOne() {
		// TODO Auto-generated method stub
		
	}

}
