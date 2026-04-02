package afnanacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import afnanacademy.pageobjects.CheckOutPage;
import afnanacademy.pageobjects.LandingPage;
import afnanacademy.pageobjects.ProductCatalogue;
import afnanacademy.pageobjects.cartPage;
import afnanacademy.pageobjects.confirmationPage;
import junit.framework.Assert;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		LandingPage LandingPage = new LandingPage(driver);
		LandingPage.goTo();

		LandingPage.login_Application("affu@gmail.com", "Afnan@123");

		// Now take the list of all product using some similarity

		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);

		// Here we are using JAVA streams method

		// Now click on add to cart button and open cart

		productCatalogue.goToCartPage();

		// Now we are in Add to cart page

		cartPage cartpage = new cartPage(driver);

		// Here we are if any product is present in add to cart or not

		Boolean Match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(Match);
		// Thread.sleep(2000); // or better, wait for toast to disappear completely

		// Now we are clicking on check out button

		CheckOutPage checkoutpage = cartpage.goToCheckout();

		checkoutpage.selectCountry("india");

		confirmationPage confirmpage = checkoutpage.submitOrder();

		String confirmPage = confirmpage.verifyConfirmationMessage();
		
		Assert.assertTrue(confirmPage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
