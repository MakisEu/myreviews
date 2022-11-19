package api;

public class Hotel extends  Accommodation{
    private int stars=0,floors=1;
    private  boolean hasSuite=false;
    public  Hotel(){super();}
    public  Hotel(String n,String a, String tk,String c,String desc,String o,int star,int floor,boolean suite){
        super(n,a,tk,c,desc,o);
        stars=star;
        floors=floor;
        hasSuite=suite;
    }
    public  Hotel(String n,String a, String tk,String c,String desc,String o){
        super(n,a,tk,c,desc,o);
    }
    public int getStars() {
        return stars;
    }

    public int getFloors() {
        return floors;
    }

    public boolean isHasSuite() {
        return hasSuite;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public void setHasSuite(boolean hasSuite) {
        this.hasSuite = hasSuite;
    }

    @Override
    public void show() {
        System.out.println("Accommodation Type: Hotel");
        super.showNR();
        System.out.println("Stars:      "+String.valueOf(stars));
        System.out.println("floors:     "+String.valueOf(floors));
        System.out.println("Has Suite:  "+String.valueOf(hasSuite));
        super.showRatings();
    }
}
