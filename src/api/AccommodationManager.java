package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** Class AccommodationManager is a Base class that controls all accommodations */
public class AccommodationManager {
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
            return "Διαμέρισμα";
        }
        else if (hotels.get(o+n)!=null) {
            return "Ξενοδοχείο";
        }
        else if (maisonettes.get(o+n)!=null) {
            return "Μεζονέτα";
        }
        return null;
    }

    /**
     * Shows all accommodations
     */
    public void showAll() {
        for(Map.Entry<String, Apartment> entry : apartments.entrySet()) {
            entry.getValue().show();}
        for(Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            entry.getValue().show();}
        for(Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
            entry.getValue().show();}
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
    //ALL methods below(Except the destructor) are here temporarily to run tests until the constructor reads from files
    public String addAccommodation(String type, String n, String a, String tk, String c, String desc, String o) {
        if (type == "Ξενοδοχείο") {
            Hotel h = new Hotel(n, a, tk, c, desc, o);
            hotels.put(o+n,h);
            return "Added successfully";
        } else if (type == "Διαμέρισμα") {
            Apartment ap = new Apartment(n, a, tk, c, desc, o);
            apartments.put(o+n,ap);
            return "Added successfully";
        } else if (type == "Μεζονέτα") {
            Maisonette h = new Maisonette(n, a, tk, c, desc, o);
            maisonettes.put(o+n,h);
            return "Added successfully";
        } else {
            return "Incorrect type. Addition failed.";
        }
    }
    public void editHotel(String owner, String name, int star, int floor, boolean suite) {
        if (hotels.get(owner + name) != null) {
            hotels.get(owner + name).setFloors(floor);
            hotels.get(owner + name).setStars(star);
            hotels.get(owner + name).setHasSuite(suite);
        }
    }
    public void editApartment(String owner, String name, int floor, int space, boolean guard, boolean elevator) {
        if (apartments.get(owner + name) != null) {
            apartments.get(owner + name).setSpace(space);
            apartments.get(owner + name).setElevator(elevator);
            apartments.get(owner + name).setFloor(floor);
            apartments.get(owner + name).setGuard(guard);
        }
    }
    public void editMaisonette(String owner, String name, int rm) {
        if (maisonettes.get(owner + name) != null) {
            maisonettes.get(owner + name).setRoommates(rm);
        }
    }
    public void updateProperty(String o, String n, String key, String val) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο") {
            if (hotels.get(o + n) != null) {
                hotels.get(o + n).updateProperty(key, val);}}
        else if (type == "Διαμέρισμα") {
            if (apartments.get(o + n) != null) {
                apartments.get(o + n).updateProperty(key, val);}}
        else if (type == "Μεζονέτα") {
            if (maisonettes.get(o + n) != null) {
                maisonettes.get(o + n).updateProperty(key, val);}}
    }

    public void deleteAccommodation(String owner, String name) {
        String type = this.getType(owner, name);
        if (type == "Ξενοδοχείο") {
            hotels.remove(owner+name);
            return;}
        else if (type == "Διαμέρισμα") {
            apartments.remove(owner+name);
            return;}
        else if (type == "Μεζονέτα") {
            maisonettes.remove(owner+name);
            return;}
    }
    public void showOwned(String owner) {
        for(Map.Entry<String, Apartment> entry : apartments.entrySet()) {
            Apartment value=entry.getValue();
            if (value.getOwner() == owner) {
                value.show();}}
        for(Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            Hotel value=entry.getValue();
            if (value.getOwner() == owner) {
                value.show();}}
        for(Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
            Maisonette value=entry.getValue();
            if (value.getOwner() == owner) {
                value.show();}}
    }
    public void setDescription(String o,String n,String desc) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setDescription(desc);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setDescription(desc);
        else {
            this.getMaisonette(o, n).setDescription(desc);}
    }
    public void setName(String o,String n,String name) {
        String type = this.getType(o, n);


        if (type == "Ξενοδοχείο"){
            Hotel p=hotels.get(o+n);
            Hotel h=new Hotel(name,p.getAddress(),p.getTK(),p.getCity(),p.getDescription(),p.getOwner(),p.getStars(),p.getFloors(),p.isHasSuite());
            hotels.remove(o+n);
            hotels.put(o+name,h);
        }
        else if (type == "Διαμέρισμα"){
            Apartment p=apartments.get(o+n);
            Apartment h=new Apartment(name,p.getAddress(),p.getTK(),p.getCity(),p.getDescription(),p.getOwner(),p.getFloor(),p.getSpace(),p.isGuard(),p.isElevator());
            apartments.remove(o+n);
            apartments.put(o+name,h);
        }
        else {
            Maisonette p=maisonettes.get(o+n);
            Maisonette h=new Maisonette(name,p.getAddress(),p.getTK(),p.getCity(),p.getDescription(),p.getOwner(),p.getRoommates());
            maisonettes.remove(o+n);
            maisonettes.put(o+name,h);
        }
    }
    public void setTK(String o,String n,String tk) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setTK(tk);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setTK(tk);
        else {
            this.getMaisonette(o, n).setTK(tk);}
    }
    public void setCity(String o,String n,String c) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setCity(c);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setCity(c);
        else {
            this.getMaisonette(o, n).setCity(c);
        }
    }
    public void setAddress(String o,String n,String a) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setAddress(a);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setAddress(a);
        else {
            this.getMaisonette(o, n).setAddress(a);
        }
    }

    /**
     * Destructor. Writes data in binary file
     */
    public void destructor(){
        //Write the data in a binary file and close it
    }
}