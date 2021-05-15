package com.brian.db;

import com.brian.items.Category;
import com.brian.items.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB{

    private List<Category> categories = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    public List<Category> getCategories() {
        categories = getAllCategories();
        return categories;
    }

    public List<Product> getProducts() {
        products = getAllProducts();
        return products;
    }

    private List<Category> getAllCategories() {
        String sql = "SELECT categoryID, categoryName FROM Category";
        List<Category> l = new ArrayList<>();
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                Category c = new Category(rs.getInt("categoryID"), rs.getString("categoryName"));
                l.add(c);
            }
            return l;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Product> getAllProducts() {
        String sql = "SELECT productID, categoryID, productCode, productName, listPrice FROM Product";
        List<Product> l = new ArrayList<>();
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()) {
                Product p = new Product(rs.getInt("productId"), rs.getInt("categoryID"),
                                        rs.getString("productCode"), rs.getString("productName"),
                                        rs.getDouble("listPrice"));
                l.add(p);
            }
            return l;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Connection connect() throws SQLException {
        String dbUrl = "jdbc:sqlite:guitar_shop.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }
}