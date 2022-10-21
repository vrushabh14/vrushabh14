import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LiveDemo {

	//public static void main(String[] args)
	@Test
	public void RunTest()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on column 
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all webelement into list
		List<WebElement> elementlist = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelements into new (original) list
		List<String> originaList = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on original list of step 3 -> sorted list
		List<String> sortedList = originaList.stream().sorted().collect(Collectors.toList());
		
		//compare original list vs sorted list
		Assert.assertTrue(originaList.equals(sortedList));
		
		//scsn name column with gettext ->Beans->print the price of rice
		List<String> price;
		do
		{
			List<WebElement> row = driver.findElements(By.xpath("//tr/td[1]"));
		price = row.stream().filter(s->s.getText().contains("Beans")).map(s->LiveDemo.getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		if(price.size()<1) {
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);
		
		}
	
	public 	static String getPriceVeggie(WebElement s) {
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}
}


