package com.company;

import javafx.beans.property.SimpleStringProperty;

public class PdfFiles {

    private SimpleStringProperty NameOfFile;
    private SimpleStringProperty DateOFile;

    public PdfFiles(String nameOfFile,String datOfFile){
        this.NameOfFile = new SimpleStringProperty(nameOfFile);
        this.DateOFile = new SimpleStringProperty(datOfFile);
    }

    public void setNameOfFile(String nameOfFile){
        this.NameOfFile.set(nameOfFile);
    }

    public String getNameOfFile(){
        return this.NameOfFile.get();
    }

    public void setDateOFile(String dateOFile){
        this.DateOFile.set(dateOFile);
    }

    public String getDateOfFile(){
        return this.DateOFile.get();
    }



}
