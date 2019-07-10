package controllers;

import java.sql.*;

public class MySqlController {
    public Statement connect(){
        Connection connection = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/bookitems", "user", "password");

            stmt = connection.createStatement();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;

    }

    public void add(String bookID,String bookTitle,String bookPrice){
        Statement stmt = connect();
        try
        {

            stmt.execute("INSERT INTO items (ID,TITLE,PRICE) "
                    + "VALUES ("+bookID+",'"+bookTitle+"',"+bookPrice+")");
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void delete(String bookID){
        Statement stmt = connect();
        try
        {

            stmt.execute("DELETE FROM items WHERE ID IN ('"+bookID+"')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void update(String bookID,String bookTitle,String bookPrice){
        Statement stmt = connect();
        try
        {

            stmt.execute("UPDATE items SET TITLE =('"+bookTitle+"'),PRICE = ('"+bookPrice+"')WHERE ID = ('"+bookID+"')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void display(){
        Statement stmt = connect();
        try
        {
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM items ");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));

                }
                System.out.println("");
            }
            System.out.println();
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
