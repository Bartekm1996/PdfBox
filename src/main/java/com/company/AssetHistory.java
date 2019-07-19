package com.company;

import javafx.beans.property.SimpleStringProperty;

public class AssetHistory {

    private SimpleStringProperty assetEventType;
    private SimpleStringProperty memeberLoaningEquipment;
    private SimpleStringProperty assetNameMemberLoaned;
    private SimpleStringProperty assetLoanedFrom;
    private SimpleStringProperty assetLoanedUntil;

    public AssetHistory(String aET, String mLE, String aNML, String aLF, String aLU){
        this.assetEventType = new SimpleStringProperty(aET);
        this.memeberLoaningEquipment = new SimpleStringProperty(mLE);
        this.assetNameMemberLoaned = new SimpleStringProperty(aNML);
        this.assetLoanedFrom = new SimpleStringProperty(aLF);
        this.assetLoanedUntil = new SimpleStringProperty(aLU);
    }

    public String getAssetEventType() {
        return assetEventType.get();
    }

    public SimpleStringProperty assetEventTypeProperty() {
        return assetEventType;
    }

    public void setAssetEventType(String assetEventType) {
        this.assetEventType.set(assetEventType);
    }

    public String getMemeberLoaningEquipment() {
        return memeberLoaningEquipment.get();
    }

    public SimpleStringProperty memeberLoaningEquipmentProperty() {
        return memeberLoaningEquipment;
    }

    public void setMemeberLoaningEquipment(String memeberLoaningEquipment) {
        this.memeberLoaningEquipment.set(memeberLoaningEquipment);
    }

    public String getAssetNameMemberLoaned() {
        return assetNameMemberLoaned.get();
    }

    public SimpleStringProperty assetNameMemberLoanedProperty() {
        return assetNameMemberLoaned;
    }

    public void setAssetNameMemberLoaned(String assetNameMemberLoaned) {
        this.assetNameMemberLoaned.set(assetNameMemberLoaned);
    }

    public String getAssetLoanedFrom() {
        return assetLoanedFrom.get();
    }

    public SimpleStringProperty assetLoanedFromProperty() {
        return assetLoanedFrom;
    }

    public void setAssetLoanedFrom(String assetLoanedFrom) {
        this.assetLoanedFrom.set(assetLoanedFrom);
    }

    public String getAssetLoanedUntil() {
        return assetLoanedUntil.get();
    }

    public SimpleStringProperty assetLoanedUntilProperty() {
        return assetLoanedUntil;
    }

    public void setAssetLoanedUntil(String assetLoanedUntil) {
        this.assetLoanedUntil.set(assetLoanedUntil);
    }
}
