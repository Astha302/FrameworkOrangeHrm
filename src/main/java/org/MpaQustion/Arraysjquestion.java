package org.MpaQustion;

public class Arraysjquestion {
	
	public static  void main(String[] args)
	{
		int[] arr = {1,2,3,0,7,8,9,1,5,4,6};
		int Size = arr.length;
		
		for(int i =0 ;i <Size ;i++)
		{
			for(int j = i+1; j <Size ;j++)
			{
				if(arr[i] > arr[j])
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i]= temp;
			}
			}
			System.out.println(arr[i]);
				}
			
		
	}
}
