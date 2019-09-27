package test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ReadingDataFromJSONArray 
{
	String n;

	public String readJSONData(String keyword) throws IOException, ParseException
	{
		Reader reader = new FileReader("./Json/TestData.json");

		JSONParser parser = new JSONParser();

		JSONArray jsonArr = (JSONArray)parser.parse(reader);

		for(Object obj : jsonArr)
		{
			JSONObject jo = (JSONObject)obj; 
		
			n = (String)jo.get(keyword);
		}
		return n;
	}

	public static void main(String[] args) throws IOException, ParseException
	{
		ReadingDataFromJSONArray e = new ReadingDataFromJSONArray();
		
		String data1 = e.readJSONData("first name");
		
		String data2 = e.readJSONData("last name");
		
		String data3 = e.readJSONData("Blog URL");
		
		System.out.println("First Name : "+data1);
		
		System.out.println("Last Name : "+data2);
		
		System.out.println("Blog URL : "+data3);
	}

}