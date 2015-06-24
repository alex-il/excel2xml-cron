package com.verint.api.excel.converter;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BLANK;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_ERROR;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.verint.api.excel.converter.pojo.ExcelWorkbook;
import com.verint.api.excel.converter.pojo.ExcelWorksheet;

public class ExcelReader {

	public ExcelWorkbook convert(String sourceFile) throws InvalidFormatException, IOException {
		ExcelWorkbook book = new ExcelWorkbook();

		InputStream inp = new FileInputStream(sourceFile);
		Workbook wb = WorkbookFactory.create(inp);

		book.setFileName(sourceFile);

		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			Sheet sheet = wb.getSheetAt(i);
			if (sheet == null) {
				continue;
			}
			ExcelWorksheet tmp = new ExcelWorksheet();
			String sheetName = sheet.getSheetName();
			tmp.setName(sheetName);
			final int firstRowNum = sheet.getFirstRowNum();
			final int lastRowNum = sheet.getLastRowNum();
			for (int j = firstRowNum; j <= lastRowNum; j++) {
				Row row = sheet.getRow(j);
				if (row == null) {
					continue;
				}
				ArrayList<String> rowData = new ArrayList<String>();
				final short lastCellNum = row.getLastCellNum();
				for (int k = 0; k < lastCellNum; k++) {
					Cell cell = row.getCell(k);
					if (cell != null) {
						String value = cellToObject(cell);
						rowData.add(value);
					} else {
						rowData.add(null);
					}
				}
				tmp.addRow(rowData);
			}

			// if(config.isFillColumns()) {
			// tmp.fillColumns();
			// }
			book.addExcelWorksheet(tmp);
		}

		return book;
	}

	private String cellToObject(Cell cell) {

		int type = cell.getCellType();

		switch (type) {

		case CELL_TYPE_NUMERIC:
			return numeric(cell);

		// case CELL_TYPE_BOOLEAN:
		// return cell.getBooleanCellValue();
		//
		// case CELL_TYPE_FORMULA:
		// switch(cell.getCachedFormulaResultType()) {
		// case Cell.CELL_TYPE_NUMERIC:
		// return numeric(cell);
		// case Cell.CELL_TYPE_STRING:
		// return cleanString(cell.getRichStringCellValue().toString());
		// }

		case CELL_TYPE_FORMULA:
			String err = " The CELL_TYPE_FORMULA does not supported";
			return "";

		case CELL_TYPE_BOOLEAN:
			err = " The CELL_TYPE_BOOLEAN does not supported";
			return "";

		case CELL_TYPE_ERROR:
			err = " The CELL_TYPE_ERROR does not supported";
			System.err.println(err);
			return "";

		case CELL_TYPE_BLANK:
		case CELL_TYPE_STRING:
		default:
			final String stringCellValue = cell.getStringCellValue();
			return cleanString(stringCellValue);

		}

	}

	private String cleanString(String str) {
		return str.replace("\n", "").replace("\r", "").trim();
	}

	private String numeric(Cell cell) {
		double numericCellValue = cell.getNumericCellValue();
		if (cell.getCellStyle().getDataFormatString().contains("%")) {
			numericCellValue = numericCellValue * 100;
		}
		return String.format("%4.0f",numericCellValue).trim();
	}
	
	public static void main(String[] args) throws Exception {
		ExcelWorkbook book = new com.verint.api.excel.converter.ExcelReader().convert("C:/1/Data-2.xlsx");
		String json = book.toJson(true);
		System.out.println(json);
	}
}
