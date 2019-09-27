package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadingPDFFromFile 
{
	private static FileInputStream inputDocument;
	
	public static void main(String[] args) throws InterruptedException, IOException
	{
		String projectDirectory = System.getProperty("user.dir");

		String sourceFilePath = projectDirectory+"\\UploadingFiles\\SamplePDF.pdf";
		
		inputDocument = new FileInputStream(new File(sourceFilePath));
		
		PDDocument document = null;
		
		document = PDDocument.load(inputDocument);
		
		String pdfContent = new PDFTextStripper().getText(document);
		 		
		System.out.println(pdfContent);
	}
}