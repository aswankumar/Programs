package iText;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
 
public class MyFirstPdf
{
   public static void main(String[] args)
   {
      Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("MyFirstPdf.pdf"));
         document.open();
         document.add(new Paragraph("Content of this pdf file\n"));
         document.add(new Paragraph("This is the second line of this pdf file\n Created by Aswanikumar"));
         document.addTitle("My First Pdf");
         document.add(new Paragraph(new Date().toString()));
         document.addCreationDate();
         document.addAuthor("Aswanikumar");
    	 document.addCreationDate();
         document.close();
         writer.close();
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
   }
}






