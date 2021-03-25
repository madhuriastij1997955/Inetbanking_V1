package com.ibanking.Utilitys;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	public static FileInputStream fi;
	public static  FileOutputStream fo;
	public static  XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static  XSSFRow row;
	public static XSSFCell cell;
	public static int getRowNum(String file, String sheetName) throws Exception
	{
		fi=new FileInputStream(file);
		 wb=new XSSFWorkbook(fi);
		 sh= wb.getSheet(sheetName);
		int rows=   sh.getPhysicalNumberOfRows();
		return rows;
		
	}
	
	public static int getCellNum(String file, String sheetName, int rownum) throws Exception {
		
		fi=new FileInputStream(file);
		 wb=new XSSFWorkbook(fi);
		 sh= wb.getSheet(sheetName);
		  row= sh.getRow(rownum);
		  int cells= row.getPhysicalNumberOfCells();
		  return cells;
		   
		
	}
	public static String getCellData(String file, String sheetName, int rownum, int cellnum) throws Exception {
		fi=new FileInputStream(file);
		 wb=new XSSFWorkbook(fi);
		 sh= wb.getSheet(sheetName);
		   row=  sh.getRow(rownum);
		 cell=  row.getCell(cellnum);
		  // cell=row.getCell(cellnum);
		   String data;
		   try {
		   DataFormatter formatter=new DataFormatter();
		 data=  formatter.formatCellValue(cell);
		 return data;
		   }
		   catch(Exception e) {
			   data="";
		   }
		   return data;
		
	}
	
	public static void setCellValue(String file, String sheetName, int rownum, int cellnum, String celldata) throws Exception {
		
		fo=new FileOutputStream(file);
		wb=new XSSFWorkbook();
		sh=wb.getSheet(sheetName);
		row=  sh.getRow(rownum);
		cell=row.createCell(cellnum);
		    cell.setCellValue(celldata);
		    wb.write(fo);
		    wb.close();
		    fo.close();
	}
	

}
