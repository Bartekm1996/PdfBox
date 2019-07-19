package com.company;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Asset {

    private SimpleStringProperty assetType;
    private SimpleStringProperty assetMake;
    private SimpleStringProperty assetModel;
    private SimpleStringProperty assetPicPath;
    private SimpleStringProperty assetServiceDate;
    private SimpleStringProperty assetPurchaseDate;
    private SimpleBooleanProperty assetUsuable;
    private SimpleBooleanProperty assetOnLoan;
    private ArrayList<AssetHistory> assetHistory = new ArrayList<>();

    public Asset(String assetType,String assetMake,String assetModel,String assetPicPath,String assetServiceDate,String assetPurchaseDate,boolean assetUsuable, boolean assetOnLoan){
        this.assetType = new SimpleStringProperty(assetType);
        this.assetMake = new SimpleStringProperty(assetMake);
        this.assetModel = new SimpleStringProperty(assetModel);
        this.assetPicPath = new SimpleStringProperty(assetPicPath);
        this.assetServiceDate = new SimpleStringProperty(assetServiceDate);
        this.assetPurchaseDate = new SimpleStringProperty(assetPurchaseDate);
        this.assetUsuable = new SimpleBooleanProperty(assetUsuable);
        this.assetOnLoan = new SimpleBooleanProperty(assetOnLoan);
    }

    public String getAssetType() {
        return assetType.get();
    }

    public SimpleStringProperty assetTypeProperty() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType.set(assetType);
    }

    public String getAssetMake() {
        return assetMake.get();
    }

    public SimpleStringProperty assetMakeProperty() {
        return assetMake;
    }

    public void setAssetMake(String assetMake) {
        this.assetMake.set(assetMake);
    }

    public String getAssetModel() {
        return assetModel.get();
    }

    public SimpleStringProperty assetModelProperty() {
        return assetModel;
    }

    public void setAssetModel(String assetModel) {
        this.assetModel.set(assetModel);
    }

    public String getAssetPicPath() {
        return assetPicPath.get();
    }

    public SimpleStringProperty assetPicPathProperty() {
        return assetPicPath;
    }

    public void setAssetPicPath(String assetPicPath) {
        this.assetPicPath.set(assetPicPath);
    }

    public String getAssetServiceDate() {
        return assetServiceDate.get();
    }

    public SimpleStringProperty assetServiceDateProperty() {
        return assetServiceDate;
    }

    public void setAssetServiceDate(String assetServiceDate) {
        this.assetServiceDate.set(assetServiceDate);
    }

    public String getAssetPurchaseDate() {
        return assetPurchaseDate.get();
    }

    public SimpleStringProperty assetPurchaseDateProperty() {
        return assetPurchaseDate;
    }

    public void setAssetPurchaseDate(String assetPurchaseDate) {
        this.assetPurchaseDate.set(assetPurchaseDate);
    }

    public boolean isAssetUsuable() {
        return assetUsuable.get();
    }

    public SimpleBooleanProperty assetUsuableProperty() {
        return assetUsuable;
    }

    public void setAssetUsuable(boolean assetUsuable) {
        this.assetUsuable.set(assetUsuable);
    }

    public boolean isAssetOnLoan() {
        return assetOnLoan.get();
    }

    public SimpleBooleanProperty assetOnLoanProperty() {
        return assetOnLoan;
    }

    public void setAssetOnLoan(boolean assetOnLoan) {
        this.assetOnLoan.set(assetOnLoan);
    }

    public ArrayList<AssetHistory> getAssetHistory(){
        return this.assetHistory;
    }

    public void addToAssetHistory(AssetHistory aH){
        this.assetHistory.add(aH);
    }

    public String toString(){
        return this.assetType + "," + this.assetMake + "," + this.assetModel + "," + this.assetServiceDate + "," +
               this.assetPurchaseDate + "," + this.assetOnLoan;
    }


}
