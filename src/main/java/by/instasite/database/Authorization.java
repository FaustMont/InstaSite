package by.instasite.database;


import by.instasite.database.user.User;
import by.instasite.database.user.UserTemplate;

public class Authorization {


    public boolean CheckCredentials(String username, String password){
        try {
            User user = new UserTemplate().getUserByUsername(username);
            if(user.getPassword()==password) {
                return true;
            } else return false;
        } catch (NullPointerException e) {
            return false;
        }

    }

    public boolean CreateNewUser(String username, String password, String email, String country){
        try {
            new UserTemplate().createUser(username, password, email, country);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public void ChangeUserInfo(){

    }

}
