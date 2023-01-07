import api.*;
import gui.StartScreenGUI;

import java.io.FileNotFoundException;

public class main {
    public static void initialize() throws FileNotFoundException {
        AllRegistered r=new AllRegistered();
        r.add_registration("provider1","password1","mk","Euaggelinos","Provider");
        r.add_registration("provider2","password2","jm","Ntantakas","Provider");
        r.add_registration("someGuy","0192837465","sg","guySome","Provider");
        r.add_registration("user1","password1","jn","name","User");
        r.add_registration("user2","password2","sg2","guy2Some","User");
        r.add_registration("Kostas","superSecretHiddenSecurePassword","ks","someSurname","User");
        Provider p=new Provider("provider1","mk");
        Helper h=new Helper();
        Helper2 h2=new Helper2();
        String[] s1={"view-sea","internet-fast","bath-big","laundry-shared"},s2={"view-mountains","internet-slow","bath-small","laundry-paid"};
        p.addAccommodation("a","Apartment in Thessalonikh","Aristotle","123456","Thessalonikh","Give it a try");
        h2.setApartment("1","3","true","false",p.getApartment("Apartment in Thessalonikh"));
        h.updateProperties(p.getApartment("Apartment in Thessalonikh"),s1);
        p.addAccommodation("a","Another apartment in Thessalonikh","Kamara","214356","Thessalonikh","Give it a try!!!");
        h2.setApartment("4","2","true","true",p.getApartment("Another apartment in Thessalonikh"));
        h.updateProperties(p.getApartment("Another apartment in Thessalonikh"),s2);
        p.addAccommodation("h","Hotel in Thessalonikh","Aristotle","123456","Thessalonikh","Give it a try");
        h2.setHotel("3","2","false",p.getHotel("Hotel in Thessalonikh"));
        h.updateProperties(p.getHotel("Hotel in Thessalonikh"),s1);
        p.addAccommodation("h","Another Hotel in Thessalonikh","Kamara","214356","Thessalonikh","Give it a try!!!");
        h2.setHotel("5","7","true",p.getHotel("Another Hotel in Thessalonikh"));
        h.updateProperties(p.getHotel("Another Hotel in Thessalonikh"),s2);
        p.addAccommodation("m","Maisonette in Thessalonikh","Aristotle","123456","Thessalonikh","Give it a try");
        h2.setMaisonette("3",p.getMaisonette("Maisonette in Thessalonikh"));
        h.updateProperties(p.getMaisonette("Maisonette in Thessalonikh"),s1);
        p.addAccommodation("m","Another Maisonette in Thessalonikh","Kamara","214356","Thessalonikh","Give it a try!!!");
        h2.setMaisonette("0",p.getMaisonette("Another Maisonette in Thessalonikh"));
        h.updateProperties(p.getMaisonette("Another Maisonette in Thessalonikh"),s2);
        p.destructor();
        p=new Provider("provider2","jm");
        p.addAccommodation("a","Apartment in Athens","Center","123456","Athens","Give it a try");
        h2.setApartment("1","3","true","false",p.getApartment("Apartment in Athens"));
        h.updateProperties(p.getApartment("Apartment in Athens"),s1);
        p.addAccommodation("a","Another apartment in Athens","Outskirts","214356","Athens","Give it a try!!!");
        h2.setApartment("4","2","true","true",p.getApartment("Another apartment in Athens"));
        h.updateProperties(p.getApartment("Another apartment in Athens"),s2);
        p.addAccommodation("h","Hotel in Athens","Center","123456","Athens","Give it a try");
        h2.setHotel("3","2","false",p.getHotel("Hotel in Athens"));
        h.updateProperties(p.getHotel("Hotel in Athens"),s1);
        p.addAccommodation("h","Another Hotel in Athens","Outskirts","214356","Athens","Give it a try!!!");
        h2.setHotel("5","7","true",p.getHotel("Another Hotel in Athens"));
        h.updateProperties(p.getHotel("Another Hotel in Athens"),s2);
        p.addAccommodation("m","Maisonette in Athens","Center","123456","Athens","Give it a try");
        h2.setMaisonette("3",p.getMaisonette("Maisonette in Athens"));
        h.updateProperties(p.getMaisonette("Maisonette in Athens"),s1);
        p.addAccommodation("m","Another Maisonette in Athens","Outskirts","214356","Athens","Give it a try!!!");
        h2.setMaisonette("0",p.getMaisonette("Another Maisonette in Athens"));
        h.updateProperties(p.getMaisonette("Another Maisonette in Athens"),s2);
        p.destructor();
        User u=new User("user1","jn");
        u.AddRating("m#provider1#Another Maisonette in Thessalonikh","This is good!!!",5);
        u.AddRating("m#provider1#Maisonette in Thessalonikh","This is good!!!",5);
        u.AddRating("h#provider1#Another Hotel in Thessalonikh","This is good!!!",5);
        u.AddRating("h#provider1#Hotel in Thessalonikh","This is good!!!",5);
        u.AddRating("a#provider1#Apartment in Thessalonikh","This is good!!!",5);
        u.AddRating("a#provider1#Another apartment in Thessalonikh","This is good!!!",5);

        u.AddRating("m#provider2#Another Maisonette in Athens","This is good!!!",5);
        u.AddRating("m#provider2#Maisonette in Athens","This is good!!!",5);
        u.AddRating("h#provider2#Another Hotel in Athens","This is good!!!",5);
        u.AddRating("h#provider2#Hotel in Athens","This is good!!!",5);
        u.AddRating("a#provider2#Apartment in Athens","This is good!!!",5);
        u.AddRating("a#provider2#Another apartment in Athens","This is good!!!",5);
        u.destructor();
        u=new User("user2","password2");
        u.AddRating("m#provider1#Another Maisonette in Thessalonikh","This is bad!!!",2);
        u.AddRating("m#provider1#Maisonette in Thessalonikh","This is bad!!!",2);
        u.AddRating("h#provider1#Another Hotel in Thessalonikh","This is bad!!!",2);
        u.AddRating("h#provider1#Hotel in Thessalonikh","This is bad!!!",2);
        u.AddRating("a#provider1#Apartment in Thessalonikh","This is bad!!!",2);
        u.AddRating("a#provider1#Another apartment in Thessalonikh","This is bad!!!",2);

        u.AddRating("m#provider2#Another Maisonette in Athens","This is bad!!!",2);
        u.AddRating("m#provider2#Maisonette in Athens","This is bad!!!",2);
        u.AddRating("h#provider2#Another Hotel in Athens","This is bad!!!",2);
        u.AddRating("h#provider2#Hotel in Athens","This is bad!!!",2);
        u.AddRating("a#provider2#Apartment in Athens","This is bad!!!",2);
        u.AddRating("a#provider2#Another apartment in Athens","This is bad!!!",2);
        u.destructor();



    }

    public static void main(String[] args) {
        //initialize();
        new StartScreenGUI().g();
    }

}
