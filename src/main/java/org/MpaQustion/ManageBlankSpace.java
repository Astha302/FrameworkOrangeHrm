package org.MpaQustion;

import java.util.*;

public class ManageBlankSpace 
{
		public static void main(String[] args)
		{
			Map<Integer , String > map = new LinkedHashMap<>();
			map.put(1, "username");
			map.put(2, "MiddleName");
			map.put(3, "Surname");
			map.put(4, null);
			map.put(5,"");
			map.put(6, "status");
			map.put(6, "status");
			System.out.println(map);
			
			System.out.println(map.get(4));
			map.put(2, "midName");
			System.out.println(map);
			
			System.out.println(map.containsKey(5));
			System.out.println(map.containsKey(3));
			System.out.println(map.containsValue("Surname"));
			System.out.println(map.remove(5));
			System.out.println(map);
			if(map.get(5)!= "")
			{
				System.out.println("found");
			}
			else
			{
				System.out.println("Not found");
				
			}
			for(String ValueOfKey : map.values())
			{
				if(ValueOfKey == null || ValueOfKey.isBlank())
				{
					continue;
				}
				
				System.out.println(map);
			}
			
		}
}
