package Service;

import dao.DBUtil;
import model.AppUser;
import org.hibernate.Session;
import util.SessionUtil;

import java.util.List;

public class AuthService {
    public static boolean Authorisation(String username, String password) {
        boolean isAuthorised = false;
        DBUtil dbUtil = DBUtil.getInstance();
        Session session = dbUtil.getSession();
        session.beginTransaction();

        List<AppUser> appUsers = session.createQuery("from AppUser").list();

        for (AppUser appUser : appUsers) {
            if (username.equals(appUser.getUsername()) && password.equals(appUser.getPassword())) {
                isAuthorised = true;
                SessionUtil.setCurrentUser(appUser);
                break;
            }
        }
        dbUtil.closeConnection();
        return isAuthorised;
    }
}
