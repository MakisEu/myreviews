package api;

import org.junit.Assert;
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
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Hotel", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Apartment", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Maisonette", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Maisonette", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.destructor();
        AccommodationManager AM=new AccommodationManager();
        AM.showAll();
    }

    @Test
    public void getHotel() throws FileNotFoundException {
        System.out.println("Get Hotel:");
        Hotel h;
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
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
        AMP.addAccommodation("Apartment", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
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
        AMP.addAccommodation("Maisonette", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.destructor();
        AccommodationManager AM = new AccommodationManager();
        h=AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)");
        h.show();
    }

    @Test
    public void getType() throws FileNotFoundException {
        System.out.println("Get type:");
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Maisonette", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="Maisonette";
        AMP.destructor();
        AccommodationManager AM = new AccommodationManager();
        assertEquals(expected,AM.getType("someGuy2","4-story building in Antigonidon(Hotel)"));
        assertEquals(null,AM.getType("someGuy2",")"));
    }

    @Test
    public void destructor() throws FileNotFoundException {
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Hotel", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Apartment", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Maisonette", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Maisonette", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.destructor();
        AccommodationManager AM = new AccommodationManager();
        AM.showAll();

    }
}