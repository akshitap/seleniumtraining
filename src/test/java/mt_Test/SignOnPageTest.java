package mt_Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mt_Base.TestBase;
import mt_Pages.SignOnPage;

public class SignOnPageTest extends TestBase{
	//WebDriver driver;
	public SignOnPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() throws IOException {
		LaunchBrowser();
	}
	
	@Test
	public void SignIn() {
		
		SignOnPage sp = new SignOnPage();
		sp.ClickAndVerifyLink();
		sp.Credentials(prop.getProperty("uname"),prop.getProperty("pswd"));
		//System.out.println(prop.getProperty("uname"));
		//System.out.println(prop.getProperty("pswd"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
	
