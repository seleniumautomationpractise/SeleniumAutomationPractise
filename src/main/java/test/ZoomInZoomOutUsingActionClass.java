package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

public class ZoomInZoomOutUsingActionClass 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "https://www.google.com/";

		driver.get(baseUrl);
		
		Thread.sleep(5000);

		WebElement element = driver.findElement(By.tagName("html"));
        
		Actions actions = new Actions(driver);
        
		actions.moveToElement(element);
        
		actions.click();
        
		actions.sendKeys(Keys.CONTROL, Keys.ADD);
        
		actions.sendKeys(Keys.CONTROL, Keys.ADD);
        
		actions.sendKeys(Keys.CONTROL, Keys.ADD);
        
		actions.sendKeys(Keys.CONTROL, Keys.ADD);
        
		actions.sendKeys(Keys.CONTROL, Keys.ADD);
        
		actions.sendKeys(Keys.CONTROL, Keys.ADD);
        
		actions.sendKeys(Keys.CONTROL, Keys.ADD);
        
		actions.sendKeys(Keys.CONTROL, Keys.ADD);
        
		actions.sendKeys(Keys.CONTROL, Keys.ADD);
        
		actions.build().perform();
		
		driver.quit();
	}
}
