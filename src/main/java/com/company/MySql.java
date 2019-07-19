package com.company;

import java.sql.*;
import java.util.ArrayList;

public class MySql {

    public static ArrayList<Asset> viewAssets(){

        ArrayList<Asset> assetArrayList = new ArrayList<>();

        try {

            Connection connection = DriverManager.getConnection("","","");
            Statement statement = connection.createStatement();

            String sqlQuery = "Select * from Assets";

            ResultSet set = statement.executeQuery(sqlQuery);

            while(set.next()){
                assetArrayList.add(new Asset(set.getString("assetType"),set.getString("assetMake"), set.getString("assetModel"),
                        set.getString("assetPicPath"), set.getString("assetServiceDate"), set.getString("assetPurchaseDate"),
                        set.getBoolean("assetUsable"),set.getBoolean("assetOnLoan")));
            }
            
            set.close();

        }catch (SQLException exception){
            exception.printStackTrace();
        }

        return assetArrayList;

    }




}
