package api;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class AccommodationManagerUserTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findProperties() {
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addAccommodation("Ξενοδοχείο", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.updateProperty("someGuy","three-story building in Antigonidon(Hotel)","view","Sea");
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Διαμέρισμα", "three-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.updateProperty("someGuy2","three-story building in Antigonidon(Apartment)","view","Sea");
        AM.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Μεζονέτα", "three-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.updateProperty("someGuy3","three-story building in Antigonidon(Maisonette)","view","Sea");

        //AM.findProperties();


    }
    @Test
    public void addRating() {
        System.out.println("Add Accommodation Rating:");
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"Makis",date);
        AM.showAll();
    }

    @Test
    public void editRatings() {
        System.out.println("Edit Accommodation Rating:");
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"Makis",date);
        AM.showAll();
        AM.editRatings("someGuy2","4-story building in Antigonidon(Hotel)","This is actually good!!!",4,"Makis");
        AM.showAll();
    }

    @Test
    public void deleteRating() {
        System.out.println("Delete Accommodation Rating:");
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"Makis",date);
        AM.showAll();
        AM.deleteRating("someGuy2","4-story building in Antigonidon(Hotel)","Makis");
        AM.showAll();
    }
}