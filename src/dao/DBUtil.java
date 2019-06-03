package dao;


import model.Animal;
import model.AppUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtil {

    private static DBUtil uniqueInstance;
    SessionFactory factory;

    private DBUtil() {
    }
    public static DBUtil getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DBUtil();
        }
        return uniqueInstance;
    }
    public Session getSession() {

        // crt factiry
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(AppUser.class)
                .addAnnotatedClass(Animal.class)
                .buildSessionFactory();
        return factory.getCurrentSession();
    }
    public void closeConnection() {
        factory.close();
    }

}
