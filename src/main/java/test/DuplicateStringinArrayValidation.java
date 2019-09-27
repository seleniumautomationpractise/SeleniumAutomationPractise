package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateStringinArrayValidation 
{
	public static void main(String args[])
	{
		String names[] = {"Vijay, Arun, Karthick, Anand, Vijay, Hari, Vicky, Arun"};
		
		
		//3.Hash Map
		
		Map<String, Integer> storeMap = new HashMap<String, Integer>();
		
		for (String name : names) 
		{
			Integer count = storeMap.get(name);
			
			if (count==null) 
			{
				storeMap.put(name, 1);
			} 
			else 
			{
				storeMap.put(name, ++count);
			}
		}
		
		Set<Entry<String, Integer>> entryset = storeMap.entrySet();
		
		for (Entry<String, Integer> entry : entryset) 
		{
			if (entry.getValue()>1) 
			{
				System.out.println("Duplicate value : "+entry.getKey());
			}
		}
	}
}