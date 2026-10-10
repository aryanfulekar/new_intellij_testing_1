
package org.example;

import java.sql.*;

public class Main {

    private static final String URL =
            "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "Aa221398";

    public static void main(String[] args) {

        String sql = "SELECT * FROM students";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

             Statement statement = connection.createStatement();

             ResultSet rs = statement.executeQuery(sql)) {

            System.out.println("Connected successfully!");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                double marks = rs.getDouble("marks");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Age: " + age);
                System.out.println("Marks: " + marks);
                System.out.println("-------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
