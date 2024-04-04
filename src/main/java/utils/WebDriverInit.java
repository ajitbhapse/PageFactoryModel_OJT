package utils;

import org.openqa.selenium.WebDriver;

public class WebDriverInit {
	
	WebDriver driver;
	
	public WebDriver initWebDriver(String browser) {
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("Chrome")) {
			//init chrome
			
		}else if(browser.equalsIgnoreCase("FF")) {
			
		}
		return driver;
		
	}

}
