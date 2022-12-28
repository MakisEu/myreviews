package api;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *Class Accommodation is a Base class for all types of accommodations with the basic methods and properties of them */
public class Accommodation implements Serializable {
    /** All the variables in accommodation
     *  owner        The owner of the accommodation
     *  description  The description of the accommodation
     *  city         The city where the accommodation is
     *  TK           The Postcode of the accommodation
     *  address      The address of the accommodation
     *  name         The name of the accommodation
     *  ratings      An ArrayList of all the rating of the accommodation
     *  properties   An object that contains the option properties of the accommodation
     *  */
    private ArrayList<Rating> ratings;
    protected String name,address,TK,city,description,owner,UID;
    private Properties properties;

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
        properties=new Properties();
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


    public int getRatingNumber(){
        return ratings.size();
    }

    public double getRatingsAverage() {
        double sum = 0;
        for (Rating x : ratings) {
            sum += x.getGrade();
        }
        return (double) sum / ratings.size();
    }

    /**
     * Prints all the information and ratings of the accommodation
     */
    public String show(){
        return (this.showNR()+this.showRatings());
    }

    /**
     * Prints all the information without the ratings of the accommodation
     */
    public String showNR(){
        String x="Name:       "+name+"\n";
        x=x+"Address:    "+address+"\n";
        x=x+"TK:         "+TK+"\n";
        x=x+"City:       "+city+"\n";
        x=x+"Description:"+description+"\n";
        x=x+"Owner:      "+owner+"\n";
        x=x+"Properties:"+"\n";
        x=x+properties.show_properties()+"\n";
        return x;
    }

    /**
     * Prints the ratings of the accommodation
     */
    public String showRatings(){
        String x="Ratings:";
        for (Rating t: ratings)
        {
            x=x+t.Show();
        }
        return x;
    }
    /** Setter for address*/
    public void setName(String i){
        name=i;
        String[] x=UID.split("#");
        UID=x[0]+"#"+x[1]+"#"+name;
    }

    public void setAddress(String i){
        address=i;
    }
    /** Setter for TK*/
    public void setTK(String i){
        TK=i;
    }
    /** Setter for city*/
    public void setCity(String i){
        city=i;
    }
    /** Setter for description*/
    public void setDescription(String i){
        description=i;
    }
    /** Setter for owner*/
    public void setOwner(String i){
        owner=i;
    }
    /** getter for address*/
    public String getAddress() {
        return address;
    }
    /** getter for TK*/
    public String getTK() {
        return TK;
    }
    /** getter for owner*/
    public String getOwner() {
        return owner;
    }
    /** getter for name*/
    public String getName() {
        return name;
    }
    /** getter for city*/
    public String getCity() {
        return city;
    }
    /** getter for description*/
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
            if (s.getUser().equals(o)){s.setRatingDescription(d,s.getDate());
                s.setGrade(f,date);
            }
        }
    }
    /**
     * @param key Name of property
     * @return value of property
     */
    public String getProperty(String key){
        return (this.properties.getProperties(key));
    }

    /**
     * Method that updates an optional property(All optional properties are set to "none" by default)
     * @param key   The property that will get updated
     * @param value The value that the property will have
     */
    public  void updateProperty(String key,String value){
        properties.add_property(key,value);
    }

    /**
     * Method that deletes a rating from a user
     * @param o The name of the user/owner of the rating that will get deleted
     */
    public void deleteRating(String o){{for (Rating s:ratings) {if (s.getUser().equals(o)){ratings.remove(s);return;}}}}
}
