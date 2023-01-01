package api;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Provider {
    //private ArrayList<Accommodation> accommodations;
    private AccommodationManagerProvider amp;
    String owner,first_name;


    public Provider(String owner,String fn){
        amp=new AccommodationManagerProvider();this.owner=owner;this.first_name=fn;
    }

     public boolean addAccommodation(String t, String n, String a, String tk, String c, String desc){
        String type;
         switch (t) {
             case "h":
                 type = "Hotel";
                 break;
             case "a":
                 type = "Apartment";
                 break;
             case "m":
                 type = "Maisonette";
                 break;
             default:
                 return false;
         }
        amp.addAccommodation(type,n,a,tk,c,desc,owner);
        return true;
    }
    /*public  void updateProperties(Accommodation acc,String[] pr){
        if(pr.length<1){
        for (String pro:pr){
            String[] keyval=pro.split("-");
            acc.updateProperty(keyval[0],keyval[1]);
        }
        }
    }*/
    public boolean editAccommodation(String type, String n, String a, String tk, String c, String desc,String oln,String[] pr){

        switch (type) {
            case "a": {
                Apartment acc = amp.getApartment(owner, oln);
                if (n.length() >= 1) {
                    amp.setName(owner,oln,n);
                }
                if (a.length() >= 1) {
                    acc.setAddress(a);
                }
                if (tk.length() >= 1) {
                    acc.setTK(tk);
                }
                if (c.length() >= 1) {
                    acc.setCity(c);
                }
                if (desc.length() >= 1) {
                    acc.setDescription(desc);
                }
                new Helper().updateProperties(acc, pr);
                break;
            }
            case "h": {
                Hotel acc = amp.getHotel(owner, oln);
                if (n.length() >= 1) {
                    amp.setName(owner,oln,n);
                }
                if (a.length() >= 1) {
                    acc.setAddress(a);
                }
                if (tk.length() >= 1) {
                    acc.setTK(tk);
                }
                if (c.length() >= 1) {
                    acc.setCity(c);
                }
                if (desc.length() >= 1) {
                    acc.setDescription(desc);
                }
                new Helper().updateProperties(acc, pr);
                break;
            }
            case "m": {
                Maisonette acc = amp.getMaisonette(owner, oln);
                if (n.length() >= 1) {
                    amp.setName(owner,oln,n);
                }
                if (a.length() >= 1) {
                    acc.setAddress(a);
                }
                if (tk.length() >= 1) {
                    acc.setTK(tk);
                }
                if (c.length() >= 1) {
                    acc.setCity(c);
                }
                if (desc.length() >= 1) {
                    acc.setDescription(desc);
                }
                new Helper().updateProperties(acc, pr);
                break;
            }
        }
        return true;
    }
    public int getAllRatingsNumber(String owner){
        return amp.getRatingsNumber(owner);
    }

    public double getAllAccommodationsGrades(String owner){
        return amp.getRatingAverage(owner);
    }

    public void showAll(){
        amp.showAll();
    }

    public String showOwned(){
        return amp.showOwned(owner);
    }         //here

    public void deleteAccommodation(String n,String type){
        amp.deleteAccommodation(owner,n,new Helper().getTitle(type));
    }
    public Apartment getApartment(String n){
        return amp.getApartment(owner,n);
    }
    public Hotel getHotel(String n){
        return amp.getHotel(owner,n);
    }
    public Maisonette getMaisonette(String n){
        return amp.getMaisonette(owner,n);
    }
    public void destructor() throws FileNotFoundException {
        amp.destructor();
    }
    public String[] getNames(){
        ArrayList<String> nam=new ArrayList<>();
        ArrayList<Apartment> ap=amp.getOwnedApartments(owner);
        ArrayList<Hotel> ho=amp.getOwnedHotels(owner);
        ArrayList<Maisonette> ma=amp.getOwnedMaisonettes(owner);
        for (Apartment a:ap){
            nam.add(a.getName()+"#Apartment");
        }
        for (Hotel a:ho){
            nam.add(a.getName()+"#Hotel");
        }
        for (Maisonette a:ma){
            nam.add(a.getName()+"#Maisonette");
        }
        return nam.toArray(new String[0]);

    }

}
