package afnanacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import afnanaacademy.AbstractComponents.AbstractComponent;
//import junit.framework.Assert;

public class confirmationPage extends AbstractComponent {
	WebDriver driver;

	public confirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	WebElement confirmMessage;

	// String confirmMessage =
	// driver.findElement(By.cssSelector(".hero-primary")).getText();

	// Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE
	// ORDER."));

	public String verifyConfirmationMessage() {
		return confirmMessage.getText();
	}

}
