package com.crm.autodesk.generic_utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * it is developed by using Apache.poi libraries for fectching the data from excel sheet
 * @author Prathith paul
 *
 */
public class ExcelUtility {
	/**
	 * this use to fetch the data from excel sheet
	 * @param sheetname
	 * @param Rownum
	 * @param Cellnum
	 * @return
	 * @throws Throwable
	 */

	public String acessTheDatafromExcelSheet(String sheetname,int Rownum,int Cellnum) throws Throwable {
		FileInputStream fis=new FileInputStream(".//src//test//resources//TestScriptsData.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		//Sheet sheet=book.getSheet(sheetname);
		//Row row=sheet.getRow(Rownum);
		//Cell cell =row.getCell(Cellnum);
		DataFormatter format=new DataFormatter();
		return format.formatCellValue(book.getSheet(sheetname).getRow(Rownum).getCell(Cellnum));
	}
}

