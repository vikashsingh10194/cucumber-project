package TestNGProject.TestNG;

public class CommonMethods {

	static public void Wait(int timeInSeconds){
		try {
			Thread.sleep(timeInSeconds);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
