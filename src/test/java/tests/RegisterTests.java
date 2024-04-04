package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.RegisterPage;

public class RegisterTests {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
	}

	@Test
	public void registerTest() {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(null);
		registerPage.enterEmailAddress("Pooja@gmail.com");
		registerPage.selectGender("FeMale");
		registerPage.selectSkills("C++");
		//assertion
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
