package api;

import java.io.Serializable;

/** Class Hotel is a class for accommodations with type Hotel*/
public class Hotel extends  Accommodation implements Serializable {
    /** stars    The stars that the hotel has
     *  floors   The number of floors the hotel has
     *  hasSuite The hotel has suite
     *  */
    private int stars=0,floors=1;
    private  boolean hasSuite=false;
    /**
     * Empty Constructor
     */
    public  Hotel(){super();}

    /**Full Constructor
     * @param n     The name of the accommodation
     * @param a     The address of the accommodation
     * @param tk    The Postcode of the accommodation
     * @param c     The city where the accommodation is
     * @param desc  The description of the accommodation
     * @param o     The owner of the accommodation
     * @param star  The stars the hotel has
     * @param floor The floors the hotel has
     * @param suite The hotel has suite
     */
    public  Hotel(String n,String a, String tk,String c,String desc,String o,int star,int floor,boolean suite){
        super(n,a,tk,c,desc,o);
        stars=star;
        floors=floor;
        hasSuite=suite;
        UID="h#"+o+"#"+n;
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
    public  Hotel(String n,String a, String tk,String c,String desc,String o){
        super(n,a,tk,c,desc,o);
        UID="h#"+o+"#"+n;
    }
    /** Getter for stars*/
    public int getStars() {
        return stars;
    }
    /** Getter for floors*/
    public int getFloors() {
        return floors;
    }
    /** Getter for hasSuite*/
    public boolean isHasSuite() {
        return hasSuite;
    }
    /** Setter for stars*/
    public void setStars(int stars) {
        this.stars = stars;
    }
    /** Setter for floors*/
    public void setFloors(int floors) {
        this.floors = floors;
    }
    /** Setter for hasSuite*/
    public void setHasSuite(boolean hasSuite) {
        this.hasSuite = hasSuite;
    }
    /**
     * Prints all the information and ratings of the hotel
     */
    @Override
    public String show() {
        String x="Accommodation Type: Hotel"+"\n";
        x=x+"UID:"+UID+"\n";
        x=x+super.showNR()+"\n";
        x=x+"Stars:      "+String.valueOf(stars)+"\n";
        x=x+"floors:     "+String.valueOf(floors)+"\n";
        x=x+"Has Suite:  "+String.valueOf(hasSuite)+"\n";
        x=x+super.showRatings()+"\n";
        return x;
    }
}
