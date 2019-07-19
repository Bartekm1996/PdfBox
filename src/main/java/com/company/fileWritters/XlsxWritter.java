package com.company.fileWritters;


import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.company.Asset;
import com.company.strings.Globalstrings;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;


public class XlsxWritter {

    private static final Logger logger = Logger.getLogger(XlsxWritter.class.getName());

    public void writeToXlsxFile(ArrayList<Asset> assetsList, String fileName){


        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Clubs Diving Equipment List");
        sheet.setAutoFilter(CellRangeAddress.valueOf("A1:H1"));

        Row row = sheet.createRow(0);

        XSSFFont font= workbook.createFont();
        font.setFontHeightInPoints((short)10);
        font.setFontName("Arial");
        font.setBold(true);
        font.setItalic(false);

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        CellStyle style_1 = workbook.createCellStyle();
        style_1.setAlignment(HorizontalAlignment.CENTER);
        style_1.setVerticalAlignment(VerticalAlignment.CENTER);
        style_1.setFont(font);


        for(int i = 0; i < Globalstrings.FILE_HEADERS.length; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(Globalstrings.FILE_HEADERS[i]);
            cell.setCellStyle(cellStyle);
            cell.setCellStyle(style_1);
        }

        sheet.createFreezePane(0,1);

        CellStyle numericStyle = workbook.createCellStyle();
        numericStyle.setAlignment(HorizontalAlignment.CENTER);
        numericStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        numericStyle.setDataFormat(workbook.createDataFormat().getFormat(BuiltinFormats.getBuiltinFormat(0)));
        for(int i = 0; i < assetsList.size(); i++){
            String[] split_line = assetsList.get(i).toString().split(",");
            row = sheet.createRow(i+1);
            for(int j = 0; j < split_line.length; j++){
                Cell cell = row.createCell(j);
                     cell.setCellValue(split_line[j]);
                     cell.setCellStyle(cellStyle);
            }

        }

        sheet.setDefaultColumnWidth(12);

        try(FileOutputStream fileOut = new FileOutputStream(fileName)){
            workbook.write(fileOut);
            logger.info("Finished writing " + assetsList.size()+" tapes to xlsx file " + fileName);
            logger.info("\n\n-------------------------------------------------------Finished Logging-----------------------------------------------------------------------\n\n");
        }catch(IOException exception){
            logger.log(Level.SEVERE, exception.toString(), exception);
        }
    }




}
