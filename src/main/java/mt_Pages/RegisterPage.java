package mt_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import mt_Base.TestBase;

public class RegisterPage extends TestBase {
	@FindBy(xpath ="//img[@src='/images/masts/mast_register.gif']")
	public static WebElement registerLabel;
	
	@FindBy(linkText = "REGISTER")
	public static WebElement linkRegister;
	
	@FindBy(name = "firstName")
	public static WebElement fn;
	
	@FindBy(name = "lastName")
	public static WebElement ln;
	
	@FindBy(name = "phone")
	public static WebElement phonenum;
	
	@FindBy(id = "userName")
	public static WebElement email;
	
	@FindBy(name = "address1")
	public static WebElement address;
	
	@FindBy(name = "city")
	public static WebElement City;
	
	@FindBy(name = "state")
	public static WebElement state;
	
	@FindBy(name = "postalCode")
	public static WebElement Zip;
	
	@FindBy(name = "country")
	public static WebElement country;
	
	@FindBy(id = "email")
	public static WebElement username;
	
	@FindBy(name = "password")
	public static WebElement password;
	
	@FindBy(name = "confirmPassword")
	public static WebElement confirmPassword;
	
	@FindBy(name = "register")
	public static WebElement SubmitBtn;
	
	//Initializing PO
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickAndVerifyRegisterLink() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		linkRegister.click();
		Assert.assertTrue(registerLabel.isDisplayed(), "NOt in Register Link");
		
	}
	public void basicInfo(String fname, String lname, String ph, String emailid, String adr, String city, String st, String zip, String uname, String pwd, String conpwd) {
		//String fname, String lname, int ph, String emailid, String adr, String city, String st, int zip, String uname, String pwd, String conpwd
		
		try {
		
		fn.clear();
		fn.sendKeys(fname);
		ln.sendKeys(lname);
		//phonenum.sendKeys(String.valueOf(ph));
		phonenum.sendKeys(ph);
		email.sendKeys(emailid);
		address.sendKeys(adr);
		City.sendKeys(city);
		state.sendKeys(st);
		//Zip.sendKeys(String.valueOf(zip));
		Zip.sendKeys(zip);
		Select s = new Select(driver.findElement(By.name("country")));
		s.selectByVisibleText("INDIA ");
		
		username.sendKeys(uname);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(conpwd);
		SubmitBtn.click();
		}
		catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}

}
