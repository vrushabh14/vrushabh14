import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RahuShetty {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");

		String logo = driver.findElement(By.xpath("//span[contains(@class,'icon-circled')]")).getText();
		System.out.println(logo);
		driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("learning");

		// String text = driver.findElement(By.xpath("//span[contains(@class,'text-white
		// termsText')]")).getText();
		// String
		// text=driver.findElement(By.cssSelector("span.text-white.termsText")).getText();

		System.out.println(driver.findElement(By.cssSelector("span[class*='text-white']")).getText());
		
		Assert.assertEquals(driver.findElement(By.cssSelector("span[class*='text-white']")).getText(),
				"I Agree to the terms and conditions");
		
		/*Assert.assertNotEquals(driver.findElement(By.cssSelector("span[class*='text-white']")).getText(),
				"I Agree to the terms");*/

		// driver.findElement(By.cssSelector("#terms")).click();

		Select sc = new Select(driver.findElement(By.xpath("//select[@data-style='btn-info']")));
		sc.selectByIndex(1);
		driver.findElement(By.cssSelector("input[id*='signInBtn']")).click();
		//driver.close();

	}

}
