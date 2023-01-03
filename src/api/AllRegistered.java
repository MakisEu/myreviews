package api;

import java.io.*;
import java.util.HashMap;

public class AllRegistered implements  Serializable{

    protected HashMap<String,Registration> registered_users,registered_providers;

    public AllRegistered(){
        registered_users=new HashMap<>();
        registered_providers=new HashMap<>();
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Accounts.dat"))) {
            HashMap<String,Registration> a =(HashMap<String,Registration>) oos.readObject();
            HashMap<String,Registration> h = (HashMap<String,Registration>) oos.readObject();
            registered_users.putAll(a);
            registered_providers.putAll(h);
        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
        }
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
        destructor();
    }
    public boolean contains(String username){
        if (registered_users.containsKey(username) || registered_providers.containsKey(username)){
            return true;
        }
        else {return false;}
    }

    public Registration getUserRegistration(String key){
        return registered_users.get(key);
    }
    private void destructor(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Accounts.dat"))) {
            oos.writeObject(registered_users);
            oos.writeObject(registered_providers);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Write the data in a binary file and close it
    }







}
