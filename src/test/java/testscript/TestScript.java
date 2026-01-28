package testscript;

import java.io.IOException;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.MpaQustion.MapQusetions;
import org.apache.commons.math3.stat.regression.RegressionResults;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.generic.BaseTest;
import com.pages.LoginPage;
import com.utility.ExtentReportManager;



@Listeners(listeners.class)
public class TestScript extends BaseTest
{
	ExtentReports extent;
	protected ExtentTest test;
	 
	LoginPageView objLoginPageView;
	
	String path ="./src/test/resources/EmpData.xlsx";
	String sheetName ="StatusSheet";
	
	
//	@BeforeSuite
//	  public void setupReport() {
//	      extent = ExtentReportManager.getExtentReport();
	      
	  
	 
	@BeforeClass
	public void setUp() 
	{
		BrowserSetup();
		//test = extent.createTest("Verify Orange HRM Tittle");
		getObjLogger().info("Browser launched");
		objLoginPageView = new LoginPageView(this);	
		System.out.println("setup method of tsc 2");
	}
	
	
	
	 @Test
	    public void TC_01_VerifyUIOfHRM() throws IOException {
	        Map<String, String> logindata=getObjExcelUtilities().getLoginData(path, sheetName, "TC_01");
	        String username=logindata.get("Username");
	        String password=logindata.get("Password");
	        Assert.assertTrue(true, "Username mismatch");
	       
	        Assert.assertTrue(true, "Password mismatch");
	        System.out.println("condition Fails");
	        System.out.println("Login Data for : " + logindata);
	    }
//@Test
//	 public void TC_02verifyValidLogin() throws IOException {
//	        Map<String, String> logindata=getObjExcelUtilities().getLoginData(path, sheetName, "TC_01");
//	        String username=logindata.get("Username");
//	        String password=logindata.get("Password");
//	        Assert.assertFalse(true, "Username mismatch");
//	        Assert.assertFalse(true, "Password mismatch");
//
//	        System.out.println("Login Data for : " + logindata);
//	    }
	 @Test(dependsOnMethods ="TC_01_VerifyUIOfHRM" )
	    public void TC_03VerifyInvalidLogin() throws IOException {
	        Map<String, String> logindata=getObjExcelUtilities().getLoginData(path, sheetName, "TC_01");
	        String username=logindata.get("Username");
	        String password=logindata.get("Password");
	        Assert.assertTrue(true, "Username mismatch");
	        Assert.assertTrue(true, "Password mismatch");

	        System.out.println("Login Data for : " + logindata);
	    }

	 
//	 @AfterSuite
//	  public void flushReport() {
//	      extent.flush();
//	  }
	}


