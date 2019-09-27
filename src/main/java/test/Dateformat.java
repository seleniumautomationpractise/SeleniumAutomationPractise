package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateformat 
{
	public static void main(String[] args) 
	{        
		String date = "2016/12/29 10:15";
		
        validateJavaDate("12/29/2016");
        validateJavaDate(date);
        validateJavaDate("2016-12-29 10:15");
    	validateJavaDate("12-29-2016");
    	validateJavaDate("12,29,2016");
	}

		
	public static boolean validateJavaDate(String strDate)
	   {
		/* Check if date is 'null' */
		if (strDate.trim().equals(""))
		{
		    return true;
		}
		/* Date is not 'null' */
		else
		{
		    /*
		     * Set preferred date format,
		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy/MM/dd hh:ss");
		    sdfrmt.setLenient(false);
		    /* Create Date object
		     * parse the string into date 
	             */
		    try
		    {
		        Date javaDate = sdfrmt.parse(strDate); 
		        
		        System.out.println(javaDate);
		        
		        System.out.println(strDate+" is valid date format");
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
		        System.out.println(strDate+" is Invalid Date format");
		        return false;
		    }
		    /* Return true if date format is valid */
		    return true;
		}
	   }
	
	
	
	
	
	
	
	
	
	
	
}
