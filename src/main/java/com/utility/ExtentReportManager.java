package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	    public static ExtentReports extent;

	    public static ExtentReports getExtentReport() {

	        if (extent == null) {

	            ExtentSparkReporter spark =
	                new ExtentSparkReporter("extentreport/ExtentReport.html");

	            spark.config().setReportName("Automation Execution Report");
	            spark.config().setDocumentTitle("Test Results");

	            extent = new ExtentReports();
	            extent.attachReporter(spark);

	            // System info
	            extent.setSystemInfo("Project", "E-Commerce App");
	            extent.setSystemInfo("Environment", "QA");
	            extent.setSystemInfo("Tester", "QA Team");
	            extent.setSystemInfo("Browser", "Chrome");
	        }

	        return extent;
	    }

}
