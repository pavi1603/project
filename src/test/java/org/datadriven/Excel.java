package org.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static void main(String[] args) throws IOException {

		//Print the all Excel values in Console
			File f=new File("C:\\Users\\Lenovo\\eclipse-workspace\\GreensFrameProj\\DataExcel\\Book1.xlsx");

			FileInputStream fin =new FileInputStream(f);

			Workbook w=new XSSFWorkbook(fin);

			Sheet s=w.getSheet("Sheet1");	

			System.out.println("Print all input values in Excel Sheet :");
			for(int i=0; i<s.getPhysicalNumberOfRows(); i++) {
				Row row = s.getRow(i);

				for(int j=0; j<row.getPhysicalNumberOfCells(); j++) {
					Cell cell = row.getCell(j);
					int cellType= cell.getCellType();

					if(cellType==1) {
						String value = cell.getStringCellValue();
						System.out.println(value);
					}
					else if (DateUtil.isCellDateFormatted(cell)) {
						Date d=cell.getDateCellValue();

						SimpleDateFormat date=new SimpleDateFormat("dd,MMMM,yyyy");
						String value = date.format(d);
						System.out.println(value);
					}

					else {
						double d=cell.getNumericCellValue();
						long l=(long)d;
						String value = String.valueOf(l);
						System.out.println(value);
					}
				}
			}
		//Find the Number of Rows and Columns
			System.out.println("No.of Rows :"+s.getPhysicalNumberOfRows());
			Row r= s.getRow(0);
			System.out.println("No.of Cells :"+r.getPhysicalNumberOfCells());

		//Update or OverWrite or Replace
			File file=new File("C:\\Users\\sridh\\eclipse-workspace\\FrameProject\\DataExcel\\Book1.xlsx");

			FileInputStream fi =new FileInputStream(file);

			//type of workbook
			Workbook w1=new XSSFWorkbook(fi);

			//Get the Sheet
			Sheet s1=w1.getSheet("Sheet1");

			//get the row
			for (int i=0; i<s1.getPhysicalNumberOfRows(); i++) {
				Row row = s1.getRow(i);

				for (int j=0; j<row.getPhysicalNumberOfCells(); j++) {
					Cell cell=row.getCell(j);

					int cellType = cell.getCellType();
					if (cellType==1) {
						String value=cell.getStringCellValue();	
						if (value.equals("siva")) {
							cell.setCellValue("Sri");

							FileOutputStream fout=new FileOutputStream(f);
							w.write(fout);
							System.out.println("Success");
						}
					}
				}
			}


		//New File Creation
			File fileCreation = new File("C:\\Users\\Lenovo\\eclipse-workspace\\GreensFrameProj\\DataExcel\\Book1.xlsx");

			boolean a = fileCreation.createNewFile();
			System.out.println(a);

			Workbook wb = new XSSFWorkbook();

			Sheet sheet = wb.createSheet("Jerry");

			Row row = sheet.createRow(0);

			Cell cell = row.createCell(1);

			cell.setCellValue("Tom");

			FileOutputStream fout = new FileOutputStream(f);

			w.write(fout);
			System.out.println("success");
		}
}
