package afnanacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import afnanacademy.pageobjects.CheckOutPage;
import afnanacademy.pageobjects.LandingPage;
import afnanacademy.pageobjects.ProductCatalogue;
import afnanacademy.pageobjects.cartPage;
import afnanacademy.pageobjects.confirmationPage;

public class SubmitOrderTest {

	public WebDriver driver;
	public LandingPage landingPage;

	@BeforeMethod
	public void launchApplication() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
	}

	@Test
	public void submitOrder() throws InterruptedException {
		String productName = "ZARA COAT 3";

		landingPage.login_Application("affu@gmail.com", "Afnan@123");

		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);

		productCatalogue.goToCartPage();

		cartPage cartpage = new cartPage(driver);
		Boolean Match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(Match);

		CheckOutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.selectCountry("india");

		confirmationPage confirmpage = checkoutpage.submitOrder();
		String confirmMessage = confirmpage.verifyConfirmationMessage();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
