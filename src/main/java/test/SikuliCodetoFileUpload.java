package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliCodetoFileUpload 
{
	public static void main(String[] args) throws FindFailed 
	{
		String projectDirectory = System.getProperty("user.dir");

		System.out.println("Project Directory : "+projectDirectory);

		String uploadingFiles = projectDirectory+"\\UploadingFiles\\TestingDocument.doc";

		String fileUploadTextox = projectDirectory+"\\Images\\FileUploadTextbox.jpg";

		String openButton = projectDirectory+"\\Images\\OpenButton.jpg";

		Screen screen = new Screen();

		Pattern fileUploadTextoxPat = new Pattern(fileUploadTextox);

		Pattern openButtonPat = new Pattern(openButton);

		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "http://demo.guru99.com/test/image_upload/index.php";

		driver.get(baseUrl);

		driver.findElement(By.xpath(".//*[@id='photoimg']")).click();

		//screen.wait(fileUploadTextoxPat, 20);

		screen.type(fileUploadTextoxPat, uploadingFiles);

		screen.click(openButtonPat);

		driver.quit();
	}
}
