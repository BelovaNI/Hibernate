package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl DAO = new UserDaoHibernateImpl();
        DAO.createUsersTable();
        DAO.saveUser("Nadin", "Belova", (byte) 25);
        DAO.saveUser("Pavel", "Belov", (byte) 27);
        DAO.saveUser("Tatiana", "Sharifgalieva", (byte) 45);
        DAO.saveUser("Ilshat", "Sharifgaliev", (byte) 46);
        List<User> listUsers = DAO.getAllUsers();
        for (User user: listUsers) {
            System.out.println(user.toString());
            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
        }
        DAO.cleanUsersTable();
        DAO.dropUsersTable();
    }
}
