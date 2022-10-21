
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SubmitOrder {

	public static void main(String[] args)  {
		String name = "zara coat 3";
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client/");
		//LandingPage landingPage  = new LandingPage(driver); 
		
		
		driver.findElement(By.id("userEmail")).sendKeys("amol@testing.com");
		driver.findElement(By.id("userPassword")).sendKeys("Amol14@gmail");
		driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		
		/* for(WebElement et: products ) {
			 //System.out.println(et.getText());
		 System.out.println(et.findElement(By.cssSelector("b")).getText()); }
		 System.out.println(products.get(2).getText());*/

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase("zara coat 3"))
				.findFirst().orElse(null);

		/*WebElement prod =
		 products.stream().filter(product->product.findElement(By.xpath("//b"))
		.getText().equals("zara coat 3")).forEach(System.out::println);*/
		
		prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("button[routerlink*='/dashboard/cart']")).click();
		
		List<WebElement> cartProduct = driver.findElements(By.xpath("//div[@class ='cartSection']/h3"));
		boolean match = cartProduct.stream().anyMatch(cartprod->cartprod.getText().equalsIgnoreCase(name));
		//Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[text() = 'Checkout']")).click();
		driver.findElement(By.xpath("//div/input[contains(@placeholder,'Select Country')]")).sendKeys("Ind");
		driver.findElement(By.xpath("//section/button[2]")).sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Place Order ']")));
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		
	}

}
