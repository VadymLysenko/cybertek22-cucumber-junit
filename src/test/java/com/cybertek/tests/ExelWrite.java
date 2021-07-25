package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExelWrite {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;

    @Test
    public void excel_writing_test() throws FileNotFoundException {

        String path = "SampleData.xlsx";

        // to be able to read from exel file,
        //we need to load in into FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);
    }
}
