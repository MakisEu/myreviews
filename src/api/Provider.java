package api;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Provider {
    //private ArrayList<Accommodation> accommodations;
    private AccommodationManagerProvider amp;
    String owner,first_name;


    public Provider(String owner,String fn){
        amp=new AccommodationManagerProvider();this.owner=owner;this.first_name=fn;
    }

     public void addAccommodation(String t, String n, String a, String tk, String c, String desc){
        String type=null;
        if (t.equals("h")){type="Ξενοδοχείο";}
        if (t.equals("a")){type="Διαμέρισμα";}
        if (t.equals("m")){type="Μεζονέτα";}
        amp.addAccommodation(type,n,a,tk,c,desc,owner);
    }
    public  void updateProperties(Accommodation acc,String[] pr){
        for (String pro:pr){
            String[] keyval=pro.split("-");
            acc.updateProperty(keyval[0],keyval[1]);
        }
    }
    public String editAccommodation(String type, String n, String a, String tk, String c, String desc,String oln,String[] pr){
        
        if (type.equals("a")){
            Apartment acc=amp.getApartment(owner,oln);
            if (n.length()>=1){
                acc.setName(n);}
            if (a.length()>=1){
                acc.setAddress(a);
            }
            if (tk.length()>=1){
                acc.setTK(tk);
            }
            if (c.length()>=1){
                acc.setCity(c);
            }
            if (desc.length()>=1){
                acc.setDescription(desc);
            }
            this.updateProperties(acc,pr);
        }
        else if (type.equals("h")){
            Hotel acc=amp.getHotel(owner,oln);
            if (n.length()>=1){
                acc.setName(n);}
            if (a.length()>=1){
                acc.setAddress(a);
            }
            if (tk.length()>=1){
                acc.setTK(tk);
            }
            if (c.length()>=1){
                acc.setCity(c);
            }
            if (desc.length()>=1){
                acc.setDescription(desc);
            }
            this.updateProperties(acc,pr);
        }
        else if (type.equals("m")){
            Maisonette acc=amp.getMaisonette(owner,oln);
            if (n.length()>=1){
                acc.setName(n);}
            if (a.length()>=1){
                acc.setAddress(a);
            }
            if (tk.length()>=1){
                acc.setTK(tk);
            }
            if (c.length()>=1){
                acc.setCity(c);
            }
            if (desc.length()>=1){
                acc.setDescription(desc);
            }
            /*for (String pro:pr){
                String[] keyval=pro.split("-");
                acc.updateProperty(keyval[0],keyval[1]);
            }*/
            this.updateProperties(acc,pr);
        }
        return ("Accommodation edited!");
    }
    public void setApartment(String floor,String space,String guard,String el,Apartment a){
        if (floor.length()>=1){
            a.setFloor(Integer.parseInt(floor));
        }
        if (space.length()>=1){
            a.setSpace(Integer.parseInt(space));
        }
        if (guard.length()>=1){
            if (guard.toLowerCase().equals("true")) {
                a.setGuard(true);
            } else if (guard.toLowerCase().equals("false")) {
                a.setGuard(false);
            }else {System.out.println("Error, not valid boolean type");}
        }
        if (el.length()>=1){
            if (el.toLowerCase().equals("true")) {
                a.setElevator(true);
            } else if (el.toLowerCase().equals("false")) {
                a.setElevator(false);
            }else {System.out.println("Error, not valid boolean type");}
        }
    }
    public void setHotel(String stars,String floor,String suite,Hotel h){
        if (stars.length()>=1){
            h.setStars(Integer.parseInt(stars));
        }
        if (floor.length()>=1){
            h.setFloors(Integer.parseInt(floor));
        }
        if (suite.length()>=1){
            if (suite.toLowerCase().equals("true")) {
                h.setHasSuite(true);
            } else if (suite.toLowerCase().equals("false")) {
                h.setHasSuite(false);
            }else {System.out.println("Error, not valid boolean type");}
        }
    }
    public void setMaisonette(String roommates,Maisonette m){
        if (roommates.length()>=1){
            m.setRoommates(Integer.parseInt(roommates));
        }
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

    public String showOwned(){
        return amp.showOwned(owner);
    }

    public void deleteAccommodation(String n){
        amp.deleteAccommodation(owner,n);
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




}
