package by.instasite.database;


import javax.persistence.Entity;
import javax.persistence.Table;
import java.net.URL;

@Entity
@Table(name = "users")
public class Authorization {
    public boolean CheckCredentials(String username, String password){
        return true;
    }

    public boolean CreateNewUser(String username, String password, String email, String country, URL imageUrl){

        return true;
    }

    public void ChangeUserInfo(){

    }

}
