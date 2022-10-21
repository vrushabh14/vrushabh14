import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//to scrolldown webpage goto the console enter 'window.scrollBy(x,y)' hit enter
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop = 5000");
		
		List<WebElement> count = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum =0;
		for(int i =1; i>count.size(); i++) {
		//System.out.println(Integer.parseInt(count.get(i).getText()));
		sum = sum + Integer.parseInt(count.get(i).getText());
		}
		System.out.println(sum);
		
		String value = driver.findElement(By.xpath("//div[text()=' Total Amount Collected: 296 ']")).getText().split("Collected:")[1].trim();
		int num =Integer.parseInt(value);
		
		Assert.assertEquals(sum, num);
		/*if(num == sum) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fails");
		}*/
		

	}

}
