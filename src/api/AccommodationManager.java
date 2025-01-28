package api;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/** Class AccommodationManager is a Base class that controls all accommodations */
public class AccommodationManager implements Serializable{
    protected static ArrayList<String> types;
    protected HashMap<String,HashMap<String,Accommodation>> accommodations;

    /**
     * Empty Constructor
     * Opens a binary file and reads data from it
     */
    public AccommodationManager() {
        accommodations =new HashMap<>();
        types=new ArrayList<>();
        types.add("Apartment");
        types.add("Hotel");
        types.add("Maisonette");

        accommodations.put("Hotel",new HashMap<>());
        accommodations.put("Apartment",new HashMap<>());
        accommodations.put("Maisonette",new HashMap<>());
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("Database/accommodations.dat"))) {
            HashMap<String,Accommodation> a =(HashMap<String,Accommodation>) oos.readObject();
            HashMap<String,Accommodation> h = (HashMap<String,Accommodation>) oos.readObject();
            HashMap<String,Accommodation> m =(HashMap<String,Accommodation>) oos.readObject();
            accommodations.get("Apartment").putAll(a);
            accommodations.get("Hotel").putAll(h);
            accommodations.get("Maisonette").putAll(m);
        } catch (NullPointerException |IOException | ClassNotFoundException e) {
            //e.printStackTrace();
        }
        //read data from binary file
    }

    /**
     * Returns type of accommodation
     * @param o Owner of the apartment
     * @param n Name of the apartment
     * @return The type of the accommodation
     */
    public String getType(String o, String n) {
        for (String s: accommodations.keySet()){
            if (accommodations.get(s).get(o+n)!=null){
                return s;
            }
        }
        return null;
    }

    /**
     * Shows all accommodations
     */
    public String showAll() {
        StringBuilder s= new StringBuilder();
        for (String type:accommodations.keySet()) {
            for (String key : accommodations.get(type).keySet()) {
                s.append(accommodations.get(type).get(key).show()).append("\n");
            }
        }
        return s.toString();
    }

    /**
     * Getter for Hotel with a specific owner and name
     * @param owner The owner of the Hotel
     * @param name The name of the Hotel
     * @return The Hotel with a specific owner and name
     */
    public Hotel getHotel(String owner, String name) {
        return (Hotel)accommodations.get("Hotel").get(owner+name);
    }

    /**
     * Getter for Apartment with a specific owner and name
     * @param owner The owner of the Apartment
     * @param name The name of the Apartment
     * @return The Apartment with a specific owner and name
     */
    public Apartment getApartment(String owner, String name) {
        return (Apartment) accommodations.get("Apartment").get(owner+name);
    }

    /**
     * Getter for Maisonette with a specific owner and name
     * @param owner The owner of the Maisonette
     * @param name The name of the Maisonette
     * @return The Maisonette with a specific owner and name
     */
    public Maisonette getMaisonette(String owner, String name) {
        return (Maisonette) accommodations.get("Maisonette").get(owner+name);
    }

    /**
     * Destructor. Writes data in binary file
     */
    public void destructor(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Database/accommodations.dat"))) {
            oos.writeObject(accommodations.get("Apartment"));
            oos.writeObject(accommodations.get("Hotel"));
            oos.writeObject(accommodations.get("Maisonette"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Write the data in a binary file and close it
    }
}