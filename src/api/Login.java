package api;
import java.util.HashMap;
import java.util.Map;

public class Login {
    AllRegistered R;

    public Login(){
        R=new AllRegistered();


    }

    public String log_in(String username,String password){
        if (R.registered_users.get(username)!=null)
            {
                Registration r=R.registered_users.get(username);
                if (r.getUsername().equals(username) && r.getPassword().equals(password))
                    return  "User"+"#"+R.registered_users.get(username).getName();
            }
        else if (R.registered_providers.get(username)!=null)
            {
                Registration r=R.registered_providers.get(username);
                if (r.getUsername().equals(username) && r.getPassword().equals(password))
                    return "Provider"+"#"+R.registered_providers.get(username).getName();
            }
        return null;

    }
}
