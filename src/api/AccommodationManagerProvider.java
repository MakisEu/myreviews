package api;

/** Class AccommodationManagerProvider is a class that provides all the functionalities of a provider*/
public class AccommodationManagerProvider extends AccommodationManagerProviderSub{
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
        switch (type) {
            case "Hotel": {
                Hotel h = new Hotel(n, a, tk, c, desc, o);
                accommodations.get(type).put(o + n, h);
                return "Added successfully";
            }
            case "Apartment":
                Apartment ap = new Apartment(n, a, tk, c, desc, o);
                accommodations.get(type).put(o + n, ap);
                return "Added successfully";
            case "Maisonette": {
                Maisonette h = new Maisonette(n, a, tk, c, desc, o);
                accommodations.get(type).put(o + n, h);
                return "Added successfully";
            }
            default:
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
        if (accommodations.get("Hotel").get(owner + name) != null) {
            Hotel h=(Hotel) accommodations.get("Hotel").get(owner + name);
            h.setFloors(floor);
            h.setStars(star);
            h.setHasSuite(suite);
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
        if (accommodations.get("Apartment").get(owner + name) != null) {
            Apartment a=(Apartment) accommodations.get("Apartment").get(owner + name);
            a.setSpace(space);
            a.setElevator(elevator);
            a.setFloor(floor);
            a.setGuard(guard);
        }
    }

    /**
     * Method that edits the unique attributes of a Maisonette
     * @param owner The owner of the Maisonette
     * @param name  The name of the Maisonette
     * @param rm    The number of roommates in the Maisonette
     */
    public void editMaisonette(String owner, String name, int rm) {
        if (accommodations.get("Maisonette").get(owner + name) != null) {
            ((Maisonette)accommodations.get("Maisonette").get(owner + name)).setRoommates(rm);
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
        if (accommodations.get(type).get(o+n)!=null){
            accommodations.get(type).get(o+n).updateProperty(key,val);
        }
    }

    /**
     * Method that deletes a specified accommodation
     * @param owner The owner of the accommodation
     * @param name  The name of the accommodation
     */
    public void deleteAccommodation(String owner, String name,String type) {
        accommodations.get(type).remove(owner+name);
    }
    /**
     * Setter for the name of a specified accommodation
     * @param o The owner of the accommodation
     * @param n The old name of the accommodation
     * @param name The new name of the accommodation
     */
    public void setName(String o,String n,String name) {
        String type = this.getType(o, n);
        Accommodation a=accommodations.get(type).get(o+n);
        a.setName(name);
        accommodations.get(type).remove(o+n);
        accommodations.get(type).put(o+name,a);

    }








}
