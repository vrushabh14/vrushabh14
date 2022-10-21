import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * @author Vrushabh Wagh
 *
 */
public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// handle checkbox
		// System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		// check assertion method
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		// calender dropdown enambled & disabled

		// System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
		// System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if ((driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))) {
			System.out.println("Is Enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}
		// dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(By.xpath("//div/span[3]")).click();
		// System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.xpath("//div/span[3]")).click();
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		}

		/*
		 * int i =1; while(i<5) { driver.findElement(By.xpath("//div/span[3]")).click();
		 * i++; }
		 */
		driver.findElement(By.cssSelector("#btnclosepaxoption")).click();

	}

}
