package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.io.File;
import java.net.URL;

public class BrowserstackFileDownload {

	public static final String USERNAME = "mohanapriya16";
	public static final String AUTOMATE_KEY = "NdRkqxscJqwEMm7LfvFo";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "62.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1366x768");
		caps.setCapability("name", "Download CSV Test");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

		driver.get("https://scipher.vx-qa.utopusinsights.io/auth/login");

		driver.findElement(By.id("username")).sendKeys("crm.powerica@utopusinsights.com");

		driver.findElement(By.id("password")).sendKeys("pass4crm");

		driver.findElement(By.id("_submit")).click();

		Thread.sleep(7000);

		driver.findElement(By.xpath("//a[contains(@href,'http://scipher.vx-qa.utopusinsights.io')]//span")).click();

		driver.findElement(By.xpath("//nav-bar[contains(@class,'site-header')]//span[contains(text(),'Go to asset')]")).click();

		Thread.sleep(50000);

		driver.findElement(By.xpath("//ul[contains(@id,'windFarms')]//li[1]//div")).click();

		Thread.sleep(50000);

		driver.findElement(By.xpath("//ul[contains(@id,'windTurbines')]//li[1]//a")).click();

		Thread.sleep(50000);

		WebElement ele = driver.findElement(By.xpath("//button[contains(@id,'components_dropdown')]"));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele);

		driver.findElement(By.xpath("//button[contains(@id,'components_dropdown')]")).click();

		driver.findElement(By.xpath("//ul[contains(@class,'nested-checkbox-list')]//li//span[contains(text(),'KPI')]")).click();

		driver.findElement(By.xpath("//button[contains(@id,'components_dropdown')]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Apply filter')]")).click();

		Thread.sleep(3000);

		WebElement ele2 = driver.findElement(By.xpath("//button[contains(@aria-label,'Export filtered data')]//i"));

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele2);

		WebElement webElement = driver.findElement(By.xpath("//button[contains(@aria-label,'Export filtered data')]//i"));

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", webElement);

		//driver.findElement(By.xpath("//button[contains(@aria-label,'Export filtered data')]//i")).click();
		
		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		//System.out.println(jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"<file_name>\"}}"));
		
		System.out.println(jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"historical-analysis-chart-data.csv\"}}"));
		
		System.out.println(jse.executeScript("browserstack_executor: {\"action\": \"getFileProperties\", \"arguments\": {\"fileName\": \"historical-analysis-chart-data.csv\"}}"));
		
		//System.out.println(jse.executeScript("browserstack_executor: {\"action\": \"getFileContent\", \"arguments\": {\"fileName\": \"historical-analysis-chart-data.csv\"}}"));
		
		//generateAndValidateFileAvailable(30,"historical-analysis-chart-data.csv");
		
		String base64EncodedFile = (String)jse.executeScript("browserstack_executor: {\"action\": \"getFileContent\", \"arguments\": {\"fileName\": \"historical-analysis-chart-data.csv\"}}");
		
		byte[] data = Base64.getDecoder().decode(base64EncodedFile);
		
	    OutputStream stream = new FileOutputStream("historical-analysis-chart-data.csv");
	    
	    stream.write(data);
	    
	    stream.toString();
	    
	    System.out.println(driver.getTitle());
	    
	    stream.close();
		

	}


	public static void generateAndValidateFileAvailable(int timeOut,String reportName) throws InterruptedException 
	{
		String pathToDownload = "C:\\Users\\hello\\Downloads";

		String fileName = "";

		fileName = reportName;
		for(int i=0;i<timeOut;i++) 
		{
			File directory = new File(pathToDownload);
			File[] files = directory.listFiles();
			/*if(files.length == 0) 
			{
				Thread.sleep(3000);
				continue;
			}*/
			/*else 
			{*/
				if (files[0].exists() && files[0].getName().contains(fileName))
				{
					System.out.println("Successfully clicked on the Generate Export Button: "+files[0].getName()+" is downloaded");
					break;					
				}
				else 
				{
					System.out.println("File Not Downloaded");
					Thread.sleep(3000);
					continue;
				}
			//}
		}
	}
}
