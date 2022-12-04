package api;

import java.util.ArrayList;

public class Provider {
    //private ArrayList<Accommodation> accommodations;
    private AccommodationManagerProvider amp;


    public Provider(){
        amp=new AccommodationManagerProvider();
    }

     public void addAcommodation(String type, String n, String a, String tk, String c, String desc, String o){
        amp.addAccommodation(type,n,a,tk,c,desc,o);

    }


    public float getAllRatingsNumber(){
        return amp.getRatingsNumber();
    }

    public double getAllAccommodationsGrades(){
        return amp.getRatingAverage();
    }

    public void showAll(){
        amp.showAll();
    }

    public void showOwned(String o){
        amp.showOwned(o);
    }

    public void deleteAccommodation(String o,String n){
        amp.deleteAccommodation(o,n);
    }






}
