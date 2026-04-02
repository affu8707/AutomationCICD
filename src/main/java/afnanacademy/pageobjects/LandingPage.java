package afnanacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import afnanaacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) { // calling from main class with the help of objects
		// initialization of constructor
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	// Page factory mechanism

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submit;

	public void login_Application(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
