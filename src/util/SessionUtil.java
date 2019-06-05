package util;

import model.AppUser;

public class SessionUtil {
    private static AppUser currentUser;

    public static AppUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(AppUser currentUser) {
        SessionUtil.currentUser = currentUser;
    }

}
