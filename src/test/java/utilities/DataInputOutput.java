package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class DataInputOutput {
	public static File src;
	public static String exfilepath = "F:\\Project\\Hackathon_Coursera\\src\\test\\java\\Data_Result\\Data.xlsx";
	public static FileInputStream fileip;
	public static FileInputStream f;
	public static FileOutputStream fileop;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFSheet sheet1;
	public static XSSFCell cell;
	public static XSSFCell cell1;
	public static XSSFCell cell2;
	public static XSSFRow Row;
	public static XSSFRow Row1;
	public static XSSFRow Row2;
	public static String[][] c=new String[2][6];
	public static int i=0,j=0;
	

	public static String[][] readexcel() throws Exception {
		try
			{
			fileip = new FileInputStream(exfilepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fileip);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row1 = sheet.getRow(2);
			Row row2 = sheet.getRow(3);
			for(int i=0;i<6;i++) {
				c[0][i] = row1.getCell(i).toString();
			}
			for(int i=0;i<6;i++) {
				c[1][i] = row2.getCell(i).toString();
			}
			workbook.close();
			}
			catch (FileNotFoundException e){
				e.printStackTrace();
			}catch (IOException e){
				e.printStackTrace();}
		return c;
	}
	
	public static void writeexcel(XSSFWorkbook workbook2) throws Exception{
		try
			{
			fileop=new FileOutputStream(exfilepath);
			workbook2.write(fileop);
			workbook2.close();
			fileop.close();
			}
			catch (FileNotFoundException e)
					{e.printStackTrace();
				} catch (IOException e){
					e.printStackTrace();}
		}
	
		public static void writetoexceltestCase1(String[] pt,String[] r,String[] h) throws Exception{
			f=new FileInputStream(DataInputOutput.exfilepath);
			workbook=new XSSFWorkbook(f);
			sheet=workbook.getSheetAt(1);
			Row row=sheet.createRow(0);
			Cell cell=row.createCell(0);
			cell.setCellValue("COURSE_NAME");
			Cell cell1=row.createCell(1);
			cell1.setCellValue("RATING");
			Cell cell4=row.createCell(2);
			cell4.setCellValue("No of Hours:");
			for(int i=1;i<=2;i++) {
				Row row1=sheet.createRow(i);
				Cell cell2=row1.createCell(0);
				cell2.setCellValue(pt[i-1]);
				Cell cell3=row1.createCell(1);
				cell3.setCellValue(r[i-1]);
				Cell cell5=row1.createCell(2);
				cell5.setCellValue(h[i-1]);
			}
			DataInputOutput.writeexcel(workbook);
			System.out.println("Written_in_excel_file");
	}
		
		public static void writetoexceltestcase2(String error_msg) throws Exception{
			f=new FileInputStream(DataInputOutput.exfilepath);
			workbook=new XSSFWorkbook(f);
			sheet=workbook.getSheetAt(3);
			Row row=sheet.createRow(0);
			Cell cell=row.createCell(0);
			cell.setCellValue("Error_Message:->");
			Cell cell2=row.createCell(1);
			cell2.setCellValue(error_msg);
			DataInputOutput.writeexcel(workbook);
			System.out.println("Written_in_excel_file");
		}
		
		public static void writetoexceltestcase3(String[] k,String[] r) throws Exception{
			f=new FileInputStream(DataInputOutput.exfilepath);
			workbook=new XSSFWorkbook(f);
			sheet=workbook.getSheetAt(2);
			Row row=sheet.createRow(0);
			Cell cell=row.createCell(0);
			cell.setCellValue("LANGUAGES:");
			for(i=0;i<37;i++) {
				sheet.createRow(i+1).createCell(0).setCellValue(k[i]);}
			Cell cell1=row.createCell(1);
			cell1.setCellValue("LEVEL:");
			for(i=0;j<4;j++){
				sheet.createRow(j+1).createCell(1).setCellValue(r[j]);}
			DataInputOutput.writeexcel(workbook);
			System.out.println("Written_in_excel_file");
		}

}
