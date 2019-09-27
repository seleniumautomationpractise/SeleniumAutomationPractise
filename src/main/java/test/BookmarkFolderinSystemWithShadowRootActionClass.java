package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BookmarkFolderinSystemWithShadowRootActionClass 
{
	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		Robot rb = new Robot();

		String baseUrl = "https://www.google.com/";

		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Vijay");

		driver.findElement(By.xpath("//img[@alt='Google']")).click();

		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
			
		
		Thread.sleep(3000);
		
		
		//Robot rb = new Robot();

		rb.keyPress(KeyEvent.VK_CONTROL);

		rb.keyPress(KeyEvent.VK_D);

		rb.keyRelease(KeyEvent.VK_CONTROL);

		rb.keyRelease(KeyEvent.VK_D);

		Thread.sleep(3000);

		rb.keyPress(KeyEvent.VK_ENTER);



		rb.keyPress(KeyEvent.VK_CONTROL);

		rb.keyPress(KeyEvent.VK_T);

		rb.keyRelease(KeyEvent.VK_CONTROL);

		rb.keyRelease(KeyEvent.VK_T);


		rb.keyPress(KeyEvent.VK_CONTROL);

		rb.keyPress(KeyEvent.VK_SHIFT);

		rb.keyPress(KeyEvent.VK_O);

		rb.keyRelease(KeyEvent.VK_CONTROL);

		rb.keyRelease(KeyEvent.VK_SHIFT);

		rb.keyRelease(KeyEvent.VK_O);


		
		String baseUrl2 = "chrome://bookmarks/";

		driver.get(baseUrl2);
		

		//Thread.sleep(1000);


		WebElement root1 = driver.findElement(By.cssSelector("bookmarks-app"));
		WebElement shadowRoot1 =(WebElement)((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", root1);

		WebElement root2 = shadowRoot1.findElement(By.cssSelector("bookmarks-list"));
		WebElement shadowRoot2 = (WebElement)((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", root2);

		
		WebElement root3 = shadowRoot2.findElement(By.cssSelector("bookmarks-item"));
		WebElement shadowRoot3 = (WebElement)((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", root3);

		
		WebElement clickItem = shadowRoot3.findElement(By.cssSelector("div[id='website-title']"));


		Actions action = new Actions(driver);
		
		action.doubleClick(clickItem).perform();
		
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(1));
		
		String Pagetitle = driver.getTitle();
		
		System.out.println("Pagetitle : "+Pagetitle);
		
		if (driver.findElement(By.xpath("//*[contains(text(),'Top stories')]")).isDisplayed()) 
		{
			System.out.println("Bookmarked page is opened");
		} 
		else 
		{
			System.err.println("Bookmarked page is not opened");
		}
				
		driver.quit();
	}
}
