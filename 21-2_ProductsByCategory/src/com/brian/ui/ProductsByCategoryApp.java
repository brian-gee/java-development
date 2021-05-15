package com.brian.ui;

import com.brian.items.Category;
import com.brian.items.Product;
import com.brian.db.ProductDB;

import java.util.List;

public class ProductsByCategoryApp {
    ProductDB db = new ProductDB();
    private List<Category> categories = db.getCategories();
    private List<Product> products = db.getProducts();
    private int userChoice;

    public ProductsByCategoryApp() {
        System.out.println("Products by Category");
        while (userChoice != 998) {
            listCategories();
            userChoice = getCategoryID() - 1;
            if (userChoice < categories.size()) {
                printCategory(userChoice);
            }
        }
        System.out.println("\nBye!");
    }

    public void listCategories() {
        System.out.println("\nCATEGORIES");
        int i = 1;
        for (Category c : categories) {
            System.out.println(i + " - " + c.getCategoryName());
            i++;
        }

    }

    public void printCategory(int i) {
        Category c = categories.get(i);
        System.out.println("\n" + c.getCategoryName().toUpperCase());
        System.out.println(StringUtil.pad("Code", 15) +
                StringUtil.pad("Name", 40) + StringUtil.pad("Price", 10));
        System.out.println("--------------------------------------------------------------");
        for (Product p : products) {
            if (p.getCategoryID() == (i+1)) {
                System.out.println(StringUtil.pad(p.getProductCode(), 15) +
                        StringUtil.pad(p.getProductName(), 40) +
                        StringUtil.pad(String.valueOf(p.getListPrice()), 10));
            }
        }

    }

    public int getCategoryID() {
        int id = Console.getInt("\nEnter a category id (999 to exit): ");
        return id;
    }
}