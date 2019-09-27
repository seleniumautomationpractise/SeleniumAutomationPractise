package test;

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ExcelGmailDataDrivenFramework 
{
	public static void main(String[] args) throws BiffException, IOException, InterruptedException 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "https://gmail.com";

		String projectDirectory = System.getProperty("user.dir");

		String filePath = projectDirectory+"\\ExcelFiles\\GmailDataDriven.xls";

		System.out.println("Filepath : "+filePath);

		FileInputStream fis = new FileInputStream(filePath);
		
		Workbook wb = Workbook.getWorkbook(fis);
		
		Sheet sh = wb.getSheet(0);
		
		int rowsCount=sh.getRows();
		
		System.out.println("Total No of rows : "+rowsCount);


		for(int row=1; row <sh.getRows();row++)
		{
			String username = sh.getCell(0, row).getContents();
			
			String password= sh.getCell(1, row).getContents();
			
			System.out.println("Username "+row+" : "+username);
			
			System.out.println("Password "+row+" : "+password);
			
			driver.get(baseUrl);
			
			Thread.sleep(3000);
			
			if (driver.findElement(By.xpath("//div[contains(@id,'initialView')]")).isDisplayed()) 
			{
				System.out.println("Gmail Login Page is displayed");
			} 
			else 
			{
				System.err.println("Gmail Login Page is not displayed");
			}
			
			driver.findElement(By.xpath("//div[contains(@id,'initialView')]//input[contains(@id,'identifierId')]")).sendKeys(username);
			
			driver.findElement(By.xpath("//div[contains(@id,'initialView')]//div[contains(@id,'identifierNext')]")).click();		
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//div[contains(@id,'initialView')]//input[contains(@name,'password')]")).sendKeys(password);
			
			driver.findElement(By.xpath("//div[contains(@id,'initialView')]//div[contains(@id,'passwordNext')]")).click();
			
			Thread.sleep(4000);
			
			if (driver.findElement(By.xpath("//div[contains(text(),'Primary')]")).isDisplayed()) 
			{
				System.out.println("Gmail Main Page is displayed. User "+username+" Logged in successfully");
			} 
			else 
			{
				System.err.println("Gmail Main Page is not displayed. User "+username+" is not Logged in successfully");
			}
			
			driver.findElement(By.xpath("//a[contains(@aria-label,'Google Account')]")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//a[contains(text(),'Sign out')]")).click();
			
			Thread.sleep(3000);
			
			try 
			{
				if (driver.findElement(By.xpath("//div[contains(@aria-label,'Switch account')]")).isDisplayed()) 
				{
					System.out.println("Account Name is already displayed");
					
					driver.findElement(By.xpath("//div[contains(@aria-label,'Switch account')]")).click();
					
					Thread.sleep(4000);
					
					driver.findElement(By.xpath("//div[contains(text(),'Remove an account')]")).click();
					
					Thread.sleep(3000);
					
					driver.findElement(By.xpath("//div[contains(@data-identifier,'gmail.com')]")).click();
					
					Thread.sleep(3000);
					
					driver.findElement(By.xpath("(//span[contains(text(),'Yes, remove')])[2]")).click();
					
				} 
				else 
				{
					System.out.println("Account Name is not already displayed");
				}
			} 
			catch (Exception e) 
			{
				System.out.println("Account Name is not already displayed");
			}
			
			Thread.sleep(3000);
			
			driver.get(baseUrl);
			
			if (driver.findElement(By.xpath("//div[contains(@id,'initialView')]")).isDisplayed()) 
			{
				System.out.println("Gmail Login Page is displayed. User "+username+" Logged out successfully");
			} 
			else 
			{
				System.err.println("Gmail Login Page is not displayed. User "+username+" is not Logged out successfully");
			}
		}		
	}
}
