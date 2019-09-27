package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadsFolderinSystemWithShadowRoot 
{
	public static void main(String[] args) 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "chrome://downloads/";

		//String baseUrl = "chrome://bookmarks/";

		driver.get(baseUrl);

		WebElement root1 = driver.findElement(By.tagName("downloads-manager"));

		WebElement shadowRoot1 = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",root1);
		
		System.out.println("1");
		
		WebElement root2 = shadowRoot1.findElement(By.cssSelector("downloads-toolbar"));
		
		WebElement shadowRoot2 = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",root2);
		
		System.out.println("2");
		
		WebElement root3 = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
		
		WebElement shadowRoot3 = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",root3);
		
		System.out.println("3");
		
		String actualHeading = shadowRoot3.findElement(By.xpath("//h1[contains(text(),'Downloads')]")).getText();
		
		
		if (actualHeading.equalsIgnoreCase("Downloads")) 
		{
			System.out.println("Downloads Folder is Verified");
		} 
		else 
		{
			System.err.println("Downloads Folder is not Verified");
		}
	}
}
