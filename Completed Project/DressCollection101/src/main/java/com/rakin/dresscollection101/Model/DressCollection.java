package com.rakin.dresscollection101.Model;

import java.time.LocalDate;

public class DressCollection {
    private String name;
    private String type;
    private String size;
    private String color;
    private double price;
    private String details;
    private String date;
    private int quantity;
    private String discCode;
    private String gender;
    private String boosting;
    private String image;

    public DressCollection() {
    }

    public DressCollection(String name, String type, String size, String color,
                           double price, String details, String date, int quantity, String discCode, String gender,
                           String boosting, String image) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.color = color;
        this.price = price;
        this.details = details;
        this.date = date;
        this.quantity = quantity;
        this.discCode = discCode;
        this.gender = gender;
        this.boosting = boosting;
        this.image = image;
    }

    @Override
    public String toString() {
        return "DressCollection{\n" +
                "name='" + name + '\'' +
                "\n type='" + type + '\'' +
                "\n size='" + size + '\'' +
                "\n color='" + color + '\'' +
                "\n price=" + price +
                "\n details='" + details + '\'' +
                "\n date='" + date + '\'' +
                "\n quantity=" + quantity +
                "\n discCode='" + discCode + '\'' +
                "\n gender='" + gender + '\'' +
                "\n boosting='" + boosting + '\'' +
                "\n image='" + image + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDiscCode() {
        return discCode;
    }

    public void setDiscCode(String discCode) {
        this.discCode = discCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBoosting() {
        return boosting;
    }

    public void setBoosting(String boosting) {
        this.boosting = boosting;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
