package api;

public class Apartment extends Accommodation{
    private int floor=1,space=2;
    private boolean guard=false,elevator=false;

    public  Apartment(){super();}
    public  Apartment(String n,String a, String tk,String c,String desc,String o,int floor,int space,boolean guard,boolean elevator){
        super(n,a,tk,c,desc,o);
        this.floor=floor;
        this.space=space;
        this.guard=guard;
        this.elevator=elevator;
    }
    public  Apartment(String n,String a, String tk,String c,String desc,String o){
        super(n,a,tk,c,desc,o);
    }

    public boolean isGuard() {
        return guard;
    }

    public void setGuard(boolean guard) {
        this.guard = guard;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    @Override
    public void show() {
        System.out.println("Accommodation Type: Apartment");
        super.showNR();
        System.out.println("Floor:      "+String.valueOf(floor));
        System.out.println("Space:      "+String.valueOf(space));
        System.out.println("Has Guard:  "+String.valueOf(guard));
        System.out.println("Elevator:   "+String.valueOf(elevator));
        super.showRatings();
    }
}
