import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		// driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
	}
}
