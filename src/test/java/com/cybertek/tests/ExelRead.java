package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExelRead {

    /*
    we will learn how to read from exel file
    step by step
     */
    @Test
    public void read_from_exel_file() throws IOException {

        String path = "SampleData.xlsx";

        // to be able to read from exel file,
        //we need to load in into FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook > sheet > row > cell

        // 1 - create new workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // 2 - we need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        // 3 - select row and cell
        // Print out Steven's cell
        // Indexes start from 0
        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        System.out.println("sheet.getRow(3).getCell(2) = " + sheet.getRow(3).getCell(2));

        int usedRows = sheet.getPhysicalNumberOfRows();

        int lastUsedRow = sheet.getLastRowNum();

        // TODO: 1 - Create a logic to print out Neena's name dynamically

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Neena")){
                System.out.println("Neena's name = " + sheet.getRow(rowNum).getCell(0));
            }
            
        }

        //TODO: Create a logic to print out Steven King's job
        // Check for Steven's name, if  its Steven --> print out job-id
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){
                System.out.println("Steven's JOB_ID: " + sheet.getRow(rowNum).getCell(2).toString());
            }

        }
        
    }
}
