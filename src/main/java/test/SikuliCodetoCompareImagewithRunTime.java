package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliCodetoCompareImagewithRunTime 
{
	public static void main(String[] args) throws FindFailed 
	{
		WebDriver driver;

		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		String baseUrl = "https://www.google.com/";
		
		driver.get(baseUrl);
		
		String projectDirectory = System.getProperty("user.dir");

		System.out.println("Project Directory : "+projectDirectory);

		String imageLocation = projectDirectory+"\\Images\\GooglePage.jpg";
		
		Screen screen = new Screen();
		
		Pattern pa1 = new Pattern(imageLocation);
				
		Finder f1=new Finder(screen.capture().getImage());
		
	    f1.find(pa1);
	    
	    if(f1.hasNext())
	    {
	        Match m=f1.next();
	    
	        System.out.println("Match found with "+(m.getScore() * 100) +"%");
	        
	        f1.destroy();
	    }
	    
	    else
	    {
	        System.out.println("No Match Found");
	    }
	    
	    screen.find(find(new Pattern(imageLocation).exact()));
	    
	    driver.quit();
	}

	private static Object find(Pattern exact) {
		// TODO Auto-generated method stub
		return null;
	}
}
