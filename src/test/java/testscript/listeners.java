package testscript;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.generic.Excel_utilities;
import com.utility.ExtentReportManager;


public class listeners implements ITestListener {
	String excelPath = "./src/test/resources/EmpData.xlsx";
	String sheetName = "StatusSheet";

	
	ExtentReports extent = ExtentReportManager.getExtentReport();
	ExtentTest test ;
	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println("Test Start :" +result.getName());
		 test = extent.createTest("Test Start :" +result.getName());
		}

 
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed: " + result.getName());
		System.out.println("PASS: " + result.getName());
		String tcid = result.getName();
		test.log(Status.PASS, tcid);
		Excel_utilities.writeDataInExcel(excelPath, sheetName, tcid, "PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println("Test failed: " + result.getName());
	//	System.out.println("Fail: " + result.getName());
		String tcid = result.getName();
		test.log(Status.FAIL, tcid);
		 
		// test = extent.createTest("Fail: " + result.getName());
			Excel_utilities.writeDataInExcel(excelPath, sheetName, tcid, "FAIL");
		
		// Add custom actions like screenshot
		// Add retry analyzer
		// Explore IAnnotationTransformer
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
		System.out.println("SKIP: " + result.getName());
			String tcid = result.getName();
			test.log(Status.SKIP, tcid);
			
				Excel_utilities.writeDataInExcel(excelPath, sheetName, tcid, "SKIP");
	}
	
	@Override
	  	  public void onFinish(ITestContext context) {
		    if (extent != null) {
		        extent.flush();
		        System.out.println("new extent report generated");
		    }
		}
}
