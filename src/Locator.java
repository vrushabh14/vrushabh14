import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		/*
		 * driver.manage().window().maximize();
		 * //driver.findElement(By.className("_2KpZ6l _2doB4z")).click();
		 * //driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		 * driver.findElement(By.cssSelector("button[class='_2KpZ6l _2doB4z']")).click()
		 * ;
		 */

		driver.findElement(By.cssSelector("input#email")).sendKeys("8308531139");
		driver.findElement(By.cssSelector("input#pass")).sendKeys("vipul14@gmail");
		driver.findElement(By.cssSelector("button._42ft._4jy0._6lth._4jy6._4jy1.selected._51sy")).click();
	}
}
