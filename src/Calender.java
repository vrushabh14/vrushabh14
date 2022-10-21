import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		WebElement perform = driver.findElement(By.cssSelector("#form-field-travel_comp_date"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		
		Thread.sleep(1000);
		perform.click();
		List<WebElement> days = driver.findElements(By.className("dayContainer"));
		int count = driver.findElements(By.className("dayContainer")).size();
		
		for(int i = 1; i<count; i++) {
			String text = driver.findElements(By.className("dayContainer")).get(i).getText();
			
			if(text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("dayContainer")).get(i).click();
				break;
			}
		}
		
	}

}
