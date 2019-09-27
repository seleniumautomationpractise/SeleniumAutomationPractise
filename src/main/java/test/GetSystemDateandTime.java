package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetSystemDateandTime 
{
	public static void main(String[] args) 
	{
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		 System.out.println("Current Date & Time : " +date1);
		 
		 
		 
		 
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
		 
		 //get current date time with Date()
		 Date date2 = new Date();
		 
		 // Now format the date
		 String date3= dateFormat2.format(date2);
		 
		 // Print the Date
		 System.out.println("Current Date : " +date3);
		 
		 
			
		 // Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat3 = new SimpleDateFormat("HH:mm:ss");
		 
		 //get current date time with Date()
		 Date date4 = new Date();
		 
		 // Now format the date
		 String time1= dateFormat3.format(date4);
		 
		 // Print the Date
		 System.out.println("Current Time : " +time1);
	}
}
