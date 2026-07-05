package afnanacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import afnanaacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath = "(//button[contains(@class, 'ta-item')])[2]")
	WebElement selectCountry;
	
	By result = By.className("ta-results");
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();

		waitForElementToAppear(result);
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", selectCountry);
		
		
	}
	
	public confirmationPage submitOrder()
	{
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
		return new confirmationPage(driver);
	}
	
	

}
