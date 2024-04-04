package webDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AllWebDriverMethods {
	WebDriver driver = new ChromeDriver();
	/*
	 * Method name : get 
	 * Method Description : 
	 * Method Parameter : String 
	 * Method Return type : void 
	 * Exception : None
	 */
	@Test
	public void get() {
		driver.get("abc" + "test");
		driver.get("https://www.google.com/");
		driver.get("http://www.google.com/");
		driver.get("www.google.com/");
	}
	
	/*
	 * Method name : getTitle 
	 * Method Description : The title of the current page
	 * Method Parameter : String 
	 * Method Return type : String 
	 * Exception : None
	 */
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

}
