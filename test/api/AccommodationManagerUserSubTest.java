package api;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class AccommodationManagerUserSubTest {

    @Test
    public void addRating() throws FileNotFoundException {
        System.out.println("Add Accommodation Rating:");
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        AMP.destructor();
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"Makis",date,"mk","Hotel");
        AM.showAll();
    }

    @Test
    public void editRatings() throws FileNotFoundException {
        System.out.println("Edit Accommodation Rating:");
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        AMP.destructor();
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"Makis",date,"mk","Hotel");
        AM.showAll();
        AM.editRatings("someGuy2","4-story building in Antigonidon(Hotel)","This is actually good!!!",4,"Makis","Hotel");
        AM.showAll();
    }

    @Test
    public void deleteRating() throws FileNotFoundException {
        System.out.println("Delete Accommodation Rating:");
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        AMP.destructor();
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"Makis",date,"mk","Hotel");
        AM.showAll();
        AM.deleteRating("someGuy2","4-story building in Antigonidon(Hotel)","Makis","Hotel");
        AM.showAll();
    }

    @Test
    public void allRatings() {
        System.out.println("All rating of a user:");
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        AMP.destructor();
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"Makis",date,"mk","Hotel");
        AM.addRating("someGuy","4-story building in Antigonidon","This sucks!!!",2,"Makis",date,"mk","Hotel");
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"John",date,"jn","Hotel");
        String expected="4-story building in Antigonidon,Hotel,someGuy,Thessalonikh,2.0";
        String[] s=AM.allRatings("Makis");
        assertEquals(expected,s[0]);
        expected="4-story building in Antigonidon(Hotel),Hotel,someGuy2,Thessalonikh,2.0";
        assertEquals(expected,s[1]);
    }

    @Test
    public void getMean() {
        System.out.println("Mean of ratings of user:");
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        AMP.destructor();
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"Makis",date,"mk","Hotel");
        AM.addRating("someGuy","4-story building in Antigonidon","This sucks!!!",1,"Makis",date,"mk","Hotel");
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"John",date,"jn","Hotel");
        double d=1.5;
        assertEquals(d,AM.getMean("Makis"),0.1);
    }
}