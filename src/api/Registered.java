package api;

import java.util.ArrayList;

public class Registered {

    private ArrayList<Registration> registered_users,registered_providers;

    public Registered(){
        registered_users=new ArrayList<>();
        registered_providers=new ArrayList<>();
    }

    public void add_registration(Registration reg){
        if (username_availability(reg.getUsername(),reg.getUserType())) {
            if (reg.getUserType().equals("User")) {
                registered_users.add(reg);
            } else if (reg.getUserType().equals("Provider")) {
                registered_providers.add(reg);
            }
        }
        else
            System.out.println("This Username is already used! Set another Username!");
    }


    public boolean username_availability(String username,String type){
        if (type.equals("User"))
            {
            for (Registration x:registered_users)
                {
                 if (x.getUsername().equals(username))
                     return false;
                }
            return true;
            }
        else if (type.equals("Provider"))
            {
            for (Registration x:registered_providers)
                {
                if (x.getUsername().equals((username)))
                    return false;
                }
            return true;
            }
        else
            return false;
    }





}
