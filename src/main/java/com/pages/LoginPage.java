package com.pages;

import org.openqa.selenium.By;
import com.generic.Pojo;

public class LoginPage 
	{
	Pojo objPojo;

	public LoginPage(Pojo pojo) 
	{
	this.objPojo = pojo;
	}
	
	// Locators
	By loc_BrandingOfTheCompany = By.xpath("//div//img[contains(@alt,'branding')]");
	By loc_PageNAme     = By.xpath("//h5[text()='Login']");
	By loc_forgetpasslnk = By.xpath("//p[text()='Forgot your password? ']");
 	 
	
	public boolean VerifyBrandingNameOfTheCompanyIsDisplay()
		{
		return objPojo.getObjWrapperfunction().checkElementIsDisplayed(loc_BrandingOfTheCompany);
		}
	

	public boolean verifyLoginPageNameIsDisplay()
		{
		return objPojo.getObjWrapperfunction().checkElementIsDisplayed(loc_PageNAme);
		}
	
	public boolean username_VerifylabelIsDisplayed(String textuserLbl)
		{
		By loc_UserLabel =  By.xpath("//label[text()='"+textuserLbl+"']");
		return objPojo.getObjWrapperfunction().checkElementIsDisplayed(loc_UserLabel);
		}
	
	
	public boolean Password_VerifylabelIsDisplayed(String textPassLbl)
		{
		By loc_passLabel =  By.xpath("//label[text()='"+textPassLbl+"']");
		return objPojo.getObjWrapperfunction().checkElementIsDisplayed(loc_passLabel);
		}
	
	public boolean verifyUserNameTextFieldIsDisplay(String UserNametxtfldtext) 
		{
		By loc_usertxtfield = By.xpath("//input[@name ='"+UserNametxtfldtext+"']");
		return objPojo.getObjWrapperfunction().checkElementIsDisplayed(loc_usertxtfield);
		}
	
	public boolean verifyPasswordTextFieldIsDisplay(String passtxtfldtext) 
		{
		By loc_passtxtfield = By.xpath("//input[@name ='"+passtxtfldtext+"']");
		return objPojo.getObjWrapperfunction().checkElementIsDisplayed(loc_passtxtfield);
		}

	public void VerifyUserdNametxtFeildAccpetingInput(String UserNametxtfldtext , String text)
		{
		By loc_Usertxtfeild =  By.xpath("//input[@name='"+UserNametxtfldtext+"']");
		objPojo.getObjWrapperfunction().SendKeysToElement(loc_Usertxtfeild ,text);
		}
	
	
	public void VerifyPasswordNametxtFeildAccpetingInput(String passtxtfldtext , String text)
		{
		By loc_Passtxtfeild =  By.xpath("//input[@name='"+passtxtfldtext+"']");
		objPojo.getObjWrapperfunction().SendKeysToElement(loc_Passtxtfeild , text);
		}
	
	public boolean verifyLoginButtonIsDisplay(String loginbtntext) 
		{
		By loc_btnLoginButton = By.xpath("//button[contains(.,'"+loginbtntext+"')]");
		return objPojo.getObjWrapperfunction().checkElementIsDisplayed(loc_btnLoginButton);
		}
		
	public void verifyLoginButtonIsclickable(String loginbtntext)
		{
		By loc_btnLoginButton = By.xpath("//button[contains(.,'"+loginbtntext+"')]");
		objPojo.getObjWrapperfunction().clickOnElement(loc_btnLoginButton);
		objPojo.getObjWrapperfunction().windowSwitchingMethod();
		}
	
//	public boolean verifytheErrorMessageIsDsiplay(String text)
//	{
//		By loc_errormsg = By.xpath("//p[text()='"+text+"']");
//	return objPojo.getObjWrapperfunction().checkElementIsDisplayed(loc_errormsg);
//	
//	}
	
	public boolean VerifyForgetPasswordlink()
		{
		return objPojo.getObjWrapperfunction().checkElementIsDisplayed(loc_forgetpasslnk);
		}
	
	public void VerifyFunctionalityOfForgetPasswordlink()
		{
		objPojo.getObjWrapperfunction().clickOnElement(loc_forgetpasslnk);
		}

	
}