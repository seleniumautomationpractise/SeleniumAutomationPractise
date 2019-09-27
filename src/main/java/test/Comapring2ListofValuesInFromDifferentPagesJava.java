package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Comapring2ListofValuesInFromDifferentPagesJava 
{

	public static void main(String[] args) throws InterruptedException 
	{
		String department = "Shirts";
		
		String subCategory = "Classic Fit";
		
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "https://www.menswearhouse.com/";

		driver.get(baseUrl);
		
		Thread.sleep(3000);
		
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		driver.findElement(By.xpath("(//footer[contains(@id,'pg-footer')]//li//span[contains(text(),'Ship To')])[1]")).click();

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Proceed as U.S. Customer')]")).click();
		
		Thread.sleep(3000);
		
		//mouseHover("(//a[contains(@id,'TopCategoryLink') and contains(text(),'Shirts')])[1]");
		
		
		Actions actions = new Actions(driver);
		WebElement menuOption = driver.findElement(By.xpath("(//a[contains(@id,'TopCategoryLink') and contains(text(),'"+department+"')])[1]"));
		actions.moveToElement(menuOption).perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//li[contains(@id,'top-menu')]//a[contains(text(),'"+department+"')]/following-sibling::div//ul//ul//li//a[contains(text(),'"+subCategory+"')])[1]")).click();
		
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//section[contains(@id,'results-products')]")).isDisplayed()) 
		{
			System.out.println("Products is displayed with PGP Page");
		}
		else 
		{
			System.err.println("Products is not displayed with PGP Page");	
		}

		
		
		List<String> expectedResult = new ArrayList<String>();
		
		List<WebElement> colorSwatchesinPGP = driver.findElements(By.xpath("//section[contains(@id,'results-products')]//ul[contains(@id,'products')]//li[1]//div[contains(@class,'color-swatch')]//a"));
		
		int colorSwatchesCountinPGP = colorSwatchesinPGP.size();
		
		System.out.println("Color Swatches Count of First Product of PGP :"+colorSwatchesCountinPGP);

		for (int i = 1; i <= colorSwatchesCountinPGP; i++) 
		{
			String a = driver.findElement(By.xpath("(//section[contains(@id,'results-products')]//ul[contains(@id,'products')]//li[1]//div[contains(@class,'color-swatch')]//a)["+i+"]")).getAttribute("title");
			
			expectedResult.add(a);
		}
		
		System.out.println("Expected List : "+expectedResult);
		
		
		
		
		
		
		
		
		/*List<WebElement> colorSwatchesinPGP = driver.findElements(By.xpath("//section[contains(@id,'results-products')]//ul[contains(@id,'products')]//li[1]//div[contains(@class,'color-swatch')]//a"));
		
		int colorSwatchesCountinPGP = colorSwatchesinPGP.size();
		
		System.out.println("Color Swatches Count of First Product of PGP :"+colorSwatchesCountinPGP);
		
		List<String> colorSwatchesNamesinPGP = new ArrayList<>();
		
		for (int i = 1; i <= colorSwatchesCountinPGP; i++) 
		{
			String a = driver.findElement(By.xpath("(//section[contains(@id,'results-products')]//ul[contains(@id,'products')]//li[1]//div[contains(@class,'color-swatch')]//a)["+i+"]")).getAttribute("title");
			
			colorSwatchesNamesinPGP.add(a);
		}
        
		String a1 = colorSwatchesNamesinPGP.toString().trim(); 
	
		System.out.println("Colors in PGP : "+a1);*/
		
		
		Actions actions2 = new Actions(driver);
		WebElement menuOption2 = driver.findElement(By.xpath("//section[contains(@id,'results-products')]//ul[contains(@id,'products')]//li[1]//img[contains(@class,'image')]"));
		actions2.moveToElement(menuOption2).perform();
		
		
		driver.findElement(By.xpath("//section[contains(@id,'results-products')]//ul[contains(@id,'products')]//li[1]//a[contains(@id,'MiniGridQuickView')]")).click();
		
		
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//div[contains(@class,'widget_quick_info_popup quick-view')]")).isDisplayed()) 
		{
			System.out.println("QV is displayed");
		}
		else 
		{
			System.err.println("QV is not displayed");	
		}
		
		
		
		
		
		List<String> actualResult = new ArrayList<String>();
		
		List<WebElement> colorSwatchesinQV = driver.findElements(By.xpath("//section[contains(@id,'results-products')]//ul[contains(@id,'products')]//li[1]//div[contains(@class,'color-swatch')]//a"));
		
		int colorSwatchesCountinQV = colorSwatchesinQV.size();
		
		System.out.println("Color Swatches Count of First Product of PGP :"+colorSwatchesCountinQV);

		for (int i = 1; i <= colorSwatchesCountinQV; i++) 
		{
			String a = driver.findElement(By.xpath("(//section[contains(@id,'results-products')]//ul[contains(@id,'products')]//li[1]//div[contains(@class,'color-swatch')]//a)["+i+"]")).getAttribute("title");
			
			actualResult.add(a);
		}
		
		System.out.println("Actual List : "+actualResult);
		
		
		
		if (actualResult.containsAll(expectedResult)) 
		{
			System.out.println("Matched");
		} 
		else 
		{
			System.err.println("Not Matched");
		}
		
		
		
		
		
	/*	for (String expected: expectedResult) {
			  if (actualResult.contains(expected)) {
			    System.out.println("Search function verified");
			  } else {
			    System.out.println("Search function verification failed" + expectedResult.get(i));
			    }
			  }*/
		
		
		
		
		
		/*List<WebElement> colorSwatchesinQV = driver.findElements(By.xpath("//div[contains(@class,'widget_quick_info_popup quick-view')]//div[contains(@class,'color-swatch')]//a[contains(@class,'swatch')]"));
		
		int colorSwatchesCountinQV = colorSwatchesinQV.size();
		
		System.out.println("Color Swatches Count of First Product of QV :"+colorSwatchesCountinQV);
		
		List<String> colorSwatchesNamesinQV = new ArrayList<>();
		
		for (int i = 1; i <= colorSwatchesCountinQV; i++) 
		{
			String a = driver.findElement(By.xpath("(//div[contains(@class,'widget_quick_info_popup quick-view')]//div[contains(@class,'color-swatch')]//a[contains(@class,'swatch')])["+i+"]")).getAttribute("data-color-name");
			
			colorSwatchesNamesinQV.add(a);
		}
        
	
		String a2 = colorSwatchesNamesinQV.toString().trim(); 
		
		System.out.println("Colors in QV : "+a2);

		
		if (a1.contains(a2)) 
		{
			System.out.println("Matched");
		} 
		else 
		{
			System.err.println("Not Matched");
		}
*/				
		driver.quit();
	}
}


