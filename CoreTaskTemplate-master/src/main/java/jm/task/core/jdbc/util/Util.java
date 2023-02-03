package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.sql.*;
import java.util.Properties;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/database_1?autoReconnect=true&useSSL=false";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "1Donnet!";
    private static SessionFactory sessionFactory;


    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
//                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
//                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/DataBase_1");
//                properties.put(Environment.USER, "root");
//                properties.put(Environment.PASS, "1Donnet!");
//                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//                properties.put(Environment.POOL_SIZE, "1");
                properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                properties.setProperty("hibernate.connection.url", URL);
                properties.setProperty("hibernate.connection.username", USER_NAME);
                properties.setProperty("hibernate.connection.password", PASSWORD);
                properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

                Configuration configuration = new Configuration()
                        .addProperties(properties).addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

