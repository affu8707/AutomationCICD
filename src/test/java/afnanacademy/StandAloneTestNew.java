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

import afnanacademy.pageobjects.LandingPage;
import junit.framework.Assert;

public class StandAloneTestNew {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/client/");
		
		//LandingPage LandingPage = new LandingPage(driver);

		driver.findElement(By.id("userEmail")).sendKeys("affu@gmail.com");

		driver.findElement(By.id("userPassword")).sendKeys("Afnan@123");

		driver.findElement(By.id("login")).click();

		// Now take the list of all product using some similarity

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> productQuality = driver.findElements(By.className("mb-3"));

		// Here we are using JAVA streams method
		WebElement prod = productQuality.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		// until the loading button works

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		// ng-animating

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		// Now click on add to cart button and open cart

		driver.findElement(By.cssSelector("button[routerlink*='/dashboard/cart']")).click();

		// Now we are in Add to cart page

		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));

		// Here we are if any product is present in add to cart or not
		Boolean Match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(Match);

		// Thread.sleep(2000); // or better, wait for toast to disappear completely
		
		

		// Now we are clicking on check out button

		driver.findElement(By.cssSelector(".totalRow button")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build()
				.perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ta-results")));

		driver.findElements(By.xpath("//button[contains(@class, 'ta-item')]")).get(1).click();

		driver.findElement(By.cssSelector(".btnn.action__submit")).click();

		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
