package test;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

//Note : Need to include "commons-io-2.6.jar" in Referenced Library 

public class CreatingNewWordFile 
{
	public static void main(String[] args) throws IOException 
	{
		String projectDirectory = System.getProperty("user.dir");

		System.out.println("Project Directory : "+projectDirectory);

		String filelocation = projectDirectory+"\\ExecutionGeneratedFiles\\test.doc";

		System.out.println("Word File Location : "+filelocation);

		XWPFDocument document = new XWPFDocument();
		
        XWPFParagraph paragraph = document.createParagraph();
        
        XWPFRun run = paragraph.createRun();
        
        run.setText("Sample Text to add a word file programatically");
        
        run.setFontSize(33);
        
        FileOutputStream out = new FileOutputStream(filelocation);
        
        document.write(out); 
        
        out.close();
        
        document.close();
	}
}