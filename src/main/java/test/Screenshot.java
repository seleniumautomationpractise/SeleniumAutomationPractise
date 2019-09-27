package test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

//Note : Need to include "commons-io-2.6.jar" in Referenced Library 

public class Screenshot 
{

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "http://demo.guru99.com/test/yahoo.html";

		driver.get(baseUrl);

		String projectDirectory = System.getProperty("user.dir");

		System.out.println("Project Directory : "+projectDirectory);

		String screenshotlocation = projectDirectory+"\\Screenshot\\Test"+System.currentTimeMillis()+".jpg";

		System.out.println("Screenshot Location : "+screenshotlocation);

		/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File(screenshotlocation));*/
		
		takeScreenshot(driver, screenshotlocation);

		driver.quit();
	}

	public static void takeScreenshot(WebDriver driver,String screenshotFilepath) throws IOException 
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File(screenshotFilepath));
	}

}


