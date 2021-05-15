package com.brian.items;

public class Product {

    private int productID;
    private int categoryID;
    private String productCode;
    private String productName;
    private double listPrice;


    public Product(int productID, int categoryID, String productCode, String productName, double listPrice) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productCode = productCode;
        this.productName = productName;
        this.listPrice = listPrice;
    }


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }
}