package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelCopyTemplateandUpdateValues 
{
	public static void main(String[] args) throws IOException 
	{
		copyExcelTemplate();
		
		CreateNewRowandEnterValuesGuidedShopping("Vijay", 34, "Male");
		
		CreateNewRowandEnterValuesGuidedShopping("Karthiga", 21, "Male");
		
		CreateNewRowandEnterValuesGuidedShopping("Viji", 35, "Male");
	}
	
	
	private static FileInputStream inputDocument;
	private static FileOutputStream outputDocument;
	private static HSSFWorkbook workBook;
	
	public static void copyExcelTemplate() throws IOException
	{
		String projectDirectory = System.getProperty("user.dir");

		String sourceFilePath = projectDirectory+"\\ExcelTemplate\\TestExcelTemplate.xls";
		
		inputDocument = new FileInputStream(new File(sourceFilePath));
		
		workBook = new HSSFWorkbook(inputDocument);
		
		inputDocument.close();
		
		String automationGeneratedFilePath = projectDirectory+"\\AutomationGeneratedFiles\\TestExcelAutomationGenerated.xls";
		
		outputDocument = new FileOutputStream(new File(automationGeneratedFilePath));
		
		workBook.write(outputDocument);
		
		outputDocument.close();
	}
	
	
	public static void CreateNewRowandEnterValuesGuidedShopping(String Name, int Age, String Gender) throws IOException
	{
		String projectDirectory = System.getProperty("user.dir");

		String automationGeneratedFilePath = projectDirectory+"\\AutomationGeneratedFiles\\TestExcelAutomationGenerated.xls";
		
		FileInputStream fis = new FileInputStream(automationGeneratedFilePath);
		
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
        
		HSSFSheet sheet = workbook.getSheetAt(0);
        
		int LastRow = sheet.getLastRowNum();
        
		int NewRow = LastRow+1;
        
		System.out.println("Last Row : "+LastRow);
        
		System.out.println("New Row : "+NewRow);
        
		HSSFRow row = sheet.createRow(NewRow);
        
		row.createCell(1).setCellValue(Name);
        
		row.createCell(2).setCellValue(Age);
        
		row.createCell(3).setCellValue(Gender);
        
		File file = new File(automationGeneratedFilePath);
        
		workbook.write(file);
		
		workbook.close();
	}
}
