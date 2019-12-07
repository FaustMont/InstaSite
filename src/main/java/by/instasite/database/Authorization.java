package by.instasite.database;


import by.instasite.database.user.User;
import by.instasite.database.user.UserTemplate;

public class Authorization {


    public String CheckCredentials(String username, String password){
            User user = new UserTemplate().getUserByUsername(username);
            if(user.getPassword().equals(password)) {
                return "true";
            } else return "Username or password is not correct";

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
