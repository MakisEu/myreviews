package api;

import gui.AccommodationManagerUserGui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

public class User {

    /**
     * All the Variables in the User class:
     * amu              AccommodationManagerUser object
     * name             The name of a user
     * username         The username of a user
     */
    AccommodationManagerUser amu;
    String name,username;

    /**
     * Normal constructor:
     * @param n The name
     * @param u The username
     */
    public User(String n,String u){
        name=n;
        username=u;
        amu=new AccommodationManagerUser();
    }

    /**
     * Getter for the name
     * @return The name
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for the username
     * @return The username
     */
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
    public boolean AddRating(String on,String rating,float score){
        boolean bool=false;
        String[] x=on.split("#");
        String type=new Helper().getTitle(x[0]);
        bool=amu.addRating(x[1],x[2],rating,score,username,new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()),name,type);
        return bool;
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
    public boolean EditRating(String on,String rating,float score){
        boolean bool=false;
        String[] x=on.split("#");
        String type=new Helper().getTitle(x[0]);
        bool=amu.editRatings(x[1],x[2],rating,score,username,type);
        return bool;
    }

    /**
     * Method to delete a rating
     * @param on The uid (type#owner#name)
     * @return true or false depends on if the rating is deleted successfully or not
     */
    public boolean DeleteRating(String on){
        boolean bool;
        String[] x=on.split("#");
        String type=new Helper().getTitle(x[0]);
        bool=amu.deleteRating(x[1],x[2],username,type);
        return bool;
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
     * @param username The username of the user
     * @return The double average
     */
    public double getMean(String username){
        return amu.getMean(username);
    }

    /**
     * Method that Searches and returns all the accommodations with same characteristics with the parameters
     * @param city The city of the accommodation
     * @param type The type of the accommodation
     * @param name The name of the accommodation
     * @param prop The properties of the accommodation
     * @return A string array with the accommodations with the preferred characteristic
     */
    public String[] Search(String city,String type,String name,String[] prop){
        String[][] temp = new String[0][];
        String[] t;
        HashSet<String> aMain=null;
        HashSet<String> hMain=null;
        HashSet<String> mMain=null;
        if(city.length()>1){
            aMain=new HashSet<>();
            hMain=new HashSet<>();
            mMain=new HashSet<>();
            temp=amu.findLocation(city);
            for (String s:temp[0]){
                if (s!=null)
                aMain.add(s);
            }
            for (String s:temp[1]){
                if (s!=null)
                hMain.add(s);
            }
            for (String s:temp[2]){
                if (s!=null)
                mMain.add(s);
            }
        }
        if(prop[0].length()>2){
            String[] a1=new String[prop.length],a2=new String[prop.length];
            int c=0;
            for (String s: prop){
                a1[c]=s.split("-")[0];
                a2[c]=s.split("-")[1];
                c++;
            }
            temp= amu.findProperties(a1,a2);
            if (aMain!=null){
            HashSet<String> aSub=new HashSet<>();
            HashSet<String> hSub=new HashSet<>();
            HashSet<String> mSub=new HashSet<>();
            for (String s:temp[0]){
                if (s!=null)
                aSub.add(s);
            }
            for (String s:temp[1]){
                if (s!=null)
                hSub.add(s);
            }
            for (String s:temp[2]){
                if (s!=null)
                mSub.add(s);
            }
            aMain.retainAll(aSub);
            hMain.retainAll(hSub);
            mMain.retainAll(mSub);}
            else{
                aMain=new HashSet<>();
                hMain=new HashSet<>();
                mMain=new HashSet<>();
                for (String s:temp[0]){
                    if (s!=null)
                    aMain.add(s);
                }
                for (String s:temp[1]){
                    if (s!=null)
                    hMain.add(s);
                }
                for (String s:temp[2]){
                    if (s!=null)
                    mMain.add(s);
                }
            }
        }
        if(name.length()>1){
            temp= amu.findName(name);
            if (aMain!=null){
                HashSet<String> aSub=new HashSet<>();
                HashSet<String> hSub=new HashSet<>();
                HashSet<String> mSub=new HashSet<>();
                for (String s:temp[0]){
                    if (s!=null)
                    aSub.add(s);
                }
                for (String s:temp[1]){
                    if (s!=null)
                    hSub.add(s);
                }
                for (String s:temp[2]){
                    if (s!=null)
                    mSub.add(s);
                }
                aMain.retainAll(aSub);
                hMain.retainAll(hSub);
                mMain.retainAll(mSub);}
            else{
                aMain=new HashSet<>();
                hMain=new HashSet<>();
                mMain=new HashSet<>();
                for (String s:temp[0]){
                    if (s!=null)
                    aMain.add(s);
                }
                for (String s:temp[1]){
                    if (s!=null)
                    hMain.add(s);
                }
                for (String s:temp[2]){
                    if (s!=null)
                    mMain.add(s);
                }
            }
        }
        if(type.length()>1){
            if (aMain!=null) {
                if(type.equalsIgnoreCase("apartment")){
                    hMain=null;
                    mMain=null;
                    //return aMain.toArray(new String[0]);
                }
                else if(type.equalsIgnoreCase("hotel")){
                    aMain=null;
                    mMain=null;
                    //return hMain.toArray(new String[0]);
                }
                else if(type.equalsIgnoreCase("maisonette")){
                    hMain=null;
                    aMain=null;
                    //return hMain.toArray(new String[0]);
                }
            }
            else{
                aMain=new HashSet<>();
                hMain=new HashSet<>();
                mMain=new HashSet<>();
                HashSet<String> main=new HashSet<>();
                if(type.equals("Διαμέρισμα")){
                    for (String s:temp[0]){

                        main.add(s+"#"+"Apartment");}
                }
                else if(type.equals("Ξενοδοχείο")){
                    for (String s:temp[1]){
                        main.add(s+"#"+"Hotel");}
                }
                else if(type.equals("Μεζονέτα")){
                    for (String s:temp[2]){
                        main.add(s+"#"+"Maisonette");}
                }
                return main.toArray(new String[0]);
            }
        }
        ArrayList<String> ar=new ArrayList<>();
        if (aMain!=null){
        t=aMain.toArray(new String[0]);
        for (String s:t){
            if (s!=null)
            ar.add(s+"#"+"Apartment");
        }}
        if (hMain!=null){
        t=hMain.toArray(new String[0]);
        for (String s:t){
            if (s!=null)
                ar.add(s+"#"+"Hotel");
        }}
        if (mMain!=null){
        t=mMain.toArray(new String[0]);
        for (String s:t){
            if (s!=null)
                ar.add(s+"#"+"Maisonette");
        }}
        return ar.toArray(new String[0]);
    }

    /**
     * Destructor
     */
    public void destructor(){
        amu.destructor();
    }

}