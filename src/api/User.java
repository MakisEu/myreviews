package api;

import gui.AccommodationManagerUserGui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

public class User extends  UserSub{

    public User(String n,String u){
        super(n,u);}



    /*public double getMean(String username){
        return amu.getMean(username);
    }*/
    public String getName(){
        return name;
    }

    public String getUsername(){
        return username;
    }

    public Apartment getApartment(String o,String n)  {
        return amu.getApartment(o,n);
    }

    public Hotel getHotel(String o,String n)  {
        return amu.getHotel(o,n);
    }

    public Maisonette getMaisonette(String o,String n)  {
        return amu.getMaisonette(o,n);
    }

    public boolean AddRating(String on,String rating,float score){
        boolean bool=false;
        String[] x=on.split("#");
        String type=new Helper().getTitle(x[0]);
        bool=amu.addRating(x[1],x[2],rating,score,username,new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date()),name,type);
        return bool;
    }
    public String[] allRatings(){
        String[] all;
        all=amu.allRatings(username);
        return all;
    }

    public boolean EditRating(String on,String rating,float score){
        boolean bool=false;
        String[] x=on.split("#");
        String type=new Helper().getTitle(x[0]);
        bool=amu.editRatings(x[1],x[2],rating,score,username,type);
        return bool;
    }
    public boolean DeleteRating(String on){
        boolean bool;
        String[] x=on.split("#");
        String type=new Helper().getTitle(x[0]);
        bool=amu.deleteRating(x[1],x[2],username,type);
        return bool;
    }
    public void destructor(){
        amu.destructor();
    }




}