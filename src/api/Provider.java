package api;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Provider {
    //private ArrayList<Accommodation> accommodations;
    /** All the variables in Provider class:
     * owner The owner of an accommodation
     * first_name The first name of a provider
     */
    private AccommodationManagerProvider amp;
    String owner,first_name;


    /**
     * Normal constructor:
     * @param owner owner of the accommodation
     * @param fn first name of the Provider
     */
    public Provider(String owner,String fn){
        amp=new AccommodationManagerProvider();this.owner=owner;this.first_name=fn;
    }

    /**
     * Method that adds Accommodations of a provider based on the type of it and on who is the owner
     * @param t The type of the accommodation displayed as "h" for Hotel ,"a" for Apartment,"m" for maisonette
     * @param n  The name of the accommodation
     * @param a  The address of the accommodation
     * @param tk The postal code of the accommodation
     * @param c  The city of the accommodation
     * @param desc The description of the accommodation
     */
     public boolean addAccommodation(String t, String n, String a, String tk, String c, String desc){
        String type;
         switch (t) {
             case "h":
                 type = "Hotel";
                 break;
             case "a":
                 type = "Apartment";
                 break;
             case "m":
                 type = "Maisonette";
                 break;
             default:
                 return false;
         }
        amp.addAccommodation(type,n,a,tk,c,desc,owner);
        return true;
    }
    /*public  void updateProperties(Accommodation acc,String[] pr){
        if(pr.length<1){
        for (String pro:pr){
            String[] keyval=pro.split("-");
            acc.updateProperty(keyval[0],keyval[1]);
        }
        }
    }*/

    /**
     * This method edits accommodations based on the parameters it takes
     * @param type The type of the accommodation
     * @param n  The name of the accommodation
     * @param a  The address of the accommodation
     * @param tk The postal code of the accommodation
     * @param c  The city of the accommodation
     * @param desc The description of the accommodation
     * @param oln The old name of the accommodation
     */
    public boolean editAccommodation(String type, String n, String a, String tk, String c, String desc,String oln,String[] pr){

        switch (type) {
            case "a": {
                Apartment acc = amp.getApartment(owner, oln);
                if (n.length() >= 1) {
                    amp.setName(owner,oln,n);
                }
                if (a.length() >= 1) {
                    acc.setAddress(a);
                }
                if (tk.length() >= 1) {
                    acc.setTK(tk);
                }
                if (c.length() >= 1) {
                    acc.setCity(c);
                }
                if (desc.length() >= 1) {
                    acc.setDescription(desc);
                }
                new Helper().updateProperties(acc, pr);
                break;
            }
            case "h": {
                Hotel acc = amp.getHotel(owner, oln);
                if (n.length() >= 1) {
                    amp.setName(owner,oln,n);
                }
                if (a.length() >= 1) {
                    acc.setAddress(a);
                }
                if (tk.length() >= 1) {
                    acc.setTK(tk);
                }
                if (c.length() >= 1) {
                    acc.setCity(c);
                }
                if (desc.length() >= 1) {
                    acc.setDescription(desc);
                }
                new Helper().updateProperties(acc, pr);
                break;
            }
            case "m": {
                Maisonette acc = amp.getMaisonette(owner, oln);
                if (n.length() >= 1) {
                    amp.setName(owner,oln,n);
                }
                if (a.length() >= 1) {
                    acc.setAddress(a);
                }
                if (tk.length() >= 1) {
                    acc.setTK(tk);
                }
                if (c.length() >= 1) {
                    acc.setCity(c);
                }
                if (desc.length() >= 1) {
                    acc.setDescription(desc);
                }
                new Helper().updateProperties(acc, pr);
                break;
            }
        }
        return true;
    }

    /**
     * This method returns all the ratings a provider has received from all his accommodations available
     * @return All ratings an owner has received
     */
    public int getAllRatingsNumber(){
        return amp.getRatingsNumber(owner);
    }

    /**
     *This method returns the average of the grades that users gave to the accommodations of an owner
     * @return Average of all the grades
     */
    public double getAllAccommodationsGrades(){
        return amp.getRatingAverage(owner);
    }

    /**
     * This method returns all the accommodation owned by a provider
     * @return A string with all the accommodations owned
     */
    public String showOwned(){
        return amp.showOwned(owner);
    }         //here

    /**
     * Method that deletes an accommodation
     * @param n Name of the accommodation
     * @param type Type of the accommodation
     */
    public void deleteAccommodation(String n,String type){
        amp.deleteAccommodation(owner,n,new Helper().getTitle(type));
    }

    /**
     * Getter for the apartment
     * @param n Name of the accommodation
     * @return An apartment with the given name and owner
     */
    public Apartment getApartment(String n){
        return amp.getApartment(owner,n);
    }

    /**
     * Getter for the Hotel
     * @param n Name of the accommodation
     * @return A hotel with the given name and owner
     */
    public Hotel getHotel(String n){
        return amp.getHotel(owner,n);
    }

    /**
     * Getter for the maisonette
     * @param n Name of the accommodation
     * @return A maisonette with the given name and owner
     */
    public Maisonette getMaisonette(String n){
        return amp.getMaisonette(owner,n);
    }

    /**
     * Destructor
     * @throws FileNotFoundException
     */
    public void destructor() throws FileNotFoundException {
        amp.destructor();
    }

    /**
     * Method that finds all the accommodations owned by a provider and put them into a String array
     * @return A string[] which contains the names and types (in form name#type#city#RatingsAverage) of the accommodations a provider offers
     */
    public String[] getNames(){
        ArrayList<String> nam=new ArrayList<>();
        ArrayList<Apartment> ap=amp.getOwnedApartments(owner);
        ArrayList<Hotel> ho=amp.getOwnedHotels(owner);
        ArrayList<Maisonette> ma=amp.getOwnedMaisonettes(owner);
        for (Apartment a:ap){
            nam.add(a.getName()+"#Apartment#"+a.getCity()+"#"+a.getRatingsAverage());
        }
        for (Hotel a:ho){
            nam.add(a.getName()+"#Hotel#"+a.getCity()+"#"+a.getRatingsAverage());
        }
        for (Maisonette a:ma){
            nam.add(a.getName()+"#Maisonette#"+a.getCity()+"#"+a.getRatingsAverage());
        }
        return nam.toArray(new String[0]);

    }

}
