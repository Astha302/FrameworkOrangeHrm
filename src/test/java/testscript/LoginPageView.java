package testscript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.generic.Pojo;
import com.pages.LoginPage;

public class LoginPageView
{
	
	 Pojo objPojo;
	 LoginPage objLoginPage;
	 SoftAssert softAssert = new SoftAssert();

	
	 public LoginPageView(Pojo pojo) {
			this.objPojo = pojo;
			objLoginPage = new LoginPage(objPojo);
		}
		
	 public void VerifyAllComponentsAreDisplay( String textuserLbl , String UserNametxtfldtext, String loginbtntext) 
		{
			 if(objLoginPage.VerifyBrandingNameOfTheCompanyIsDisplay())
			 {
				 System.out.println("Brand name is display on the webpage");
			 }
			 else
			 {
				 softAssert.assertTrue(false ," Brand name is not  display on the webpage");
			 }
			
			 if(objLoginPage.username_VerifylabelIsDisplayed(textuserLbl))
			 {
				 System.out.println("User Name label is display on webpage");
			 }
			 else
			 {
				 softAssert.assertTrue(false, "User Name label  is not display on webpage");
			 }
			 
//			 if(objLoginPage.Password_VerifylabelIsDisplayed(textuserLbl))
//			 {
//				 System.out.println("password text label is display on webpage");
//			 }
//			 else
//			 {
//				 softAssert.assertTrue(false ,"password text label is  not display on webpage");
//			 }
			 
			 if(objLoginPage.verifyUserNameTextFieldIsDisplay(UserNametxtfldtext))
			 {
				 System.out.println("User name text feild is display the input ");
			 }
			 else
			 {
				 softAssert.assertTrue(false ,"user name text feild is not display the input");
			 }
			 
			 
			 if(objLoginPage.verifyPasswordTextFieldIsDisplay(UserNametxtfldtext))
			 {
				 System.out.println("Password text feild is display on webpage");
			 }
			 else
			 {
				 softAssert.assertTrue(false ,"Password text feild is  not display on webpage");
			 }
			 
			 
			 if(objLoginPage. verifyLoginButtonIsDisplay(loginbtntext))
			 {
				 System.out.println("Login button is display on webpage");
			 }
			 else
			 {
				 softAssert.assertTrue(false ,"Login button is not display on webpage");
			 }
		}
	 
 
	 public void VerifySuccessfullLoginwithValidCredentials(String userInput , String PasswordInput ,String UNtext , String PStext , String loginbtntext)
	 {
		 objLoginPage.verifyUserNameTextFieldIsDisplay("username"); 
		 objLoginPage.verifyPasswordTextFieldIsDisplay("password");
		 objLoginPage.VerifyUserdNametxtFeildAccpetingInput(userInput , UNtext);
		 objLoginPage.VerifyPasswordNametxtFeildAccpetingInput(PasswordInput ,PStext);
		 objLoginPage.verifyLoginButtonIsclickable("Login"); 		
	//Assert.assertEquals("loginPAgeUrl" ,objPojo.getDriver().getCurrentUrl());
	 }

		 
	 
	 public void VerifyUnSuccessfullloginwithInValidCredentials(String userInput, String PasswordInput ,String loginbtntext ,String untext , String passtext)
	 {
		 objLoginPage.verifyUserNameTextFieldIsDisplay("username");
		 objLoginPage.verifyPasswordTextFieldIsDisplay("password");
		 objLoginPage.VerifyUserdNametxtFeildAccpetingInput(userInput , untext);
		 objLoginPage.VerifyPasswordNametxtFeildAccpetingInput(PasswordInput ,passtext);
		 objLoginPage.verifyLoginButtonIsclickable(loginbtntext);
	 }
	 
	
	 
}
