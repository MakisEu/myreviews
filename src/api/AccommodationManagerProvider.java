package api;

import java.util.Map;

/** Class AccommodationManagerProvider is a class that provides all the functionalities of a provider*/
public class AccommodationManagerProvider extends AccommodationManager{
    /**
     * Empty constructor. Calls inherited constructor
     */
    public AccommodationManagerProvider(){
        super();
    }

    /**
     * Method that adds accommodation to AccommodationManager
     * @param type The type of the accommodation
     * @param n    The name of the accommodation
     * @param a    The address of the accommodation
     * @param tk   The postal code of the accommodation
     * @param c    The city of the accommodation
     * @param desc The description of the accommodation
     * @param o    The owner of the accommodation
     * @return The result of the addition (If accommodation with the same name and owner exists, replaces it)
     */
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

    /**
     * Method that edits the unique attributes of a Hotel
     * @param owner The owner of the Hotel
     * @param name  The name of the Hotel
     * @param star  The stars of the Hotel
     * @param floor The floors of the Hotel
     * @param suite The Hotel has suite
     */
    public void editHotel(String owner, String name, int star, int floor, boolean suite) {
        if (hotels.get(owner + name) != null) {
            hotels.get(owner + name).setFloors(floor);
            hotels.get(owner + name).setStars(star);
            hotels.get(owner + name).setHasSuite(suite);
        }
    }

    /**
     * Method that edits the unique attributes of an Apartment
     * @param owner The owner of the Apartment
     * @param name  The name of the Apartment
     * @param floor The floors of the Apartment
     * @param space The number of people the Apartment can house
     * @param guard The Apartment has guards
     * @param elevator The Apartment has elevator
     */
    public void editApartment(String owner, String name, int floor, int space, boolean guard, boolean elevator) {
        if (apartments.get(owner + name) != null) {
            apartments.get(owner + name).setSpace(space);
            apartments.get(owner + name).setElevator(elevator);
            apartments.get(owner + name).setFloor(floor);
            apartments.get(owner + name).setGuard(guard);
        }
    }

    /**
     * Method that edits the unique attributes of a Maisonette
     * @param owner The owner of the Maisonette
     * @param name  The name of the Maisonette
     * @param rm    The number of roommates in the Maisonette
     */
    public void editMaisonette(String owner, String name, int rm) {
        if (maisonettes.get(owner + name) != null) {
            maisonettes.get(owner + name).setRoommates(rm);
        }
    }

    /**
     * Method that updates an optional property of a specific accommodation
     * @param o The owner of the accommodation
     * @param n The name of the accommodation
     * @param key The property of the accommodation tha gets updated
     * @param val the new value of the property
     */
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

    /**
     * Method that deletes a specified accommodation
     * @param owner The owner of the accommodation
     * @param name  The name of the accommodation
     */
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

    /**
     * Method that shows all accommodation owned by an owner
     * @param owner The owner
     */
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

    /**
     * Setter for the description of a specified accommodation
     * @param o The owner of the accommodation
     * @param n The name of the accommodation
     * @param desc The new description of the accommodation
     */
    public void setDescription(String o,String n,String desc) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setDescription(desc);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setDescription(desc);
        else {
            this.getMaisonette(o, n).setDescription(desc);}
    }

    /**
     * Setter for the name of a specified accommodation
     * @param o The owner of the accommodation
     * @param n The old name of the accommodation
     * @param name The new name of the accommodation
     */
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

    /**
     * Setter for the postal code of a specified accommodation
     * @param o The owner of the accommodation
     * @param n The name of the accommodation
     * @param tk The postal code of the accommodation
     */
    public void setTK(String o,String n,String tk) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο")
            this.getHotel(o, n).setTK(tk);
        else if (type == "Διαμέρισμα")
            this.getApartment(o, n).setTK(tk);
        else {
            this.getMaisonette(o, n).setTK(tk);}
    }

    /**
     * Setter for the postal code of a specified accommodation
     * @param o The owner of the accommodation
     * @param n The name of the accommodation
     * @param c The city of the accommodation
     */
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

    /**
     * Setter for the address of a specified accommodation
     * @param o The owner of the accommodation
     * @param n The name of the accommodation
     * @param a The address of the accommodation
     */
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
}
