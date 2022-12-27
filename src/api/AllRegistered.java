package api;

import java.util.HashMap;

public class AllRegistered {

    protected HashMap<String,Registration> registered_users,registered_providers;

    public AllRegistered(){
        registered_users=new HashMap<>();
        registered_providers=new HashMap<>();
    }

    public void add_registration(String username,String password,String name,String surname,String type){
        Registration reg =new Registration(username,password,name,surname,type);
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

    public Registration getUserRegistration(String key){
        return registered_users.get(key);
    }







}
