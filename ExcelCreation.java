
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelCreation {

 Workbook xlswb;
 Sheet sh;
 Row row;
public static void main(String[] args) {
  ExcelCreation ec = new ExcelCreation();
  ec.createHssfExcel();
  ec.saveExcel();
 }

private void saveExcel() {
  String xlsPath = "ExlCreation.xls"; 
  try {
   FileOutputStream fos = new FileOutputStream(xlsPath);
   xlswb.write(fos);
   fos.close();  
  } catch (FileNotFoundException e) {   
   e.printStackTrace();
  } catch (IOException e) {   
   e.printStackTrace();
  }  
 }


  private void createHssfExcel() {
  xlswb = new HSSFWorkbook();
  sh = xlswb.createSheet();
  row = sh.createRow(0);
  row.createCell(0).setCellValue("Serial No.");
  row.createCell(1).setCellValue("First Name");
  row.createCell(2).setCellValue("Last Name");
  row.createCell(3).setCellValue("Age");
  row.createCell(4).setCellValue("Salary");
  }


}