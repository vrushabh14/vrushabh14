
package stream;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElePartialScreenshot {
	@Test
	public void Handles() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();

		// be careful while storing/ creating windows object

		/*
		 * String parentwindow = it.next(); String childwindow = it.next();
		 */

		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		Thread.sleep(2000);
		driver.get("https://rahulshettyacademy.com/");
		String ele = driver
				.findElements(
						By.cssSelector("a[href='https://courses.rahulshettyacademy.com/p/get-access-to-all-courses']"))
				.get(1).getText();
		driver.switchTo().window(parentwindow);
		WebElement elem = driver.findElement(By.cssSelector("input[name='name']"));
		elem.sendKeys(ele);
		File file = elem.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));

		// get height & width
		System.out.println(elem.getRect().getHeight());
		System.out.println(elem.getRect().getWidth());
		driver.quit();
	}

}
