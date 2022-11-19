package api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *Class Accommodation is a Base class for all types of accommodations with the basic methods and properties of them */
public class Accommodation {
    /** All the variables in accommodation
     *  owner        The owner of the accommodation
     *  description  The description of the accommodation
     *  city         The city where the accommodation is
     *  TK           The Postcode of the accommodation
     *  address      The address of the accommodation
     *  name         The name of the accommodation
     *  ratings      An ArrayList of all the rating of the accommodation
     *  */
    private ArrayList<Rating> ratings;
    private String name,address,TK,city,description,owner;
    //private Properties properties;
    /** Empty Constructor */
    public Accommodation(){ratings=new ArrayList<>();}

    /**
     * Normal Constructor:
     * @param n     The name of the accommodation
     * @param a     The address of the accommodation
     * @param tk    The Postcode of the accommodation
     * @param c     The city where the accommodation is
     * @param desc  The description of the accommodation
     * @param o     The owner of the accommodation
     */
    public Accommodation(String n,String a, String tk,String c,String desc,String o) {
        name=n;
        address=a;
        TK=tk;
        city=c;
        description=desc;
        owner=o;
        ratings=new ArrayList<>();
    }
    /** This method adds a rating to the accommodation
     *  @param desc Description of the rating
     *  @param ra   The grade of the rating (up to 5)
     *  @param user The user tha created the rating
     *  @param date The date the rating was created */
    public void addRating(String desc,float ra,String user,String date){
        Rating r=new Rating(desc,ra,user,date);
        ratings.add(r);
    }

    /**
     * Prints all the information and ratings of the accommodation
     */
    public void show(){
        this.showNR();
        this.showRatings();
    }

    /**
     * Prints all the information without the ratings of the accommodation
     */
    public void showNR(){
        System.out.println("Name:       "+name);
        System.out.println("Address:    "+address);
        System.out.println("TK:         "+TK);
        System.out.println("City:       "+city);
        System.out.println("Description:"+description);
        System.out.println("Owner:      "+owner);
    }

    /**
     * Prints the ratings of the accommodation
     */
    public void showRatings(){
        System.out.println("Ratings:");
        for (Rating t: ratings)
        {
            t.Show();
        }
    }
    /** Getters and Setters for all the variables in the accommodation*/
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

    /** Method that edits the rating of a user (date shows date modified instead of the created)
     * @param o The name of the user/owner of the rating
     * @param d The new description of the rating
     * @param f The new grade of the rating
     */
    public void editRating(String o,String d,float f){
        for (Rating s:ratings)
        {
            String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
            if (s.getUser()==o){s.setRatingDescription(d,s.getDate());
                s.setGrade(f,date);
            }
        }
    }

    /**
     * Method that updates an optional property(All optional properties are set to "none" by default)
     * @param key   The property that will get updated
     * @param value The value that the property will have
     */
    public  void updateProperty(String key,String value){
        //properties.edit(p);
    }

    /**
     * Method that deletes a rating from a user
     * @param o The name of the user/owner of the rating that will get deleted
     */
    public void deleteRating(String o){{for (Rating s:ratings) {if (s.getUser()==o){ratings.remove(s);}}}}
}
