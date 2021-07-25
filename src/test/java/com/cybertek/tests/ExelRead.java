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

        String path = "SampleData.numbers";

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


    }
}
