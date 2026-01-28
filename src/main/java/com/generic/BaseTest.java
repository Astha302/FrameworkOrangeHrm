package com.generic;

import java.io.FileInputStream;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.jspecify.annotations.Nullable;

public class BaseTest extends Pojo {
	public void BrowserSetup() {
		setDriver(new ChromeDriver());
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		setObjWrapperfunction(new Wrapperfunction(this));
		setObjconfigProperties(new Properties());
		setObjLogger((Logger) LogManager.getLogger(this.getClass()));
		setWait(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
		loadConfigProperties();
		getDriver().manage().window().maximize();
		getDriver().get(getObjconfigProperties().getProperty("OrangeHrmLoginPageUrl"));
		setObjjs((JavascriptExecutor) getDriver());
		setObjActions(new Actions(getDriver()));
		// setObjActions((Actions)getDriver());
		setObjExcelUtilities(new Excel_utilities(this));
		// setObjrobot(new Robot());

	}

//	objPojo.setJs((JavascriptExecutor)objPojo.getDriver());
//	objPojo.getJs().executeScript("arguements[0].click();",element );

//    @DataProvider(name = "EmpData", parallel = false) // set parallel=true only if utility is thread-safe
//    public static Object[][] excelData() throws Exception {
//        String path = "./src/test/resources/Data.xlsx";
//        String sheet = "Sheet1";
//        return ExcelUtil.getSheetData(path, sheet);

	@DataProvider(name = "data")
	public Object[][][] dataprovider() {
		Object[][][] invalidLogincred = {
				{ { "admin", "123", "12" }, { "as", "65", " 12" }, { "astha", "233", " " } } };
		return invalidLogincred;
	}

	public void loadConfigProperties() {
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
			getObjconfigProperties().load(fis);

			// another approach
			//getObjconfigProperties().load(getClass().getClassLoader().getResourceAsStream("config.properties"));
			// String value = getObjconfigProperties().getProperty("OrangeHrmLoginPageUrl");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Test()
	{
		System.out.println("test");
	}
	public void teardown() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}

}