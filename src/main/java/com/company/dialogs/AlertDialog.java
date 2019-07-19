package com.company.dialogs;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertDialog {

    public static void AlertDialog(String error_message){

        Stage stage = new Stage();
              stage.initModality(Modality.APPLICATION_MODAL);
              stage.setScene(new Scene(alertDialogPane(error_message, stage)));
              stage.show();

    }

    private static GridPane alertDialogPane(String alertDialogMessage,Stage parentStage){
        GridPane gridPane = new GridPane();
                 gridPane.setPadding(new Insets(10));
        Label error_message = new Label(alertDialogMessage);
        Button okButton = new Button("Ok");
               okButton.setOnAction(event -> {
                   parentStage.close();
               });
        GridPane.setHalignment(okButton, HPos.RIGHT);
        gridPane.add(error_message, 0 ,0 ,2 ,1);
        gridPane.add(okButton, 1,1);

        return gridPane;
    }




}
