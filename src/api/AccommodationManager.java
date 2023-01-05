package api;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/** Class AccommodationManager is a Base class that controls all accommodations */
public class AccommodationManager implements Serializable{
    protected HashMap<String,Apartment> apartments;
    protected HashMap<String,Hotel> hotels;
    protected HashMap<String,Maisonette> maisonettes;

    /**
     * Empty Constructor
     * Opens a binary file and reads data from it
     */
    public AccommodationManager() {
        apartments = new HashMap<>();
        hotels = new HashMap<>();
        maisonettes = new HashMap<>();
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("accommodations.dat"))) {
            HashMap<String,Apartment> a =(HashMap<String,Apartment>) oos.readObject();
            HashMap<String,Hotel> h = (HashMap<String,Hotel>) oos.readObject();
            HashMap<String,Maisonette> m =(HashMap<String,Maisonette>) oos.readObject();
            apartments.putAll(a);
            hotels.putAll(h);
            maisonettes.putAll(m);
        } catch (IOException | ClassNotFoundException e) {
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
        if (apartments.get(o+n)!=null) {
            return "Apartment";
        }
        else if (hotels.get(o+n)!=null) {
            return "Hotel";
        }
        else if (maisonettes.get(o+n)!=null) {
            return "Maisonette";
        }
        return null;
    }

    /**
     * Shows all accommodations
     */
    public String showAll() {
        String s="";
        for(Map.Entry<String, Apartment> entry : apartments.entrySet()) {
            s=s+entry.getValue().show()+"\n";}
        for(Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            s=s+entry.getValue().show()+"\n";}
        for(Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
            s=s+entry.getValue().show()+"\n";}
        return s;
    }

    /**
     * Getter for Hotel with a specific owner and name
     * @param owner The owner of the Hotel
     * @param name The name of the Hotel
     * @return The Hotel with a specific owner and name
     */
    public Hotel getHotel(String owner, String name) {
        return hotels.get(owner+name);
    }

    /**
     * Getter for Apartment with a specific owner and name
     * @param owner The owner of the Apartment
     * @param name The name of the Apartment
     * @return The Apartment with a specific owner and name
     */
    public Apartment getApartment(String owner, String name) {
        return apartments.get(owner+name);
    }

    /**
     * Getter for Maisonette with a specific owner and name
     * @param owner The owner of the Maisonette
     * @param name The name of the Maisonette
     * @return The Maisonette with a specific owner and name
     */
    public Maisonette getMaisonette(String owner, String name) {
        return maisonettes.get(owner+name);
    }

    /**
     * Destructor. Writes data in binary file
     */
    public void destructor(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accommodations.dat"))) {
            oos.writeObject(apartments);
            oos.writeObject(hotels);
            oos.writeObject(maisonettes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Write the data in a binary file and close it
    }
}