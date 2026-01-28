package testscript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.generic.BaseTest;

public class TestScript4 extends BaseTest
{
	LoginPageView objLoginPageView;
	
	
	
	@BeforeClass(groups = {"smoke"})
	public void setUp() 
	{
		BrowserSetup();
		getObjLogger().info("Browser launched");
		objLoginPageView = new LoginPageView(this);	
	}
	
	

	@Test(groups = {"smoke"} , priority =0)
	public void TC_01_VerifyUIOfHRM()
	{
		
		objLoginPageView.VerifyAllComponentsAreDisplay("Username" , "username", "Login"); 
		objLoginPageView.VerifyAllComponentsAreDisplay("Password" , "password" , "Login"); 
		System.out.println("TC_01_VerifyUIOfHRM executed of tsc 04");
	}

	
	
	@Test(dataProvider = "data" ,  groups = {"regression" , "smoke"})
	public void TC_03VerifyInvalidLogin(String usernameData , String passwordData)
	{
		objLoginPageView.VerifyUnSuccessfullloginwithInValidCredentials("username", "password", "Login" , usernameData , passwordData);
		System.out.println("TC_03VerifyInvalidLogin executed tsc 04");
		
	}
	
	
	@Test(groups = {"regression" , "smoke"})
	public void TC_02verifyValidLogin()
	{
		objLoginPageView.VerifySuccessfullLoginwithValidCredentials("username","password" ,"Admin", "admin123", "Login");
		System.out.println("TC_02verifyValidLogin executed tsc 04 ");
	}
	
	@AfterClass
	public void TC_05closureOfBrowser()
	{
		teardown();
	}
}

