import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage {
	
	public static String getpassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		String PasswordText = driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login.
		String[] PasswordArray = PasswordText.split("'");
		
		//String[] PasswordArray2 = PasswordArray[1].split("'");
		//PasswordArray2[0];
		
		String password = PasswordArray[1].split("'").clone()[0];
		//0th index -Please use temporary password
		//1st index - rahulshettyacademy' to Login.
		
		//0th index - rahulshettyacademy
		//1st index - to Login.
		return password;
	}

	public static void main(String[] args) throws InterruptedException {
		String name = "Vrushabh";
		
		System.setProperty("webdriver.edge.driver", "D:\\Selenium\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getpassword(driver);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);// ID
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);// CSS
		driver.findElement(By.xpath("//div//button[contains(.,'Sign In')]")).click();// Xpath
		System.out.println(driver.findElement(By.xpath("//h2[contains(.,'Hello Vrushabh,')]")).getText());
		System.out.println(driver.findElement(By.xpath("//p[contains(.,'You are successfully logged in.')]")).getText());
		// driver.findElement(By.xpath("//button[contains(@class,'logout-btn')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
	}

}
