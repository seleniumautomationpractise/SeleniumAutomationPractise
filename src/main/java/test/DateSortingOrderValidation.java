package test;


import java.text.SimpleDateFormat;
import java.util.*;

public class DateSortingOrderValidation 
{
	public static void main(String args[])throws Exception
	{
		String date = "Sep 7, 2019, 7:30:44 PM";
		
		String date1 = "Sep 6, 2019, 3:11:04 PM";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy, HH:mm:ss a");
		
		Date utilDate1 = dateFormat.parse(date);
		
		Date utilDate2 = dateFormat.parse(date1);
		
		ArrayList<Date> list = new ArrayList<Date>();
		
		list.add(utilDate1);
		
		list.add(utilDate2);
		
		System.out.println("The unsorted date "+list);
		
		Collections.sort(list);
		
		System.out.println("The sorted date is "+list);
	}
}