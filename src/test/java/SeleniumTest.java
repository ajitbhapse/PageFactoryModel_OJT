import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumTest {

	WebDriver driver;
	Actions actions ;
	Action action;
	@Test
	public void register() {
		driver = new EdgeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		WebElement elem = driver.findElement(By.linkText("SwitchTo"));
		Actions action = new Actions(driver);
		
		action.moveToElement(elem).perform();
		action.click(driver.findElement(By.linkText("Windows"))).perform();
	}

	public void sendKeys(WebElement elem, String keyToEnter) {
		if (elem.isDisplayed() && elem.isEnabled()) {
			elem.clear();
			try {
				elem.sendKeys(keyToEnter);
			} catch (IllegalArgumentException ex) {
				System.out.print("Don't enter NULL value");
			}
		}
	}

	public void click(WebElement elem) {
		try {
			elem.click();
		} catch (StaleElementReferenceException ex) {
			System.out.print("Element is not attched to DOM");
		}
	}

	public void checkRadio(List<WebElement> elems, String chkValue) {
		for (WebElement elem : elems) {
			if (elem.getAttribute("value").equalsIgnoreCase(chkValue)) {
				elem.click();
				break;
			}
		}
	}

	public void selectByVisibleText(WebElement elem, List<String> text) {
		Select select = new Select(elem);
		if (!select.isMultiple()) {
			try {
				select.selectByVisibleText(text.get(0));
			} catch (NoSuchElementException ex) {
				System.out.println("options is not present in dropdown");
			}
		} else {
			for (String txt : text) {
				try {
					select.selectByVisibleText(txt);
				} catch (NoSuchElementException ex) {
					System.out.println("options is not present in dropdown");
				}
			}
		}
	}

	public List<WebElement> getOptions(WebElement elem) {
		Select select = new Select(elem);
		return select.getOptions();
	}

	
}
