package com.generic;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Wrapperfunction 
{
	Pojo objPojo;
	
	public Wrapperfunction(Pojo pojo)
	{
		this.objPojo = pojo;
	}
	
	
	
		public boolean checkElementIsDisplayed(By locator)  // Verify (locator) WebElement is display
		{
		try
		{
		objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = objPojo.getDriver().findElement(locator);
		return element.isDisplayed();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		}
	
		
		// Verify Element is display
		public boolean checkElementIsDisplayed(WebElement element) 
		{
		try
		{
		objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		}
	 
		// Verify, Send data to locator
		public void SendKeysToElement(By locator, String txtfeildtext)   
		{
		try
		{
		objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = objPojo.getDriver().findElement(locator);
		clearThetext(element);
		element.sendKeys(txtfeildtext);
		}
		catch (Exception e) 	
		{
			e.printStackTrace();
		}
		}
	
	
		//verify , Send data to  element
		public  String SendKeysToElement(WebElement element,String txtfeildtext)  
		{
		try
		{
		objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
		clearThetext(element);
		element.click();
		element.sendKeys(txtfeildtext);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return txtfeildtext;
		}
	
	
		// Verify (locator) element is clickable
		public void clickOnElement(By locator)  
		{
		try
		{
		objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		//checkElementIsDisplayed(locator);
		WebElement element = objPojo.getDriver().findElement(locator);
		element.click();
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	
		}
		
	
		 // Verify element is clickable
		public boolean clickOnElement(WebElement element) 
		{
		try
		{
		objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
		//checkElementIsDisplayed(element);
		element.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		}
	
	
	
		 // verify , Get Text of the Page
		public String  GetTitleOfThePage() 
		{
		return objPojo.getDriver().getTitle();
		}
		
		 // Verify , Get Text of the element
		public String TextOfTheLocatedElement(WebElement element) 
		{
		try
		{
			 objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
			 String str="text";
			 return element.getText();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return"";
		}
	
	}
	
	
		 // Verify , get text of the element located
		public String TextOfTheLocatedElement(By locator)   
		{
		try
		{
			objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement ele = objPojo.getDriver().findElement(locator);
			return ele.getText();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "";
		}
		}
	
		 // Verify , Clear the text written
		public void clearThetext(WebElement element)      
		{
		try
		{
		objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
		element.clear();
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		}
	
//--------------------------------------------------------------------------------------------	
		// Verify , Switch windoe based on the WID(url)
		public void SwitchWindowBasedOnWindowId(String WID)
		{
		try
		{
			String ParentWindowId =  objPojo.getDriver().getWindowHandle();
			Set<String> ChildwindowIds = objPojo.getDriver().getWindowHandles();
			for(String windowIds : ChildwindowIds )
			 {
				if(!windowIds.equals(WID))
				 {
					objPojo.getDriver().switchTo().window(windowIds);
					System.out.println("driver is on "+  objPojo.getDriver().getTitle());
			
				 	}
			 	}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
	
		// Verify , Switch window to the parent window
			public void windowSwitchingMethod()
			{
			try
			{
			String ParentWindowId =  objPojo.getDriver().getWindowHandle();
			Set<String> ChildwindowIds = objPojo.getDriver().getWindowHandles();
			for(String windowIds : ChildwindowIds )
			 {
			if(!windowIds.equals(ParentWindowId))
			 {
				objPojo.getDriver().switchTo().window(windowIds);
				System.out.println("driver is on "+  objPojo.getDriver().getTitle());
		
			 	}
			 objPojo.getDriver().switchTo().window(ParentWindowId);
			 GetTitleOfThePage();
			 //System.out.println("driver is on "+ driver.getTitle());
		 	}
			}
			catch(Exception e)
		 	{
				e.printStackTrace(); 
		 	}
			
			}
			
			
			
			
//	---------------------------------------------------------------------------------	
		
			//JavaScript methods , Verify click on elementh
			public boolean ClickOnElewithJS(WebElement element)
			{
				try
			{
			objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
			objPojo.getObjjs().executeScript("arguments[0].click();", element);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
			}
		
		
		
		
			public boolean ClickonElement(By locator)
			{
			try
			{
			objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement element = objPojo.getDriver().findElement(locator);
			objPojo.getObjjs().executeScript("argument[0].click();", element);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
			}
				
			
			// set the value or send value to elements
			public String SendKeysbyJSEle(WebElement element  , String text){
			try{
				objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
				objPojo.getObjjs().executeScript("argument[0].value = 'text';", element);
				}
				catch(Exception e){
				e.printStackTrace();
				}
			return text;
			}
		
			public String SendKeysbyJSLoc(By locator  , String text){
			try{
				objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
				WebElement element = 	objPojo.getDriver().findElement(locator);
				objPojo.getObjjs().executeScript("argument[0].value = 'text';", element);
				}
				catch(Exception e){
				e.printStackTrace();
				}
			return text;
			}
			
	//-------------------------------------------------------------------------------------		
			//Scroll the element till it comes in view port [true=up][false=down]
			public boolean ScrollIntoViewByjsElement(WebElement element )
			{
				try{
					objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
					objPojo.getObjjs().executeScript("argument[0].scrollIntiView(true);", element);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return false;
			}
			
			
			//Scroll till element 
			public boolean ScrollIntoViewByjsLocator(By locator)
			{
				try{
					objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
					WebElement element = 	objPojo.getDriver().findElement(locator);
					objPojo.getObjjs().executeScript("argument[0].scrollIntiView(true);", element);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return false;
			}
	//----------------------------------------------------------------------------------------------------------		
			//Scroll the window by given pixel. doesn't care about element / negative value we can pass
			public boolean ScrollToEleByJSEle(WebElement element , int x , int y)
			{
				try{
					objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
					objPojo.getObjjs().executeScript("window.scroll(x ,y)");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return false;
			}
			
			
			//Scroll  the WINDOW
			public boolean ScrollToEleByJSlocator(By locator, int x , int y)
			{
				try{
					objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
					WebElement element = 	objPojo.getDriver().findElement(locator);
					objPojo.getObjjs().executeScript("window.scroll(x,y)");
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return false;
			}
			
//---------------------------------------------------------------------
			// highlight ele method of java script
				public void highlightElementByJS(WebElement element)
				{
				try{
					objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
					objPojo.getObjjs().executeScript("argument[0].style.border= '3px soli red'; argument[0].style.background='yellow';", element);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}
			
				
				public void highlightElementByJS(By locator)
				{
				try{
					objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
					WebElement element = 	objPojo.getDriver().findElement(locator);
					objPojo.getObjjs().executeScript("argument[0].style.border= '3px soli red'; argument[0].style.background='yellow';", element);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}

//-------------------------------------------------------------------------------------------------
		
				// select class method select the element by Index
				public void selectByindexByEle(WebElement element ,int index)
				{
					try{
						Select select = new Select(element);
						objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
						select.selectByIndex(index);
						}
						catch(Exception e)
						{
						e.printStackTrace();
						}
				}
				
				public void selectByindexByLoc(By locator ,int index)
				{
					try{
						WebElement element = 	objPojo.getDriver().findElement(locator);
						Select select = new Select(element);
						objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
						select.selectByIndex(index);
						}
						catch(Exception e)
						{
						e.printStackTrace();
						}
				}
				
	//-----------------------------------------------------------
				// Select by value method of select class
				public void selectByValueByEle(WebElement element ,int index)
				{
					try{
						Select select = new Select(element);
						objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
						select.selectByIndex(index);
						}
						catch(Exception e)
						{
						e.printStackTrace();
						}
				}
				
				public void selectByValueByLoc(By locator ,int index)
				{
					try{
						WebElement element = 	objPojo.getDriver().findElement(locator);
						Select select = new Select(element);
						objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
						select.selectByIndex(index);
						}
						catch(Exception e)
						{
						e.printStackTrace();
						}
				}
//--------------------------------------------------------------------------------	
				// select by visible text method of select class
				public void selectByVisibiltiesByEle(WebElement element ,int index)
				{
					try{
						Select select = new Select(element);
						objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
						select.selectByIndex(index);
						}
						catch(Exception e)
						{
						e.printStackTrace();
						}
				}
				
				public void selectByVisibilitiesByLoc(By locator ,int index)
				{
					try{
						WebElement element = 	objPojo.getDriver().findElement(locator);
						Select select = new Select(element);
						objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
						select.selectByIndex(index);
						}
						catch(Exception e)
						{
						e.printStackTrace();
						}
				}
//---------------------------------------------------------------------------------				
		// Dismiss method of Alert 
			public void dismissMethodOfAlert()
			{
				try
					{
					objPojo.getWait().until(ExpectedConditions.alertIsPresent());
					Alert alert = objPojo.getDriver().switchTo().alert();
					alert.dismiss();
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		
			//Accept method of Alert
			public void AcceptMethodOfAlert()
			{
				try
					{
					objPojo.getWait().until(ExpectedConditions.alertIsPresent());
					Alert alert = objPojo.getDriver().switchTo().alert();
					alert.dismiss();
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
			//GetText Method of Alert
			public String getTextMethodOfAlert(String text)
			{
				try
				{
					objPojo.getWait().until(ExpectedConditions.alertIsPresent());
					Alert alert = objPojo.getDriver().switchTo().alert();
					alert.getText();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return text;
			}
			
			
			public String SendTextMethodOfAlert(String text)
			{
				try
				{
					objPojo.getWait().until(ExpectedConditions.alertIsPresent());
					Alert alert = objPojo.getDriver().switchTo().alert();
					alert.sendKeys(text);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return text;
			}
//-------------------------------------------------------------------------				
//				Methods Of Action class
			
			
			// MoveToElement method used to hover on a element
			public void hovermoveToElementActionMethod(WebElement element)
			{
				try
				{
					objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
					objPojo.getObjActions().moveToElement(element).perform();

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
			public void RightClickOnElement(WebElement element)
			{
				try
				{
					objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
					objPojo.getObjActions().contextClick().perform();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
			public void doubleClickOnTheElement(WebElement element)
			{
				try
				{
					objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
					objPojo.getObjActions().doubleClick(element).perform();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			public void ClickMethodOfAction(WebElement element)
			{
				try
				{
					objPojo.getWait().until(ExpectedConditions.visibilityOf(element));
					objPojo.getObjActions().click(element).perform();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			public void dragAndDrop( By source  ,  By target)
			{
				try
				{
				objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(source));
				objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(target));
				WebElement src = objPojo.getDriver().findElement(source);
				WebElement tgt = objPojo.getDriver().findElement(target);
				objPojo.getObjActions().dragAndDrop(src, tgt).perform();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			
//-------------------------------------------------
//			Methods of RoBot class
			public void pressKeyMethodOfRobot()
			{
				try {
					Robot robot = new  Robot();
					//objPojo.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			public void CopyPasteMethodOfRobot()
			{
				try
				{
					
				}
				catch(Exception e)
				{
					e.printStackTrace();				}
			}
			
//			   robot.keyPress(KeyEvent.VK_CONTROL);
//		        robot.keyPress(KeyEvent.VK_V);
//		        robot.keyRelease(KeyEvent.VK_V);
//		        robot.keyRelease(KeyEvent.VK_CONTROL);
//
//		        robot.keyPress(KeyEvent.VK_ENTER);
//		        robot.keyRelease(KeyEvent.VK_ENTER);
			
	}

	
	
	
	
