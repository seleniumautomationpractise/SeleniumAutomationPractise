package test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingPDFFromURL 
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		String baseUrl = "https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf";
		
		driver.get(baseUrl);
		
		String getURL = "https://www.betterteam.com/downloads/employee-information-form-download-20170810.pdf";
		
		URL url = new URL(getURL);
		
		InputStream is = url.openStream();
		
		BufferedInputStream fileParse = new BufferedInputStream(is);
		
		PDDocument document = null;
		
		document = PDDocument.load(fileParse);
		
		String pdfContent = new PDFTextStripper().getText(document);
		 		
		System.out.println(pdfContent);
		
		driver.quit();
	}
}