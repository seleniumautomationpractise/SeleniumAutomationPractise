package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ZoomInZoomOutUsingRobotClass 
{
	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "https://www.google.com/";

		driver.get(baseUrl);

		Thread.sleep(5000);

		
		Robot robot = new Robot();
		
		System.out.println("About to zoom in");
		
		for (int i = 0; i < 3; i++) 
		{ 
			robot.keyPress(KeyEvent.VK_CONTROL);
		
			robot.keyPress(KeyEvent.VK_ADD);
			
			robot.keyRelease(KeyEvent.VK_ADD);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		
		Thread.sleep(5000);
		
		System.out.println("About to zoom out");
		
		for (int i = 0; i < 4; i++) 
		{
			robot.keyPress(KeyEvent.VK_CONTROL);
		
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}

		driver.quit();
	}
}
