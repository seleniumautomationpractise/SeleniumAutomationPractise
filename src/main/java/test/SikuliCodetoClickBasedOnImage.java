package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliCodetoClickBasedOnImage 
{
	public static void main(String[] args) throws FindFailed 
	{
		String projectDirectory = System.getProperty("user.dir");

		System.out.println("Project Directory : "+projectDirectory);

		String imageLocation = projectDirectory+"\\Images\\GmailLogo.JPG";
		
		Screen screen = new Screen();
		
		Pattern image1 = new Pattern(imageLocation);
		
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "https://www.google.com/";

		driver.get(baseUrl);
		
		screen.wait(image1, 10);
		
		screen.click(image1);
		
		driver.quit();
	}
}
