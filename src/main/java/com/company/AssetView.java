package com.company;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AssetView {

    private @FXML AnchorPane anchorPane;
    private @FXML Label assetUsableLabel;
    private @FXML Label assetLastServieDateLabel;
    private @FXML Label assetOnRentLabel;
    private @FXML Label assetPurchaseDate;
    private @FXML Label assetModelLabel;
    private @FXML Label assetTagNumberLabel;
    private @FXML Label assetIdLabel;
    private ComboBox<String> assetOnRentComboBox;
    private ComboBox<String> assetStateComboBox;
    private DatePicker dateAssetPurchased;
    private DatePicker dateAssetLastServiced;
    private TextField assetModelTxtField;
    private TextField assetTagNumberTextField;

    public void changeToComboBox(){
        assetOnRentComboBox = new ComboBox<>(FXCollections.observableArrayList("True","False"));
        assetOnRentComboBox.setPromptText(assetOnRentLabel.getText());
        removeAssetOnRentLabel(this.assetOnRentLabel, this.assetOnRentComboBox);
        assetOnRentComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null){
                assetOnRentLabel.setText(assetOnRentComboBox.getSelectionModel().getSelectedItem());
                addAssetOnRentLabel(this.assetOnRentLabel,this.assetOnRentComboBox);
            }
        });
    }


    public void assetToComboBox(){
        assetStateComboBox = new ComboBox<>(FXCollections.observableArrayList("Usable", "In Service", "Broken"));
        assetStateComboBox.setPromptText(assetUsableLabel.getText());
        removeAssetOnRentLabel(this.assetUsableLabel, this.assetStateComboBox);
        assetStateComboBox.valueProperty().addListener((observable,oldValue, newValue) -> {
            if(newValue != null){
                assetUsableLabel.setText(assetStateComboBox.getSelectionModel().getSelectedItem());
                addAssetOnRentLabel(this.assetUsableLabel, this.assetStateComboBox);
            }
        });
    }

    public void addLastServiceDatePicker(){
        dateAssetLastServiced = new DatePicker();
        dateAssetLastServiced.setPromptText(this.assetLastServieDateLabel.getText());
        removeAssetOnRentLabel(this.assetLastServieDateLabel, this.dateAssetLastServiced);

        dateAssetLastServiced.valueProperty().addListener(((observable, oldValue, newValue) -> {
            if(newValue != null){
                this.assetLastServieDateLabel.setText(newValue.toString());
                addAssetOnRentLabel(this.assetLastServieDateLabel, this.dateAssetLastServiced);
            }
        }));

    }

    public void addPurchaseDatePicker(){
        dateAssetPurchased = new DatePicker();
        dateAssetPurchased.setPromptText(this.assetPurchaseDate.getText());
        removeAssetOnRentLabel(this.assetPurchaseDate, this.dateAssetPurchased);

        dateAssetPurchased.valueProperty().addListener(((observable, oldValue, newValue) -> {
           if(newValue != null){
               this.assetPurchaseDate.setText(newValue.toString());
               addAssetOnRentLabel(this.assetPurchaseDate, this.dateAssetPurchased);
           }
        }));


    }

    public void addTextFieldToAsssetModel(){
        this.assetModelTxtField = new TextField();
        this.assetModelTxtField.setPromptText("Enter Assets Model");
        removeAssetOnRentLabel(this.assetModelLabel, this.assetModelTxtField);

        assetModelTxtField.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                if(!assetModelTxtField.getText().isEmpty()){
                    this.assetModelLabel.setText(assetModelTxtField.getText());
                    addAssetOnRentLabel(this.assetModelLabel, this.assetModelTxtField);
                }else addAssetOnRentLabel(this.assetModelLabel, this.assetModelTxtField);
            }
        });
    }

    public void addAssetTagNumberTextField(){
        assetTagNumberTextField = new TextField();
        assetTagNumberTextField.setPromptText("Alter Tag Number");
        removeAssetOnRentLabel(this.assetTagNumberLabel, this.assetTagNumberTextField);

        assetTagNumberTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(!newValue.isEmpty()){

            }else addAssetOnRentLabel(this.assetTagNumberLabel, this.assetTagNumberTextField);
        }));

    }

    public void viewAssetTag(){
        try {

                Stage qrCodeStage = new Stage();
                      qrCodeStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/AssetTagWindow.fxml"))));
                      qrCodeStage.initOwner(this.anchorPane.getScene().getWindow());
                      qrCodeStage.initModality(Modality.APPLICATION_MODAL);
                      qrCodeStage.show();

        }catch (IOException exception){
            exception.printStackTrace();
        }
    }

    public void exportAssetList(){

    }

    private void removeAssetOnRentLabel(Label assetLabel,Node comboBox){
        comboBox.setLayoutX(assetLabel.getLayoutX());
        comboBox.setLayoutY(assetLabel.getLayoutY());
        anchorPane.getChildren().remove(assetLabel);
        anchorPane.getChildren().add(comboBox);
    }

    private void addAssetOnRentLabel(Label assetLabel,Node comboBox){
        assetLabel.setLayoutX(comboBox.getLayoutX());
        assetLabel.setLayoutY(comboBox.getLayoutY());
        anchorPane.getChildren().remove(comboBox);
        anchorPane.getChildren().add(assetLabel);
    }



}
