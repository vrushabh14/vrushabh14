import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Vrushabh Wagh
 *
 */
public class Locator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//find xpath using and operator
		System.out.println(driver.findElement(By.xpath("//button[@class  = 'btn btn-primary' and text()='Home']")).getText());
		
		//traverse from parent->child->sibling->sibling 
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		//traverse from parent->child->sibling->sibling->sibling
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]/following-sibling::button[1]")).getText());
		
		//traverse from parent->child->immidiate parent->grand parent->find loacator
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header/a[@class='blinkingText']")).getText());
		
		//traverse from parent->child->immidiate parent->child[2]
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
	}

}
