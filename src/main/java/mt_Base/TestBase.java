package mt_Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public void LaunchBrowser() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Ankit-HP\\eclipse-workspace\\MercuryTours\\src\\main\\java\\mt_Config\\config.properties");
		prop.load(fis);
		
		//Launching Browser
		String Browser= prop.getProperty("browser");
		if (Browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/Ankit-HP/eclipse-workspace/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}
		else   {
			System.setProperty("webdriver.internetexplorer.driver", "");
			driver = new InternetExplorerDriver();
		}
		
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		
		//Maximizing window 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
		
		//Entering URL
		driver.get(prop.getProperty("url"));
	}

}
