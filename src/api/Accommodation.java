package api;

import java.util.ArrayList;
/**
 *Class Accommodation is a Base class for all types of accommodations with the basic methods and properties of them
 * */
public class Accommodation {
    private ArrayList<Rating> ratings;
    private String name,address,TK,city,description,owner;
    //private Properties properties;
    public Accommodation(){ratings=new ArrayList<>();}
    public Accommodation(String n,String a, String tk,String c,String desc,String o) {
        name=n;
        address=a;
        TK=tk;
        city=c;
        description=desc;
        owner=o;
        ratings=new ArrayList<>();
    }
    public void addRating(String desc,float ra,String user){
        Rating r=new Rating(desc,ra,user,"19/11/2022");
        ratings.add(r);
    }
    public void show(){
        System.out.println("Name:       "+name);
        System.out.println("Address:    "+address);
        System.out.println("TK:         "+TK);
        System.out.println("City:       "+city);
        System.out.println("Description:"+description);
        System.out.println("Owner:      "+owner);
        this.showRatings();
    }
    public void showNR(){
        System.out.println("Name:       "+name);
        System.out.println("Address:    "+address);
        System.out.println("TK:         "+TK);
        System.out.println("City:       "+city);
        System.out.println("Description:"+description);
        System.out.println("Owner:      "+owner);
    }
    public void showRatings(){
        System.out.println("Ratings:");
        for (Rating t: ratings)
        {
            //t.show();
        }
    }
    public void setAddress(String i){
        address=i;
    }
    public void setTK(String i){
        TK=i;
    }
    public void setCity(String i){
        city=i;
    }
    public void setDescription(String i){
        description=i;
    }
    public void setOwner(String i){
        owner=i;
    }

    public String getAddress() {
        return address;
    }

    public String getTK() {
        return TK;
    }

    public String getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }
    public void editRating(String o,String d,float f){
        for (Rating s:ratings)
        {
            if (s.getRatingDescription()==o){s.setRatingDescription(d,s.getDate());
                s.setGrade(f,s.getDate());
            }

        }
    }
    public  void setProperties(String[] p){
        //properties.edit(p);
    }
}
