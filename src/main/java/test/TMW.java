package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.List;

public class TMW 
{

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "https://www.menswearhouse.com/";

		driver.get(baseUrl);
		
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("(//footer[contains(@id,'pg-footer')]//li//span[contains(text(),'Ship To')])[1]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		
		driver.findElement(By.xpath("(//footer[contains(@id,'pg-footer')]//li//span[contains(text(),'Ship To')])[1]")).click();

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Proceed as U.S. Customer')]")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//ul[contains(@id,'topnav-menu')]//li//a[contains(text(),'Shirts')])[1]")).click();
		
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//section[contains(@id,'results-products')]")).isDisplayed()) 
		{
			System.out.println("Products is displayed with PGP Page");
		}
		else 
		{
			System.err.println("Products is not displayed with PGP Page");	
		}
		
		List<WebElement> productsListinPGP = driver.findElements(By.xpath("//a[contains(@class,'js-editable-link product-name')]"));
		
		int productsListinPGPCount = productsListinPGP.size();
		
		System.out.println("**********************************************************************************************");
		
		System.out.println("Products List Count in PGP Directly : "+productsListinPGPCount);
		
		System.out.println("**********************************************************************************************");
		
		for (int i = 1; i <= productsListinPGPCount; i++) 
		{
			String productName = driver.findElement(By.xpath("(//a[contains(@class,'js-editable-link product-name')])["+i+"]")).getText();
		
			String productNameLowercase = productName.toLowerCase();
			
			String productNameLowercaseSpaceReplaced = productNameLowercase.replaceAll(" ", "-");
			
			String productNameLowercaseCommaReplaced = productNameLowercaseSpaceReplaced.replaceAll(",", "-");
			
			String NewPDPURL = baseUrl+"p/"+productNameLowercaseCommaReplaced;
			
			System.out.println("Product : "+i);
			System.out.println("Product Name : "+productName);
			System.out.println("Generated PDP Page URL : "+NewPDPURL);
			System.out.println("");
		}
		
		
		WebElement element2 = driver.findElement(By.xpath("(//a[contains(@class,'js-editable-link product-name')])["+productsListinPGPCount+"]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element2);
		
		
		driver.findElement(By.xpath("(//button//span[contains(text(),'Load more')])[1]")).click();
		
		
		System.out.println("*********************************************");
		System.out.println("Products Count After First Load More");
		System.out.println("*********************************************");
		
		
		Thread.sleep(6000);
		
		
		List<WebElement> productsListinPGP2 = driver.findElements(By.xpath("//a[contains(@class,'js-editable-link product-name')]"));
		
		int productsListinPGPCount2 = productsListinPGP2.size();
		
		System.out.println("**********************************************************************************************");
		
		System.out.println("Products List Count in PGP After First Load More : "+productsListinPGPCount2);
		
		System.out.println("**********************************************************************************************");
		
		for (int i = 1; i <= productsListinPGPCount2; i++) 
		{
			String productName = driver.findElement(By.xpath("(//a[contains(@class,'js-editable-link product-name')])["+i+"]")).getText();
		
			String productNameLowercase = productName.toLowerCase();
			
			String productNameLowercaseSpaceReplaced = productNameLowercase.replaceAll(" ", "-");
			
			String productNameLowercaseCommaReplaced = productNameLowercaseSpaceReplaced.replaceAll(",", "-");
			
			String NewPDPURL = baseUrl+"p/"+productNameLowercaseCommaReplaced;
			
			System.out.println("Product : "+i);
			System.out.println("Product Name : "+productName);
			System.out.println("Generated PDP Page URL : "+NewPDPURL);
			System.out.println("");
		}

		
		WebElement element3 = driver.findElement(By.xpath("(//a[contains(@class,'js-editable-link product-name')])["+productsListinPGPCount2+"]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element3);
		
		
		driver.findElement(By.xpath("(//button//span[contains(text(),'Load more')])[1]")).click();
		
		
		System.out.println("*********************************************");
		System.out.println("Products Count After Second Load More");
		System.out.println("*********************************************");

		
		
		Thread.sleep(6000);
		
		
		List<WebElement> productsListinPGP3 = driver.findElements(By.xpath("//a[contains(@class,'js-editable-link product-name')]"));
		
		int productsListinPGPCount3 = productsListinPGP3.size();
		
		System.out.println("**********************************************************************************************");
		
		System.out.println("Products List Count in PGP After Second Load More : "+productsListinPGPCount3);
		
		System.out.println("**********************************************************************************************");
		
		for (int i = 1; i <= productsListinPGPCount3; i++) 
		{
			String productName = driver.findElement(By.xpath("(//a[contains(@class,'js-editable-link product-name')])["+i+"]")).getText();
		
			String productNameLowercase = productName.toLowerCase();
			
			String productNameLowercaseSpaceReplaced = productNameLowercase.replaceAll(" ", "-");
			
			String productNameLowercaseCommaReplaced = productNameLowercaseSpaceReplaced.replaceAll(",", "-");
			
			String NewPDPURL = baseUrl+"p/"+productNameLowercaseCommaReplaced;
			
			System.out.println("Product : "+i);
			System.out.println("Product Name : "+productName);
			System.out.println("Generated PDP Page URL : "+NewPDPURL);
			System.out.println("");
		}

		driver.quit();
	}
	
	
}


