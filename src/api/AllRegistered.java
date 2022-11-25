package api;

import java.util.HashMap;

public class AllRegistered {

    private HashMap<String,Registration> registered_users,registered_providers;

    public AllRegistered(){
        registered_users=new HashMap<>();
        registered_providers=new HashMap<>();
    }

    public void add_registration(Registration reg){
        if (reg.getUserType().equals("User"))
        {
            if (registered_users.containsKey(reg.getUsername()))
            {
                System.out.println("This username is already used!Pick another one");
            }
            else
            {
                registered_users.put(reg.getUsername(),reg);
            }
        }
        else if (reg.getUserType().equals("Provider"))
        {
            if (registered_providers.containsKey(reg.getUsername()))
            {
                System.out.println("This username is already used!Pick another one");
            }
            else
            {
                registered_providers.put(reg.getUsername(),reg);
            }
        }
    }





}
