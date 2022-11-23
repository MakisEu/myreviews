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
    public void editAccommodation(String o, String type,String n,String a, String tk,String c,String desc){
        if (type=="Ξενοδοχείο"){
            for (Hotel h:hotels){
                if (h.getOwner()==o && h.getName()==n){
                    h.setAddress(a);
                    h.setTK(tk);
                    h.setCity(c);
                    h.setDescription(desc);
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
                }
            }

    }
    }
    public void updateProperty(String o,String type,String n,String key,String val) {
        if (type == "Ξενοδοχείο") {
            for (Hotel h : hotels) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.updateProperty(key, val);
                }
            }
        } else if (type == "Διαμέρισμα") {
            for (Apartment h : apartments) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.updateProperty(key, val);
                }
            }

        } else if (type == "Μεζονέτα") {
            for (Maisonette h : maisonettes) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.updateProperty(key, val);
                }
            }
        }
    }
    public void addRating(String o,String type,String n,String desc,float ra,String user,String date){
        if (type == "Ξενοδοχείο") {
            for (Hotel h : hotels) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.addRating(desc,ra,user,date);
                }
            }
        } else if (type == "Διαμέρισμα") {
            for (Apartment h : apartments) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.addRating(desc,ra,user,date);
                }
            }

        } else if (type == "Μεζονέτα") {
            for (Maisonette h : maisonettes) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.addRating(desc,ra,user,date);
                }
            }
        }
    }
    public void editRatings(String o,String type,String n,String desc,float ra,String user){
        if (type == "Ξενοδοχείο") {
            for (Hotel h : hotels) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.editRating(user,desc,ra);
                }
            }
        } else if (type == "Διαμέρισμα") {
            for (Apartment h : apartments) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.editRating(user,desc,ra);
                }
            }

        } else if (type == "Μεζονέτα") {
            for (Maisonette h : maisonettes) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.editRating(user,desc,ra);
                }
            }
        }
    }
    public void deleteRating(String o,String type,String n,String user){
        if (type == "Ξενοδοχείο") {
            for (Hotel h : hotels) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.deleteRating(user);
                }
            }
        } else if (type == "Διαμέρισμα") {
            for (Apartment h : apartments) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.deleteRating(user);
                }
            }

        } else if (type == "Μεζονέτα") {
            for (Maisonette h : maisonettes) {
                if (h.getOwner() == o && h.getName() == n) {
                    h.deleteRating(user);
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
    public void showAll(){
        for (Apartment a:apartments){a.show();}
        for (Hotel h:hotels){h.show();}
        for (Maisonette m:maisonettes){m.show();}
    }
    public void showOwned(String owner){
        for (Apartment a:apartments){
            if(a.getOwner()==owner){
                a.show();}}
        for (Hotel h:hotels){
            if(h.getOwner()==owner){
                h.show();}}
        for (Maisonette m:maisonettes)  {
            if(m.getOwner()==owner){
                m.show();}}
    }
    public Hotel getHotel(String owner,String name){
        for (Hotel a:hotels){
            if (a.getOwner()==owner && a.getName()==name){
                return a;
            }
        }
        return null;
    }
    public Apartment getApartment(String owner,String name){
        for (Apartment a:apartments){
            if (a.getOwner()==owner && a.getName()==name){
                return a;
            }
        }
        return null;
    }
    public Maisonette getMaisonette(String owner,String name){
        for (Maisonette a:maisonettes){
            if (a.getOwner()==owner && a.getName()==name){
                return a;
            }
        }
        return null;
    }
}
