package com.rakin.dresscollection101.Service;

import com.rakin.dresscollection101.Model.DressCollection;
import com.rakin.dresscollection101.Model.Gender;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    public void save (DressCollection dressCollection) {
        try {
            Connection connection = Singletone.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO product VALUE('"+
                    dressCollection.getName()+"' , '"+
                    dressCollection.getType()+"' , '"+
                    dressCollection.getSize()+"' , '"+
                    dressCollection.getColor()+"' ,"+
                    dressCollection.getPrice()+", '"+
                    dressCollection.getDetails()+"' , '"+
                    dressCollection.getDate()+"' ,"+
                    dressCollection.getQuantity()+", '"+
                    dressCollection.getDiscCode()+"' , '"+
                    dressCollection.getGender()+"' , '"+
                    dressCollection.getBoosting()+"' , '"+
                    dressCollection.getImage()+"')";
            statement.execute(query);
            System.out.println("Info Saved");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public List<DressCollection> list() {
        List<DressCollection> CollectionsList = new ArrayList<>();
        try {
            Connection connection = Singletone.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM product";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String size = resultSet.getString("size");
                String color = resultSet.getString("color");
                double price = Double.parseDouble(resultSet.getString("price"));
                String details = resultSet.getString("details");
                String date = resultSet.getString("date");
                int quantity = Integer.parseInt(resultSet.getString("quantity"));
                String disCode = resultSet.getString("code");
                String gender = resultSet.getString("gender");
                String boosting = resultSet.getString("boosting");
                String image = resultSet.getString("image");

                DressCollection dressCollection = new DressCollection(
                        name, type,
                        size, color,
                        price,details,
                        date,quantity,
                        disCode,gender,boosting,image);
                CollectionsList.add(dressCollection);
            }
            System.out.println("Showing Info");
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CollectionsList;
    }
    public boolean delete(String deleteByName){
        try {
            Connection connection = Singletone.getConnection();
            Statement statement = connection.createStatement();
            String query = "DELETE FROM product WHERE name = '"+deleteByName+"'";
            statement.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    public boolean update (String updatedName,String PreviousName){
        try {
            Connection connection = Singletone.getConnection();
            Statement statement = connection.createStatement();
            //UPDATE product SET name  = 'Hello' WHERE name = 'hoodie';
            String query = "UPDATE product SET name = '"+updatedName+"' WHERE name = '"+PreviousName+"'";
            statement.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
