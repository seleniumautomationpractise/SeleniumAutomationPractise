package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

public class ZoomInZoomOutUsingSendKeys 
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

		for(int i=0; i<3; i++)
		{ 
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ADD));
		}

		
		Thread.sleep(3000);
		
		// To zoom out 3 times
		for(int i=0; i<3; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
		}

		Thread.sleep(3000);
		
		//To set the browser to default zoom level ie., 100%
		driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		
		Thread.sleep(3000);
		
		driver.quit();
	}
}
