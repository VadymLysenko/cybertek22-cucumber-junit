package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExelWrite {

    XSSFWorkbook workbook;
    XSSFRow row;
    XSSFSheet sheet;
    XSSFCell cell;

    @Test
    public void excel_writing_test() throws IOException {

        String path = "SampleData.xlsx";

        // to be able to read from exel file,
        //we need to load in into FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook > sheet > row > cell
        workbook = new XSSFWorkbook(fileInputStream);

        // get the sheet
        sheet = workbook.getSheet("Employees");

        //king's row
        row = sheet.getRow(1);

        //king's cell
        cell = row.getCell(1);

        // Create and store Adams cell
        XSSFCell adamsCell = sheet.getRow(2).getCell(0);
        System.out.println("Before: " +adamsCell);

        // this method will override
        adamsCell.setCellValue("MadamM");

        // use fileOutputStream to push changes --> load the file to fileOutputStream
        FileOutputStream fileOutputStream = new FileOutputStream(path);

        //Write to file using fileOutputStream
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();





    }
}
