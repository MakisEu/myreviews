package api;

import java.io.Serializable;

/** Class Maisonette is a class for accommodations with type Maisonette*/
public class Maisonette extends  Accommodation {
    /**
     * roommates The number of roommates on the maisonette
     */
    private int roommates=0;

    /**
     * Empty Constructor
     */
    public  Maisonette(){super();}

    /**Full Constructor
     * @param n     The name of the accommodation
     * @param a     The address of the accommodation
     * @param tk    The Postcode of the accommodation
     * @param c     The city where the accommodation is
     * @param desc  The description of the accommodation
     * @param o     The owner of the accommodation
     * @param rm    The number of roommates in the accommodation
     */
    public  Maisonette(String n,String a, String tk,String c,String desc,String o,int rm){
        super(n,a,tk,c,desc,o);
        roommates=rm;
    }

    /**
     * Normal Constructor with only required parameters
     * @param n     The name of the accommodation
     * @param a     The address of the accommodation
     * @param tk    The Postcode of the accommodation
     * @param c     The city where the accommodation is
     * @param desc  The description of the accommodation
     * @param o     The owner of the accommodation
     */
    public  Maisonette(String n,String a, String tk,String c,String desc,String o){
        super(n,a,tk,c,desc,o);
    }

    /**
     * Getter for roommates
     */
    public int getRoommates() {
        return roommates;
    }

    /**
     * Setter for roommates
     */
    public void setRoommates(int roommates) {
        this.roommates = roommates;
    }

    /** Prints all the information and ratings of the maisonette */
    @Override
    public void show() {
        System.out.println("Accommodation Type: Μεζονέτα");
        super.showNR();
        System.out.println("Roommates:      "+String.valueOf(roommates));
        super.showRatings();
    }
}
