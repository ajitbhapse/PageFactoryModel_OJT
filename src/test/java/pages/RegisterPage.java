package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage extends BasePage{

	
	//@FindBy(xpath = "/html/body/section/div/div/div[2]/form/div[1]/div[1]/input")
	//private WebElement firstName;
	By firstName = By.xpath("");
	
	
	@FindBy(xpath = "/html/body/section/div/div/div[2]/form/div[3]/div[1]/input")
	private WebElement emailAddress;
	
	@FindBy(name="radiooptions")
	private List<WebElement> genders;
	
	@FindBy(id="Skills")
	private WebElement skills;
	
	public RegisterPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}	
	
	public void enterFirstName(String text) {
		sendKeys(firstName,text);
	}
	
	public void enterEmailAddress(String text) {
		sendKeys(emailAddress, text);
	}
	
	public void selectGender(String value) {
		selectRdoButton(genders,value);
	}
	
	public void selectSkills(String option) {
		selectByVisibleText(skills,option);
	}
	
	public String getTitle() {
		return null;
		
	}
	
	
	
	
	
	
	
	
	
}
