package org.MpaQustion;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MapQusetions 
{		
	public static void main(String[] args) throws AWTException
	{
		WebDriver driver  = new ChromeDriver();
		driver.get("https://www.myntra.com/shop/men");
		
		
		Actions action = new Actions(driver);
	WebElement btnHomeButton = driver.findElement(By.xpath("//header//a[text()='Home']"));
	action.moveToElement(btnHomeButton).perform();
	
	  WebElement clockbutton = driver.findElement(By.xpath("//header//a[text()='Clocks']"));
	  action.click(clockbutton).perform();
	  
	  Robot robot = new Robot();
	    robot.delay(500);

	    robot.keyPress(KeyEvent.VK_TAB);
	    robot.keyRelease(KeyEvent.VK_TAB);

	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	   

	    // Paste (Ctrl+V on Windows / Cmd+V on mac)
//	    robot.keyPress(KeyEvent.VK_CONTROL);
//	    robot.keyPress(KeyEvent.VK_V);
//	    robot.keyRelease(KeyEvent.VK_V);
//	    robot.keyRelease(KeyEvent.VK_CONTROL);
//
//	    robot.delay(500);
//	    // Press Enter
//	    robot.keyPress(KeyEvent.VK_ENTER);
//	    robot.keyRelease(KeyEvent.VK_ENTER);
		}
}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
//				Map<Integer , String> map2 = new HashMap<Integer , String>();
//				
//				List<Integer> list = new ArrayList<Integer>();
//				
//				
//				map.put(1, "astha");
//				map.put(4, "Monica");
//				map.put(2, "omkar");
//				map.put(5, "Monica");
//				map.put(6, "Monica");
//				map.put(3, "omkar");
//				
//				System.out.println(map);
//			for(int i : map.keySet())
//			{
//				list.add(i);
//			}
//			
//			for(int i =0 ;i<list.size() ; i++)
//			{
//				for(int j = i+1 ;j<list.size() ; j++)
//				{
//					if(list.get(i)>list.get(j))
//					{
//						int temp = list.get(i);
//						list.set(i, list.get(j));
//						list.set(j , temp);
//					}
//					
//				}
//				System.out.println(list);
//			}
//			Map<Integer ,String> sortedMap = new LinkedHashMap<>();
//			for(Integer key : list)
//			{
//				sortedMap.put(key, map.get(key));
//			}
//	
//		System.out.println("Sorted Map is :"+sortedMap);
//	}                          		
//		
//}		
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	 
//		 List<Integer> list = new ArrayList<Integer>();
//		 List<Integer> list2 = new ArrayList<Integer>();
//		 
//		 list.add(11);
//		 list.add(12);
//		 list.add(12);
//		 list.add(12);
//		 list.add(14);
//		 list.add(14);
//		 System.out.println(list);
//		 
//		 int i ;
//		 for(i = 0; i <list.size() ; i++)
//		 {
//			if(!list2.contains(list.get(i)))
//			{
//				list2.add(list.get(i));
//			}
//		 }
//			 System.out.println(list2);
//		 }
//	 

