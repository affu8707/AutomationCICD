package afnanacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import afnanaacademy.AbstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent {

	WebDriver driver;

	public cartPage(WebDriver driver) { // calling from main class with the help of objects
		// initialization of constructor
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	// Page factory mechanism

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> productTitles;

	

	public Boolean VerifyProductDisplay(String productName) {
		Boolean Match = productTitles.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return Match;
		
	}
	
	public CheckOutPage goToCheckout() {
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutEle);
		
		return new CheckOutPage(driver);
	}

}
