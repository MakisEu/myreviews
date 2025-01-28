package api;
/** Class Apartment is a class for accommodations with type Apartment*/
public class Apartment extends Accommodation{
    /** floor    The floor that the apartment is on
     *  space    The number of people the apartment can house
     *  guard    The apartment has guards
     *  elevator The apartment has elevator
     *  */
    private int floor=1,space=2;
    private boolean guard=false,elevator=false;

    /**Full Constructor
     * @param n     The name of the accommodation
     * @param a     The address of the accommodation
     * @param tk    The Postcode of the accommodation
     * @param c     The city where the accommodation is
     * @param desc  The description of the accommodation
     * @param o     The owner of the accommodation
     * @param floor The floor that the apartment is on
     * @param space The number of people the apartment can house
     * @param guard The apartment has guard
     * @param elevator The apartment has elevator

     */
    public  Apartment(String n,String a, String tk,String c,String desc,String o,int floor,int space,boolean guard,boolean elevator){
        super(n,a,tk,c,desc,o);
        this.floor=floor;
        this.space=space;
        this.guard=guard;
        this.elevator=elevator;
        UID="a#"+o+"#"+n;
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
    public  Apartment(String n,String a, String tk,String c,String desc,String o){
        super(n,a,tk,c,desc,o);
        UID="a#"+o+"#"+n;
    }

    /** Getter for guard*/
    public boolean isGuard() {
        return guard;
    }

    /** Setter for guard*/
    public void setGuard(boolean guard) {
        this.guard = guard;
    }
    /** Getter for elevator*/
    public boolean isElevator() {
        return elevator;
    }
    /** Setter for elevator*/
    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }
    /** Getter for floor*/
    public int getFloor() {
        return floor;
    }
    /** Setter for floor*/
    public void setFloor(int floor) {
        this.floor = floor;
    }
    /** Getter for space*/
    public int getSpace() {
        return space;
    }
    /** Setter for space*/
    public void setSpace(int space) {
        this.space = space;
    }

    /**
     * Prints all the information and ratings of the apartment
     */
    @Override
    public String show() {

        String x="Accommodation Type: Apartment"+"\n";
        x=x+"UID:"+UID+"\n";
        x=x+super.showNR()+"\n";
        x=x+"Floor:      "+ floor +"\n";
        x=x+"Space:      "+ space +"\n";
        x=x+"Has Guard:  "+ guard +"\n";
        x=x+"Elevator:   "+ elevator +"\n";
        x=x+super.showRatings()+"\n";
        return x;
    }
}
