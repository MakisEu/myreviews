package api;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class AccommodationManagerTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("accommodations.dat");
        pw.close();
    }
    @Test
    public void showAll() throws FileNotFoundException {
        System.out.println("Show All Accommodations:");
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.destructor();
        AccommodationManager AM=new AccommodationManager();
        AM.showAll();
    }

    @Test
    public void getHotel() throws FileNotFoundException {
        System.out.println("Get Hotel:");
        Hotel h;
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.destructor();
        AccommodationManager AM = new AccommodationManager();
        h=AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)");
        h.show();
    }

    @Test
    public void getApartment() throws FileNotFoundException {
        System.out.println("Get Apartment:");
        Apartment h;
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.destructor();
        AccommodationManager AM = new AccommodationManager();
        h=AM.getApartment("someGuy2","4-story building in Antigonidon(Hotel)");
        h.show();
    }

    @Test
    public void getMaisonette() throws FileNotFoundException {
        System.out.println("Get Maisonette:");
        Maisonette h;
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.destructor();
        AccommodationManager AM = new AccommodationManager();
        h=AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)");
        h.show();
    }

    @Test
    public void getType() throws FileNotFoundException {
        System.out.println("Get type:");
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="Μεζονέτα";
        AMP.destructor();
        AccommodationManager AM = new AccommodationManager();
        assertEquals(expected,AM.getType("someGuy2","4-story building in Antigonidon(Hotel)"));
    }

    @Test
    public void destructor() throws FileNotFoundException {
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.destructor();
        AccommodationManager AM = new AccommodationManager();
        AM.showAll();

    }
}