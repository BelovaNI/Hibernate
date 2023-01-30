package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/database_1";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "1Donnet!";


    public static Connection getConnection () {
        Connection connection = null;
        try {
            connection =DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }catch (SQLException ex) {
            System.out.println("Connection error");
        }
        return connection;
    }
}
