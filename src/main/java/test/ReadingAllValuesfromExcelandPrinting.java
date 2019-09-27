package test;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadingAllValuesfromExcelandPrinting 
{
	public static void main(String[] args) throws BiffException, IOException 
	{
		String projectDirectory = System.getProperty("user.dir");

		String filePath = projectDirectory+"\\ExcelFiles\\GmailDataDriven.xls";

		System.out.println("Filepath : "+filePath);

		FileInputStream fs = new FileInputStream(filePath);

		Workbook wb = Workbook.getWorkbook(fs);

		Sheet sh = wb.getSheet(0);

		int rowsCount = sh.getRows();

		int colsCount = sh.getColumns();

		int row;

		int col;

		for (row = 1; row < rowsCount; row++) 
		{
			for (col = 0; col < colsCount; col++) 
			{
				System.out.println(sh.getCell(col, row).getContents());			
			}
		}
	}
}
