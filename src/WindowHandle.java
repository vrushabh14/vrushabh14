import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		//Handle parent to child windows controll
		Set<String> windows = driver.getWindowHandles();
		 Iterator<String> it = windows.iterator();
		 String parentId = it.next();
		 String childId = it.next();
		 driver.switchTo().window(childId);
		 
		 System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
		 
		 String userid = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		 driver.switchTo().window(parentId);
		 driver.findElement(By.id("username")).sendKeys(userid);
	}

}
