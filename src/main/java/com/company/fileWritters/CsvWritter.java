package com.company.fileWritters;

import com.company.Asset;
import com.company.strings.Globalstrings;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvWritter {

    public void csvWritter(ArrayList<Asset> assetList, String filePath){

        File file = new File(filePath);
        try {
            if (!file.exists()) file.createNewFile();

            FileWriter fileWriter = new FileWriter(file);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            csvWriter.writeNext(Globalstrings.FILE_HEADERS);

            for (Asset asset : assetList){
                 String[] split = asset.toString().split(",");
                 csvWriter.writeNext(split);
            }

            csvWriter.close();

        }catch (IOException exception){
            exception.printStackTrace();
        }
    }


}
