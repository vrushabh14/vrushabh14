import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//1.Give me th count of links on page
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2.Count of footer Section
		WebElement footerdriver = driver.findElement(By.id("gf-BIG")); // limiting webdriver scope
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//3.count of link of specific section
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//4.click on each link of the colum and check if the pages are opening
		for(int i =1; i<columndriver.findElements(By.tagName("a")).size(); i++) {
			
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		}
		
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		 
		 while(it.hasNext()) {
			 driver.switchTo().window(it.next());
			 System.out.println(driver.getTitle());
		 }
	}

}
