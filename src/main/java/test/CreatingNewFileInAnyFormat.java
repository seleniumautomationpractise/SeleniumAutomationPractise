package test;

import java.io.File;
import java.io.IOException;


public class CreatingNewFileInAnyFormat 
{
	public static void main(String[] args)
	{
		String projectDirectory = System.getProperty("user.dir");

		System.out.println("Project Directory : "+projectDirectory);

		String filelocation = projectDirectory+"\\ExecutionGeneratedFiles\\test.jpg";

		System.out.println("Word File Location : "+filelocation);

		File file = new File(filelocation);

        try 
        {
            if (!file.exists()) 
            {
                file.createNewFile();
                System.out.println("File is created");
            } 
            else 
            {
                System.out.println("File already exist");
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
	}
}