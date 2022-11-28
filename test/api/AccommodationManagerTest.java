package api;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class AccommodationManagerTest {

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void showAll() {
        System.out.println("Show All Accommodations:");
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.showAll();
    }

    @Test
    public void getHotel() {
        System.out.println("Get Hotel:");
        Hotel h;
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        h=AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)");
        h.show();
    }

    @Test
    public void getApartment() {
        System.out.println("Get Apartment:");
        Apartment h;
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        h=AM.getApartment("someGuy2","4-story building in Antigonidon(Hotel)");
        h.show();
    }

    @Test
    public void getMaisonette() {
        System.out.println("Get Maisonette:");
        Maisonette h;
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        h=AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)");
        h.show();
    }

    @Test
    public void getType() {
        System.out.println("Get type:");
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="Μεζονέτα";
        assertEquals(expected,AM.getType("someGuy2","4-story building in Antigonidon(Hotel)"));
    }

}