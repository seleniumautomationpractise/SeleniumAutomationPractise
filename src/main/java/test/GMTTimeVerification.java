package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GMTTimeVerification 
{
	public static void main(String[] args) throws ParseException 
	{
		test();
	}
	
	
	public static Date test() throws ParseException 
	{
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
		
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));

		//Local time zone   
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");

		//Time in GMT
		
		System.out.println(dateFormatLocal.parse( dateFormatGmt.format(new Date())));
		
		return dateFormatLocal.parse( dateFormatGmt.format(new Date()));
	}
}
