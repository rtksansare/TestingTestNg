import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonMethods {
	public static WebDriver driver;
	
	@BeforeClass
	public void openingBrowser() {
		//Setting up WebDriver
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				driver.manage().window().maximize();
		        driver.manage().deleteAllCookies();
		        //driver.get("https://www.amazon.in/");
		        driver.navigate().to("https://www.saucedemo.com/");        
	}
	
	public void waitMethod(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
