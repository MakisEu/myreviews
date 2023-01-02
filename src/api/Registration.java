package api;

import java.io.Serializable;
import java.net.PasswordAuthentication;
import java.util.ArrayList;

public class Registration implements Serializable {

    private String Username, Password, Name, Surname, user_type;

    public Registration(String username, String password, String name, String surname, String type) {
        Username = username;
        Password = password;
        Name = name;
        Surname = surname;
        user_type = type;
    }

    public String getUserType() {
        return user_type;
    }

    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}






