package test;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;

public class SikuliCodetoCompare2LocalImages 
{
	public static void main(String[] args) throws FindFailed 
	{
		String projectDirectory = System.getProperty("user.dir");

		System.out.println("Project Directory : "+projectDirectory);

		String imageLocation = projectDirectory+"\\Images\\Google.png";
		
		String imageLocation2 = projectDirectory+"\\Images\\Google.png";
		
		Pattern image1 = new Pattern(imageLocation);
		
		Pattern image2 = new Pattern(imageLocation2);
		
		Finder f = new Finder(image1.getImage());
		
		f.find(image2);
		
		if (f.hasNext()) 
		{
			Match m = f.next();
			
			System.out.println("Match Found with "+(m.getScore())*100+"%");
			
			f.destroy();
		} 
		else 
		{
			System.out.println("No Match Found");
		}
	}
}
