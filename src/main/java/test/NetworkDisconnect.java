package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NetworkDisconnect 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		String baseUrl = "https://www.google.com/";
		
		driver.get(baseUrl);
		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("notepad.exe");
		
		Runtime.getRuntime().exec("netsh interface set interface Wi-Fi disable");
		
		driver.navigate().refresh();
		
		if (driver.findElement(By.xpath("//div[contains(@id,'main-message')]//span[contains(text(),'No internet')]")).isDisplayed()) 
		{
			System.out.println("Network is disconnected");
		} 
		else 
		{
			System.err.println("Network is not Disconnected");
		}
		
		Runtime.getRuntime().exec("netsh interface set interface Wi-Fi enable");
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//input[contains(@name,'q')]")).isDisplayed()) 
		{
			System.out.println("Network is Connected");
		} 
		else 
		{
			System.err.println("Network is not Connected");
		}
	}
}
