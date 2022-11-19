package api;

public class Maisonette extends  Accommodation{
    private int roommates=0;
    public  Maisonette(){super();}
    public  Maisonette(String n,String a, String tk,String c,String desc,String o,int rm){
        super(n,a,tk,c,desc,o);
        roommates=rm;
    }
    public  Maisonette(String n,String a, String tk,String c,String desc,String o){
        super(n,a,tk,c,desc,o);
    }

    public int getRoommates() {
        return roommates;
    }

    public void setRoommates(int roommates) {
        this.roommates = roommates;
    }

    @Override
    public void show() {
        System.out.println("Accommodation Type: Maisonette");
        super.showNR();
        System.out.println("Roommates:      "+String.valueOf(roommates));
        super.showRatings();
    }
}
