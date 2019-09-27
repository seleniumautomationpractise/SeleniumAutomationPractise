package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingSikuli 
{
    public static void main(String[] args) throws FindFailed 
    {
    	WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "http://demo.guru99.com/test/image_upload/index.php";

		driver.get(baseUrl);

		String projectDirectory = System.getProperty("user.dir");

		System.out.println("Project Directory : "+projectDirectory);

		String fileUploadTextboxImage = projectDirectory+"\\Images\\FileUploadTextbox.jpg";

		System.out.println("File Upload Textbox Image Location : "+fileUploadTextboxImage);
		
		String openButtonImage = projectDirectory+"\\Images\\OpenButton.jpg";

		System.out.println("Open Button Image Location : "+openButtonImage);
		
		String uploadingFilePath = projectDirectory+"\\UploadingFiles\\TestingDocument.doc";

		System.out.println("Uploading File Path : "+uploadingFilePath);

		Screen s = new Screen();
		
        Pattern fileInputTextBox = new Pattern(fileUploadTextboxImage);
        
        Pattern openButton = new Pattern(openButtonImage);
        
        driver.findElement(By.xpath(".//*[@id='photoimg']")).click();
        
        s.wait(fileInputTextBox, 20);
        
        s.type(fileInputTextBox, uploadingFilePath);
        
        s.click(openButton);
        
        //driver.close();
       
    	
        /*System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        String filepath = "D:\\Guru99Demo\\Files\\";
        String inputFilePath = "D:\\Guru99Demo\\Files\\";
        Screen s = new Screen();
        Pattern fileInputTextBox = new Pattern(filepath + "FileTextBox.PNG");
        Pattern openButton = new Pattern(filepath + "OpenButton.PNG");
        WebDriver driver;

        // Open Chrome browser    
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/image_upload/index.php");

        // Click on Browse button and handle windows pop up using Sikuli
        driver.findElement(By.xpath(".//*[@id='photoimg']")).click();
        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, inputFilePath + "Test.docx");
        s.click(openButton);

        // Close the browser
        driver.close();*/

    }

}