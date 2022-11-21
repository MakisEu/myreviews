package api;

import java.util.ArrayList;

public class AccommodationManager {
    private ArrayList<Apartment> apartments;
    private ArrayList<Hotel> hotels;
    private ArrayList<Maisonette> maisonettes;

    public AccommodationManager(){
        apartments=new ArrayList<>();
        hotels=new ArrayList<>();
        maisonettes=new ArrayList<>();
    }
    public String addAccommodation(String type,String n,String a, String tk,String c,String desc,String o){
        if (type=="Ξενοδοχείο"){
            Hotel h=new Hotel(n,a,tk,c,desc,o);
            hotels.add(h);
            return "Added successfully";
        }
        else if (type=="Διαμέρισμα"){
            Apartment ap=new Apartment(n,a,tk,c,desc,o);
            apartments.add(ap);
            return "Added successfully";
        }
        else if (type=="Μεζονέτα"){
            Maisonette h=new Maisonette(n,a,tk,c,desc,o);
            maisonettes.add(h);
            return "Added successfully";
        }
        else{
            return "Incorrect type. Addition failed.";
        }
    }
    public void editHotel(String owner,String name,int star,int floor,boolean suite){
        for (Hotel a:hotels){
            if (a.getOwner()==owner && a.getName()==name){
                a.setFloors(floor);
                a.setStars(star);
                a.setHasSuite(suite);
            }
        }
    }
    public  void editApartment(String owner,String name,int floor,int space,boolean guard,boolean elevator){
        for (Apartment a: apartments){
            if (a.getOwner()==owner && a.getName()==name){
                a.setSpace(space);
                a.setElevator(elevator);
                a.setFloor(floor);
                a.setGuard(guard);
            }
        }
    }
    public void editMaisonette(String owner,String name,int rm){
        for (Maisonette a: maisonettes){
            if (a.getOwner()==owner && a.getName()==name){
                a.setRoommates(rm);
            }
        }
    }
    public void editAccommodation(String o, String type,String n,String a, String tk,String c,String desc,String key,String value){
        if (type=="Ξενοδοχείο"){
            for (Hotel h:hotels){
                if (h.getOwner()==o && h.getName()==n){
                    h.setAddress(a);
                    h.setTK(tk);
                    h.setCity(c);
                    h.setDescription(desc);
                    h.updateProperty(key,value);
                }
            }
    }
    else if (type=="Διαμέρισμα"){
            for (Apartment h:apartments){
                if (h.getOwner()==o && h.getName()==n){
                    h.setAddress(a);
                    h.setTK(tk);
                    h.setCity(c);
                    h.setDescription(desc);
                    h.updateProperty(key,value);

                }
            }

    }
    else if (type=="Μεζονέτα"){
            for (Maisonette h:maisonettes){
                if (h.getOwner()==o && h.getName()==n){
                    h.setAddress(a);
                    h.setTK(tk);
                    h.setCity(c);
                    h.setDescription(desc);
                    h.updateProperty(key,value);
                }
            }

    }
    }
    public void deleteAccommodation(String owner,String name,String type) {
        if (type == "Ξενοδοχείο") {
            for (Hotel h : hotels) {
                if (h.getOwner() == owner && h.getName() == name) {
                    hotels.remove(h);
                }
            }
        }
        else if (type == "Διαμέρισμα") {
            for (Apartment h : apartments) {
                if (h.getOwner() == owner && h.getName() == name) {
                    apartments.remove(h);
                }
            }
        }
        else if (type == "Μεζονέτα") {
            for (Maisonette h : maisonettes) {
                if (h.getOwner() == owner && h.getName() == name) {
                    maisonettes.remove(h);
                }
            }
        }
    }
}
