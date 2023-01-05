package api;
import java.util.HashMap;
import java.util.Map;

public class Login {
    /**Variables of the Login class
     * R    AllRegistered object
     */
    AllRegistered R;

    /**
     * Normal constructor:
     */
    public Login(){
        R=new AllRegistered();


    }

    /**
     *
     * @param username The username of a user/provider
     * @param password The password of a user/provider
     * @return A string that contains  the type of the user # the name of the user ("type"#name) or null
     */
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
