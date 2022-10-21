package stream;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewWindow {
	@Test
	public void handles() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> window = driver.getWindowHandles();
		Iterator<String>  it= window.iterator();
		
		//be careful while storing/ creating windows object 
		
		/*
		  String parentwindow = it.next();
		   String childwindow = it.next(); 
		*/
		
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		Thread.sleep(2000);
		driver.get("https://rahulshettyacademy.com/");
		String ele = driver.findElements(By.cssSelector("a[href='https://courses.rahulshettyacademy.com/p/get-access-to-all-courses']")).get(1).getText();
		driver.switchTo().window(parentwindow);
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(ele);
	}

}
