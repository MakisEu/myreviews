package api;

/** Class Maisonette is a class for accommodations with type Maisonette*/
public class Maisonette extends  Accommodation {
    /**
     * roommates The number of roommates on the maisonette
     */
    private int roommates=0;

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
        UID="m#"+o+"#"+n;
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
        UID="m#"+o+"#"+n;

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
    public String show() {
        String x="Accommodation Type: Maisonette"+"\n";
        x=x+"UID:"+UID+"\n";
        x=x+super.showNR();
        x=x+"Roommates:      "+ roommates +"\n";
        x=x+super.showRatings()+"\n";
        return x;
    }
}
