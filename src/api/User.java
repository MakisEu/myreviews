package api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User extends UserSub{
    /**
     * Normal constructor:
     * @param n The name
     * @param u The username
     */
    public User(String u,String n){
        super(u,n);}


    /**
     * Getter for the name
     * @return The name
     */
    public String getName(){
        return name;
    }

    public String getUsername(){
        return username;
    }

    /**
     * Method to add a rating
     * @param on The uid (type#owner#name)
     * @param rating The description of the rating
     * @param score The grade of the rating
     * @return true or false depends on if the rating is added successfully or not
     */
    public int AddRating(String on,String rating,float score){
        int q;
        String[] x=on.split("#");
        String type=new Helper().getTitle(x[0]);
        q=amu.addRating(x[1],x[2],rating,score,username,new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()),name,type);
        return q;
    }

    /**
     * Getter for the Apartment with specific owner and name
     * @param o The owner of the apartment
     * @param n The name of the apartment
     * @return The apartment with this name and owner
     */
   public Apartment getApartment(String o,String n)  {
       return amu.getApartment(o,n);
   }

    /**
     *Getter for the Hotel with specific owner and name
     * @param o The owner of the hotel
     * @param n The name of the hotel
     * @return The hotel with this name and owner
     */
    public Hotel getHotel(String o,String n)  {
        return amu.getHotel(o,n);
    }

    /**
     * Getter for the Maisonette with specific owner and name
     * @param o The owner of the maisonette
     * @param n The owner of the maisonette
     * @return  The maisonette with this name and owner
     */
    public Maisonette getMaisonette(String o,String n)  {
        return amu.getMaisonette(o,n);
    }


    /**
     * Method to edit a rating
     * @param on The uid (type#owner#name)
     * @param rating The description of the rating
     * @param score The grade of the rating
     * @return true or false depends on if the rating is edited successfully or not
     */
    public int EditRating(String on,String rating,float score){
        int q;
        String[] x=on.split("#");
        String type=new Helper().getTitle(x[0]);
        q=amu.editRatings(x[1],x[2],rating,score,username,type);
        return q;
    }
    public int DeleteRating(String on){
        int q;
        String[] x=on.split("#");
        String type=new Helper().getTitle(x[0]);
        q=amu.deleteRating(x[1],x[2],username,type);
        return q;
    }

    /**
     * Method that finds and returns all ratings a user has added
     * @return A string array that contains all the ratings of a user
     */
    public String[] allRatings(){
        String[] all;
        all=amu.allRatings(username);
        return all;
    }

    /**
     * Method that returns a users average ratings based on grade
     * username The username of the user
     * @return The double average
     */
    public double getMean(){
        return amu.getMean(username);
    }

    /**
     * Destructor
     */
    public void destructor(){
        amu.destructor();
    }

}