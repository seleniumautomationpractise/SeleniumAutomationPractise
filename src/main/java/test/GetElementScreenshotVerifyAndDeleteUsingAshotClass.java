package test;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class GetElementScreenshotVerifyAndDeleteUsingAshotClass 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		//String baseUrl = "https://www.google.com/";

		//driver.get(baseUrl);
		
		
		
		
		driver.get("https://www.menswearhouse.com/");
		
		Thread.sleep(5000);
		
		for (int i = 1; i <= 10; i++) 
		{
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		
		String projectDirectory = System.getProperty("user.dir");
		
		String screenshotlocation = projectDirectory+"\\Screenshot\\Test"+System.currentTimeMillis()+".jpg";
		
		WebElement logoImageElement = driver.findElement(By.xpath("//footer[@id='pg-footer']"));
		
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);
		
		ImageIO.write(logoImageScreenshot.getImage(),"png",new File(screenshotlocation));
		
		File f = new File(screenshotlocation);
		
		if(f.exists())
		{
			System.out.println("Image File Captured");
		}
		
		else
		{
			System.out.println("Image File NOT exist");
		}
		
	
		/*f.delete();
		
		
		if(f.exists())
		{
			System.out.println("Image File Captured");
		}
		
		else
		{
			System.out.println("Image File NOT exist");
		}*/
		
		driver.quit();
	}
}
