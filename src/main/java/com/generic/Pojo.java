package com.generic;

import java.awt.Robot;
import java.util.Properties;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pojo 
	{
		 private WebDriver driver;
		 private WebDriverWait wait;
		 private Wrapperfunction objWrapperfunction;
		 private Properties objconfigProperties ;
		 private Logger objLogger;
		 private Excel_utilities objExcelUtilities ;
		 private JavascriptExecutor objjs  ; 
		 private Actions objActions ;
//		 private Select objslt;
//		 private Alert objAlert;
		 private Robot objrobot;
		 
		
		 public WebDriver getDriver() {
			 return driver;
		 }

		 public void setDriver(WebDriver driver) {
			 this.driver = driver;
		 }

		 public WebDriverWait getWait() {
			 return wait;
		 }

		 public void setWait(WebDriverWait wait) {
			 this.wait = wait;
		 }

		 public Wrapperfunction getObjWrapperfunction() {
			 return objWrapperfunction;
		 }

		 public void setObjWrapperfunction(Wrapperfunction objWrapperfunction) {
			 this.objWrapperfunction = objWrapperfunction;
		 }

		 public Properties getObjconfigProperties() {
			return objconfigProperties;
		 }

		 public void setObjconfigProperties(Properties objconfigProperties) {
			this.objconfigProperties = objconfigProperties;
		 }

		 public Logger getObjLogger() {
			return objLogger;
		 }

		 public void setObjLogger(Logger objLogger) {
			this.objLogger = objLogger;
		 }

		 public Excel_utilities getObjExcelUtilities() {
			return objExcelUtilities;
		 }

		 public void setObjExcelUtilities(Excel_utilities objExcelUtilities) {
			this.objExcelUtilities = objExcelUtilities;
		 }

		 public JavascriptExecutor getObjjs() {
			return objjs;
		 }

		 public void setObjjs(JavascriptExecutor objjs) {
			this.objjs = objjs;
		 }

		 public Actions getObjActions() {
			return objActions;
		 }

		 public void setObjActions(Actions objAction) {
			this.objActions = objAction;
		 }

		 public Robot getObjrobot() {
			return objrobot;
		 }

		 public void setObjrobot(Robot objrobot) {
			this.objrobot = objrobot;
		 }

		 
		
		

		 

		
	
	
}
