package mt_Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import mt_Base.TestBase;
import mt_Pages.RegisterPage;

public class RegisterPageTest extends TestBase{
	
	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		LaunchBrowser();
	}
	
	@Test(dataProvider = "getData")
	public void EnterBasicInfo(String fname, String lname, String ph, String emailid, String adr, String city, String st, String zip, String uname, String pwd, String conpwd) {
		
		RegisterPage rp = new RegisterPage();
		rp.ClickAndVerifyRegisterLink();
		rp.basicInfo(fname, lname, ph, emailid, adr, city, st, zip, uname, pwd, conpwd);
		
		
	} 	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][11];
		
		data[0][0]= "Abcd";
		data[0][1]="Xyzfgz";
		data[0][2]="989798668";
		data[0][3]= "kajajksha@jhjk.com";
		data[0][4]="212njnjnkd";
		data[0][5]="sjjdjd";
		data[0][6]="sjksj";
		data[0][7]="93938";
		data[0][8]="lklkdfdf";
		data[0][9]="dkjskdgfd";
		data[0][10]="jhjbjj";
		return data;
		
	}
	
}
