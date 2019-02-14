package mt_Pages;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mt_Base.TestBase;

public class SignOnPage extends TestBase{
	@FindBy(xpath ="//img[@src='/images/masts/mast_signon.gif']")
	//img[@src='/images/masts/mast_register.gif']
	//img[@src='/images/masts/mast_signon.gif']
	public static WebElement signOnLabel;

	@FindBy(linkText ="SIGN-ON")
	public static WebElement linkSignOn;
	
	@FindBy(name = "userName")
	public static WebElement username;
	
	@FindBy(name = "password")
	public static WebElement pwd;
	
	@FindBy(name = "login")
	public static WebElement submitbtn;
	
	
	//Initializing PO
			public SignOnPage() {
				PageFactory.initElements(driver, this);
			}
			
			
			
		public  void ClickAndVerifyLink () {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			linkSignOn.click();
			Assert.assertTrue(signOnLabel.isDisplayed(), "Not in sign on Page");
									 
		}
	
			
		public void Credentials(String uname,String pswd) {
			try {
		
		username.sendKeys(uname);
		pwd.sendKeys(pswd);
		submitbtn.click();
			}
			catch(Exception e) {
				e.printStackTrace();
				Assert.fail(e.getMessage());
			}
	}
	
	

}
