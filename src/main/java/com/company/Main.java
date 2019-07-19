package com.company;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Main extends Application {

    private final TableView pdfFilesView = new TableView();
    private final ArrayList<File> filesRead = new ArrayList<>();
    private final ArrayList<PdfFiles> pdfFiles = new ArrayList<>();

    public static void main(String args[]) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/AssetView.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.show();

        readPdfFileFromDirectory("C:/Users/bmlynark/Desktop/Tapes_BackUp_Cop_Folder/IronMountain/Delivery Requests");
        fileToPdfFiles();
        populateTableView(pdfFiles);

    }

    private void setAssetViewScene(){


    }

    private BorderPane scene(Stage parentstage){
        BorderPane borderPane = new BorderPane();
                   borderPane.setPadding(new Insets(10));

                   initTableView();

        HBox hBox = new HBox();
        DatePicker datePicker = new DatePicker();
                   datePicker.setOnAction(event -> {
                        compareDate(datePicker.getValue().toString());
                   });


        TextField searchField = new TextField();
        Stage spinnerStage = spinerStage(parentstage);
                  searchField.setPromptText("Enter Media Id");

                  searchField.setOnKeyPressed(event -> {
                      if(event.getCode() == KeyCode.ENTER){
                          pdfFilesView.getItems().clear();

                          Thread thread = new Thread(new Runnable() {
                              @Override
                              public void run() {
                                  searchForTape(searchField.getText());
                                  Platform.runLater(new Runnable() {
                                      @Override
                                      public void run() {
                                          spinnerStage.close();
                                      }
                                  });
                              }
                          });
                          thread.start();
                          spinerStage(parentstage).show();

                      }
                  });

                  hBox.getChildren().addAll(datePicker,searchField);
                  borderPane.setTop(hBox);
                  borderPane.setCenter(pdfFilesView);

        return borderPane;
    }

    private Stage spinerStage(Stage parentStage){
        Stage childStage = new Stage();
              childStage.initOwner(parentStage);
              childStage.initStyle(StageStyle.TRANSPARENT);

              VBox box = new VBox();
              ProgressIndicator pi = new ProgressIndicator();
              box.getChildren().add(pi);

              childStage.setScene(new Scene(box));

              return childStage;
    }

    private void searchForTape(String mediaId){
        for(File file : filesRead){
            if(getText(file.getPath()).contains(mediaId)){
                for(PdfFiles pdfFile : this.pdfFiles){
                    if(pdfFile.getNameOfFile().equals(file.getName())){
                        pdfFilesView.getItems().add(pdfFile);
                    }
                }
            }
        }

    }

    private void compareDate(String date_1){

        ArrayList<PdfFiles> pdfFiles = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate = LocalDate.parse(date_1,formatter);

        for(PdfFiles pdfFile : this.pdfFiles){
            System.out.println(LocalDate.parse(pdfFile.getDateOfFile(),formatter));
            if(localDate.equals(LocalDate.parse(pdfFile.getDateOfFile(),formatter))){
                pdfFiles.add(pdfFile);
                System.out.println("Added");
            }

        }
        pdfFilesView.getItems().clear();
        populateTableView(pdfFiles);


    }

    private void readPdfFileFromDirectory(String path){
        File dirFiles = new File(path);
        try{
            File[] filesList = dirFiles.listFiles();
            if(filesList != null){
                for(File file : filesList){
                    if(file.getPath().contains(".pdf")){
                        filesRead.add(file);
                    }
                }
            }
        }catch (NullPointerException exception){
            exception.printStackTrace();
        }
    }

    private String toDate(String fileName)throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("ddMMyyyy").parse(fileName.split("_")[0]));
    }

    private void fileToPdfFiles(){
        for(File file : filesRead ){
            try {
                PdfFiles pdfFile = new PdfFiles(file.getName(), toDate(file.getName()));
                         pdfFiles.add(pdfFile);
            }catch (ParseException exception){
                exception.printStackTrace();
            }
        }
    }

    private void populateTableView(ArrayList<PdfFiles> pdfFiles){
        pdfFilesView.getItems().addAll(pdfFiles);
    }

    private void initTableView(){
        TableColumn<String,PdfFiles> pdfFileName = new TableColumn<>("File Name");
                                     pdfFileName.setCellValueFactory(new PropertyValueFactory<>("NameOfFile"));

        TableColumn<String, PdfFiles> pdfFileDate = new TableColumn<>("Date");
                                      pdfFileDate.setCellValueFactory(new PropertyValueFactory<>("DateOfFile"));

                                      pdfFilesView.getColumns().addAll(pdfFileName,pdfFileDate);
    }



    private static String getText(String filePath){

        String text = "";

        try{
            File file = new File(filePath);
            PDFParser parser = new PDFParser(new RandomAccessFile(file,"r"));
                      parser.parse();
            COSDocument cosDoc = parser.getDocument();
            PDFTextStripper textStripper = new PDFTextStripper();
            PDDocument pdDoc = new PDDocument(cosDoc);
            pdDoc.getNumberOfPages();
            textStripper.setStartPage(0);
            textStripper.setEndPage(pdDoc.getNumberOfPages());
            text = textStripper.getText(pdDoc);
            pdDoc.close();

        }catch(IOException exception){
            exception.printStackTrace();
        }
        return text;
    }



}

