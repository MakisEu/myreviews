package api;

import java.io.*;
import java.util.HashMap;

public class AllRegistered implements  Serializable{

    /**All the Variables of AllRegistered class:
     * registered_users         A hashmap contains registrations for every registered user
     * registered_providers     A hashmap contains registrations for every registered provider
     */
    protected HashMap<String,Registration> registered_users,registered_providers;

    /**
     * Normal constructor:
     */
    public AllRegistered(){
        registered_users=new HashMap<>();
        registered_providers=new HashMap<>();
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Database/Accounts.dat"))) {
            HashMap<String,Registration> a =(HashMap<String,Registration>) oos.readObject();
            HashMap<String,Registration> h = (HashMap<String,Registration>) oos.readObject();
            registered_users.putAll(a);
            registered_providers.putAll(h);
        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
        }
    }

    /**
     * This method adds a new registration in one of the 2 hashmaps accordingly to the user type
     * @param username The username
     * @param password The password
     * @param name     The name
     * @param surname  The surname
     * @param type     The type of user
     */
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
        destructor();
    }

    /**
     * This method checks if there is a registration with the given username
     * @param username The username
     * @return true or false
     */
    public boolean contains(String username){
        if (registered_users.containsKey(username) || registered_providers.containsKey(username)){
            return true;
        }
        else {return false;}
    }

    /**
     * This method returns a registration based on the given key(-username)
     * @param key A username-key for the hashmap
     * @return A registration
     */
    public Registration getUserRegistration(String key){
        return registered_users.get(key);
    }
    private void destructor(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Database/Accounts.dat"))) {
            oos.writeObject(registered_users);
            oos.writeObject(registered_providers);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Write the data in a binary file and close it
    }

}
