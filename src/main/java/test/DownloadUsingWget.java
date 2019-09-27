package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadUsingWget 
{

	public static void main(String[] args) 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "http://demo.guru99.com/test/yahoo.html";

		driver.get(baseUrl);

		String projectDirectory = System.getProperty("user.dir");

		System.out.println("projectDirectory : "+projectDirectory);

		String wgetlocation = projectDirectory+"\\wget\\wget.exe";

		System.out.println("wgetlocation : "+wgetlocation);

		String downloadedFilelocation = projectDirectory+"\\DownloadedFile\\";

		System.out.println("downloadedFilelocation : "+downloadedFilelocation);

		WebElement downloadButton = driver.findElement(By.id("messenger-download"));

		String sourceLocation = downloadButton.getAttribute("href");

		String wget_command = "cmd /c "+wgetlocation+" -P "+downloadedFilelocation+" --no-check-certificate " + sourceLocation;

		try 
		{
			Process exec = Runtime.getRuntime().exec(wget_command);

			int exitVal = exec.waitFor();

			System.out.println("Exit value: " + exitVal);
		} 
		catch (Exception e) 
		{
			//System.out.println(ex.toString());
		}

		driver.quit();
	}

}
