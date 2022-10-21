import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Vrushabh Wagh
 *
 */
public class DynamicDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		//To handle 2 dynamic dropdown we need select 1st dropdown dependent on one another values
		driver.findElement(By.xpath("//a[@value = 'BLR']")).click();
		//driver.findElement(By.xpath("(//a[@value ='MAA'])[1]")).click();
		driver.findElement(By.xpath("//div[@id ='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value ='MAA']")).click();
	
		//driver.close();
	}
}
