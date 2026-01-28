package com.pages;

import org.openqa.selenium.By;

import com.generic.Pojo;

public class LogoutPage 
{
	Pojo objpojo;
	 public void LogoutPage(Pojo pojo)
	 {
		this.objpojo = pojo;
	 }
	 public static void main(String[] args) {
		 System.out.println("logout method");
	}
	
	By loc_DashBoard=By.xpath("//h6[text()='Dashboard']");
	
	public boolean VerifyBrandingNameOfTheCompanyIsDisplay()
	{
	return objpojo.getObjWrapperfunction().checkElementIsDisplayed(loc_DashBoard);
	
	}
	
	
}
