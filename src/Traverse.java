import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Traverse {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//WebElement login = driver.findElement(By.linkText("Login"));
		//login.click();
		driver.findElement(By.xpath("//div/form/div[1]")).sendKeys("67676903");
		driver.findElement(By.xpath("//form/div[1]")).sendKeys("sample");
		String text = driver.findElement(By.xpath("//div/form/div[3]")).getText();
		System.out.println(text);
		
	}

}
