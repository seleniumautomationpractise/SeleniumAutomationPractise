package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectOptioninContextMenu 
{
	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "https://www.google.com/";

		driver.get(baseUrl);

		/*WebElement ele = driver.findElement(By.xpath("//input[@name='q']"));

		Actions action= new Actions(driver).contextClick(ele);

		action.contextClick(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();

		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
*/

		WebElement ele = driver.findElement(By.xpath("//input[@name='q']"));
		Actions builderq = new Actions(driver);
		builderq.contextClick(ele);
		builderq.build().perform();
		Robot robot = new Robot();
		int REPEATS_OF_VK_DOWN_INPUT = 1;
		for (int i = 0; i < REPEATS_OF_VK_DOWN_INPUT; i++) 
		{
		    robot.keyPress(KeyEvent.VK_DOWN);
		    robot.keyRelease(KeyEvent.VK_DOWN);
		    Thread.sleep(500);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		driver.quit();
	}
}
