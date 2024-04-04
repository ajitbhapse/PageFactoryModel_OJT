package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	WebDriver driver;

	public void selectRdoButton(List<WebElement> radioBtn, String text) {
		for (WebElement rdBtn : radioBtn) {
			String value = rdBtn.getAttribute("value");
			if (text.equals(value)) {
				rdBtn.click();
				break;
			}
		}
	}

	public void selectCheckbox(List<WebElement> chkBoxs, List<String> hobbie) {
		for (String hob : hobbie) {
			for (WebElement chkBtn : chkBoxs) {
				String value = chkBtn.getAttribute("value");
				if (hob.equals(value)) {
					chkBtn.click();
					break;
				}
			}
		}
	}

	public void sendKeys(WebElement elem, String text) {
		if (elem.isDisplayed() && elem.isEnabled()) {
			elem.clear();
			try {
				elem.sendKeys(text);
			} catch (IllegalArgumentException ex) {
				System.out.println("you can not enter null value in textbox");
			}
		}
	}

	public void sendKeys(By by, String text) {
		WebElement elem = driver.findElement(by);
		sendKeys(elem,text);
	}

	protected BasePage click(WebElement elem) {
		try {
			elem.click();
		} catch (StaleElementReferenceException ex) {
			// handle the StaleElementReferenceException
		}
		return null;
	}

	public void click(By by) {
		try {
			WebElement elem = driver.findElement(by);
			elem.click();
		} catch (StaleElementReferenceException ex) {
			// handle the StaleElementReferenceException
		}
	}

	public void selectByVisibleText(WebElement elem, String option) {
		// wait
		Select dropdown = new Select(elem);
		try {
			dropdown.selectByVisibleText(option);
		} catch (NoSuchElementException ex) {
			System.out.println("no matching option elements are found");
		}
	}
}
