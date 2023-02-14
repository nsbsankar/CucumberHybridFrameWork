package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.CommonUtils;

public class DriverFactory {

	public static WebDriver driver;
	
	public static WebDriver initializeBrowser(String BrowserName) {
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			 driver = new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
		}else if(BrowserName.equalsIgnoreCase("edge")){
			 driver = new EdgeDriver();
		}else if(BrowserName.equalsIgnoreCase("safari")) {
			 driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
