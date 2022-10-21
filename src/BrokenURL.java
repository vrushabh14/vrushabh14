import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import graphql.Assert;

public class BrokenURL {

	public static void main(String[] args) throws Exception {

		// Broken links means broken URL
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a = new SoftAssert();
		// 1.To get all the URLs tied up to the link using selenium
		// Java mehod will call the url & get you the status code

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for (WebElement link : links) {
			String url = link.getText();
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responce = conn.getResponseCode();
			
			a.assertTrue(responce<400, "The link with " + link.getText() + "is broken & responce is: " + responce);

			/*if (responce > 400) {
				System.out.println("The link with " + link.getText() + "is broken & responce is: " + responce);
				Assert.assertTrue(false);
			}*/

		}
		a.assertAll();

		/*
		 * String url1 =
		 * driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute(
		 * "href");
		 * 
		 * 
		 * HttpURLConnection conn = (HttpURLConnection)new URL(url1).openConnection();
		 * conn.setRequestMethod("HEAD"); conn.connect(); int responce =
		 * conn.getResponseCode(); System.out.println(responce);
		 */
	}

}
