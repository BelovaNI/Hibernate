package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/database_1?autoReconnect=true&useSSL=false";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "1Donnet!";


    public static Connection getConnection () throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
