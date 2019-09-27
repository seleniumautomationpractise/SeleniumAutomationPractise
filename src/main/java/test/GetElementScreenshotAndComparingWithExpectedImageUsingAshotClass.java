package test;

import java.awt.image.BufferedImage;
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
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class GetElementScreenshotAndComparingWithExpectedImageUsingAshotClass 
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

		String expectedImagePath = projectDirectory+"\\Images\\expected.png";

		BufferedImage expectedImage = ImageIO.read(new File(expectedImagePath));

		//String screenshotlocation = projectDirectory+"\\Screenshot\\Test"+System.currentTimeMillis()+".jpg";

		WebElement logoImageElement = driver.findElement(By.xpath("//footer[@id='pg-footer']"));
		
		
		Thread.sleep(4000);
		
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);
		
		BufferedImage actualImage = logoImageScreenshot.getImage();
		

		/*Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);

		BufferedImage actualImage = logoImageScreenshot.getImage();*/

		ImageDiffer imgDiff = new ImageDiffer();

		ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);

		if(diff.hasDiff()==true)
		{
			System.out.println("Images are Not Same");
		}
		else 
		{
			System.out.println("Images are Same");
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
