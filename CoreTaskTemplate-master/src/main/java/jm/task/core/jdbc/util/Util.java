package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

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

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/DataBase_1");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "1Donnet!");

        SessionFactory sessionFactory = new Configuration()
                .setProperties(properties)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        return sessionFactory;
    }
}
