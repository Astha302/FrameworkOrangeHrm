package com.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_utilities {

	Pojo objpojo;
	// String path = "./src/test/resources/EmpData.xlsx";

	public Excel_utilities(Pojo pojo) {
		this.objpojo = pojo;
	}

//	public static void main(String[] args) throws IOException {
//
//		// getLoginData("./src/test/resources/EmpData.xlsx", "EmpData", "TC_02");
//		writeDataInExcel("./src/test/resources/EmpData.xlsx", "StatusSheet", "TC_01", "PASS");
//
//	}

	static FileInputStream fis;
	static Workbook wb;
	static int datarow;

	public static Map<String, String> getLoginData(String path, String sheetname, String TestCaseId)
			throws IOException {
		Map<String, String> map = new Hashtable<>();

		try (FileInputStream fis = new FileInputStream(path); Workbook wb = new XSSFWorkbook(fis)) {
			Sheet sheet = wb.getSheet(sheetname);
			if (sheet == null) {

				System.out.println("sheet is null");
				return map;
			}

//			Row HeaderRow = sheet.getRow(0);
//			if (HeaderRow == null) {
//				System.out.println("HeaderRow is null");
//				return map;
//			}

			int rowcount = sheet.getLastRowNum();
			System.out.println("no. of rows in sheet :" + rowcount);

			int colcount = sheet.getRow(0).getLastCellNum();
			System.out.println("no. of coloumn in sheet :" + colcount);

			DataFormatter formatter = new DataFormatter();

//			if (sheet == null) {
//				System.out.println("sheet is null");
//				return map;
//			}
//			 
//			Row HeaderRow = sheet.getRow(0);
//			if (HeaderRow == null) {
//				System.out.println("HeaderRow is null");
//				return map;
//			}

			for (int rows = 1; rows <= sheet.getLastRowNum(); rows++) {
				System.out.println(rows);
				if (sheet.getRow(rows) == null) {
					throw new RuntimeException("Row is null");
				}

				if (TestCaseId.equals(formatter.formatCellValue(sheet.getRow(rows).getCell(0)))) {
					datarow = rows;
					System.out.println(datarow);
					break;
				}

			}

			for (int j = 0; j <= sheet.getRow(datarow - 1).getLastCellNum(); j++) {
				String key = formatter.formatCellValue(sheet.getRow(datarow - 1).getCell(j));
				System.out.println(key);
				if (key == null || key.isBlank() || key.isEmpty() || key == "") {

					continue;
				}
				String value = formatter.formatCellValue(sheet.getRow(datarow).getCell(j));
				System.out.println(value);

				if (value == null || value.isBlank() || value.isEmpty()) {
					continue;
				}

				map.put(key, value);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(map);
		return map;
	}

	public static void writeDataInExcel(String path, String sheetName, String testCaseId, String status) {
		try (FileInputStream fis = new FileInputStream(path); Workbook wb = new XSSFWorkbook(fis)) {

			     Sheet sheet = wb.getSheet(sheetName);
		 
			        if (sheet == null) {
			            sheet = wb.createSheet(sheetName);
			            Row header = sheet.createRow(0);
			            header.createCell(0).setCellValue("TestCaseId");
			            header.createCell(1).setCellValue("Status");
			        }
		 
			        int lastRow = sheet.getPhysicalNumberOfRows();
			        boolean updated = false;
		 
			        // Update existing row
			        for (int i = 0; i <= lastRow; i++) {
			            Row row = sheet.getRow(i);
			            if (row != null) {
			                String tcID = row.getCell(0).getStringCellValue();
			                if (tcID.equals(testCaseId)) {
			                    row.getCell(1).setCellValue(status);
			                    updated = true;
			                    break;
			                }
			            }
			        }
		 
			        // Insert new row if not found
			        if (!updated) {
			            Row newRow = sheet.createRow(lastRow );
			            newRow.createCell(0).setCellValue(testCaseId);
			            newRow.createCell(1).setCellValue(status);
			        }
		 
			        try (FileOutputStream fos = new FileOutputStream(path)) {
			            wb.write(fos);
			        }
		 
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			}
		}
	
				
//			}
//			else
//			{
//				if(Headerrow.getCell(0)==null) {Headerrow.getCell(0).setCellValue("TestCaseID");}
//				if(Headerrow.getCell(1)==null) { Headerrow.getCell(1).setCellValue("Status");
//			}
//
//			int NextRowNum = sheet.getLastRowNum()+1;
//			System.out.println(NextRowNum);
//            Row newRow = sheet.createRow(NextRowNum);
//            System.out.println(newRow);
//            
//            
//            Cell tccell = newRow.createCell(0);
//            tccell.setCellValue(testCaseId);
//            
//            Cell Stcell =newRow.createCell(1);
//            Stcell.setCellValue(status);
//            
            



//			if (NextRowNum == 0) {
//				Row newRow = sheet.createRow(NextRowNum + 1);
//				newRow.createCell(0).setCellValue(testCaseId);
//				newRow.createCell(1).setCellValue(status);
//			}
//
//			if (NextRowNum >= 1) {
//				for (int i = 1; i <= NextRowNum; i++) {
//					Row row = sheet.getRow(i);
//					if (row != null) {
//						String tcID = row.getCell(0).getStringCellValue();
//						System.out.println("The tecase id is" + tcID);
//						if (tcID.equalsIgnoreCase(testCaseId)) {
//							row.getCell(1).setCellValue(status);
//							break;
//						}
//					}
//
//				}
//
//			}
//
//			try (FileOutputStream fos = new FileOutputStream(path)) {
//				wb.write(fos);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}}
