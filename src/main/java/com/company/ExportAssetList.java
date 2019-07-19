package com.company;

import com.company.dialogs.AlertDialog;
import com.company.fileWritters.CsvWritter;
import com.company.fileWritters.XlsxWritter;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class ExportAssetList {

    private @FXML AnchorPane exportListAnchorPane;
    private @FXML Label fileDirectoryChooser;
    private @FXML ComboBox<String> fileFormatComboBox;

   public void fileDest(){
       DirectoryChooser directoryChooser = new DirectoryChooser();
       File destinationFile = directoryChooser.showDialog(exportListAnchorPane.getScene().getWindow());

       if(destinationFile != null){
           fileDirectoryChooser.setText(destinationFile.getPath());
       }else {
           AlertDialog.AlertDialog("Invalid Path");
       }
   }

   public void exportButton(){

       String filePath = "";

       if(fileFormatComboBox.getSelectionModel() != null){
           filePath = fileDirectoryChooser.getText() + fileFormatComboBox.getSelectionModel().getSelectedItem();
           switch (fileFormatComboBox.getSelectionModel().getSelectedItem()){
               case ".csv":{
                   CsvWritter csvWritter = new CsvWritter();
                              csvWritter(,filePath);
                   break;
               }
               case ".xlsx":{
                   XlsxWritter xlsxWritter = new XlsxWritter();
                               xlsxWritter.writeToXlsxFile(,filePath);
                   break;
               }
               default:
                   break;
           }
       }
   }
}
