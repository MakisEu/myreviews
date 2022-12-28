package api;
import java.util.HashMap;
import java.util.Map;

public class Login {

    public Login(){

    }

    void log_in(String username,String password,AllRegistered R){
        if (R.registered_users.get(username).getUsername().equals(username) && R.registered_users.get(username).getPassword().equals(password))
            {
            System.out.println("Επιτυχής σύνδεση!");
            }
        else if (R.registered_providers.get(username).getUsername().equals(username) && R.registered_providers.get(username).getPassword().equals(password))
            {
            System.out.println("Επιτυχής σύνδεση!");
            }
        else
            System.out.println("Λάθος στοιχεία");

    }

}
