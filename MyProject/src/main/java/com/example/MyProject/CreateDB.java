package com.example.MyProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String driver = "org.postgresql.Driver";
    private static final String login = "postgres";
    private static final String password = "postgres";

    public void ConnectDB() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
        statement = connection.createStatement();
        statement.executeUpdate("CREATE DATABASE myprojectapplicationdb");
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new CreateDB().ConnectDB();
    }
}