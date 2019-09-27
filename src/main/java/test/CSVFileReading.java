package test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import au.com.bytecode.opencsv.CSVReader;

public class CSVFileReading 
{
	public static void main(String[] args) throws IOException 
	{
		
		String projectDirectory = System.getProperty("user.dir");

		String filePath = projectDirectory+"\\ExcelFiles\\historical-analysis-chart-data.csv";

		System.out.println("Filepath : "+filePath);
		
		// This will load csv file 
		CSVReader reader = new CSVReader(new FileReader(filePath));

		// this will load content into list
		List<String[]> li=reader.readAll();
		System.out.println("Total rows which we have is "+li.size());

		// create Iterator reference
		Iterator<String[]>i1= li.iterator();

		// Iterate all values 
		while(i1.hasNext())
		{
			String[] str=i1.next();

			System.out.print(" Values are ");

			for(int i=0;i<str.length;i++)
			{
				System.out.print(" "+str[i]+" || ");
			}
			System.out.println("");
		}
		
		reader.close();
	}
}