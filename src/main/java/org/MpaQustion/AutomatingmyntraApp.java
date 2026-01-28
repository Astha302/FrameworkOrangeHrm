package org.MpaQustion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomatingmyntraApp 
{
	public static void main(String [] args)
	{
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://cosmocode.io/automation-practice-webtable/");
		 driver.manage().window().maximize();
		 
		 WebElement Loc_WebTable = driver.findElement(By.xpath("//div[@class='inside-article']"));
		  //List<WebElement> loc_Rows = driver.findElements(By.xpath("//strong[contains(text(),'Visit')]/ancestor::tr/td"));
		// WebElement loc_cols = driver.findElement(By.xpath("))

		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", Loc_WebTable);
		 System.out.println("scrolling into down");
		 
		// WebElement loc_checkbox = driver.findElement(By.xpath("//table[@id='countries']//tr[td[2]//strong='Belgium']//input"));
		// loc_checkbox.click();
		 
		 ////table[@id='countries']/tbody/tr[position() > 1]/td[position() > 1]//strong
		 //List<WebElement> loc_country = driver.findElements(By.xpath("//strong"));
		 
		 List<WebElement> rows = driver.findElements(
				    By.xpath("//table[@id='countries']/tbody/tr[position() > 1]")
				);

				for (WebElement row : rows)
				{
				    String countryName = row.findElement(By.xpath("td[2]//strong")).getText().trim();
				    if (countryName.equalsIgnoreCase("Belgium")) 
				    {
				    	 String actualCapital  = row.findElement(By.xpath("td[3]")).getText().trim();
				    	 System.out.println("Actual country name is :"+actualCapital);
				    	  String actualCurrency = row.findElement(By.xpath("td[4]")).getText().trim();
				    	  System.out.println("Actual currency is :"+actualCurrency);
				            String actualLanguage = row.findElement(By.xpath("td[5]")).getText().trim();
				            System.out.println("Actual lang is :"+ actualLanguage);
				        WebElement checkbox = row.findElement(By.xpath("//table[@id='countries']//tr[td[2]//strong='Canada']//input"));
				        if (!checkbox.isSelected()) 
				        {
				            checkbox.click();
				        }

				        break; 
			    }
				
		}	
	}
}



////table[@id='countries']/tbody"	+ "/tr[position() > 1]/td[position() > 1]//strong/../..