package api;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.util.Map;

import static org.junit.Assert.*;

public class AccommodationManagerProviderSubTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("accommodations.dat");
        pw.close();
    }
    @Test
    public void getOwnedApartments() {
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Hotel", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Apartment", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        Apartment exp=AM.getApartment("someGuy3","5-story building in Antigonidon(Apartment)");
        AM.addAccommodation("Maisonette", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Maisonette", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        assertEquals(exp,AM.getOwnedApartments("someGuy3").get(0));


    }

    @Test
    public void getOwnedHotels() {
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Hotel", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Apartment", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        Hotel exp=AM.getHotel("someGuy3","5-story building in Antigonidon(Hotel)");
        AM.addAccommodation("Maisonette", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Maisonette", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        assertEquals(exp,AM.getOwnedHotels("someGuy3").get(0));
    }

    @Test
    public void getOwnedMaisonettes() {
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Hotel", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Apartment", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Maisonette", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Maisonette", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        Maisonette exp=AM.getMaisonette("someGuy3","5-story building in Antigonidon(Maisonette)");
        assertEquals(exp,AM.getOwnedMaisonettes("someGuy3").get(0));
    }

    @Test
    public void getRatingsNumber() {
        System.out.println("get Ratings Number:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Hotel", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Maisonette", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Hotel", "three-story building in ggg(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");

        for (Map.Entry<String, Hotel> entry : AM.hotels.entrySet()) {
            if (entry.getValue().getOwner().equals("someGuy")) {
                entry.getValue().addRating("SuperR!", 4, "KOSTAS", "1/1/2022","ks");
            }
        }
        for (Map.Entry<String, Maisonette> entry : AM.maisonettes.entrySet()) {
            if (entry.getValue().getOwner().equals("someGuy")) {
                entry.getValue().addRating("Very good", 5, "vlad", "3/1/2022","vl");
            }
        }
        int excepted = 3;
        System.out.println(AM.getRatingsNumber("someGuy"));
        assertEquals(excepted, AM.getRatingsNumber("someGuy"));
    }


    @Test
    public void getRatingAverage() {
        System.out.println("get Ratings Average:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Hotel", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Maisonette", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Hotel", "three-story building in ggg(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        for (Map.Entry<String, Hotel> entry : AM.hotels.entrySet()) {
            if (entry.getValue().getOwner().equals("someGuy")) {
                entry.getValue().addRating("ok!", 5, "gio", "1/1/2022","g");
            }
        }
        for (Map.Entry<String, Maisonette> entry : AM.maisonettes.entrySet()) {
            if (entry.getValue().getOwner().equals("someGuy")) {
                entry.getValue().addRating("Very good", 5, "vlad", "3/1/2022","vl");
            }
        }
        for (Map.Entry<String,Apartment> entry : AM.apartments.entrySet()) {
            if (entry.getValue().getOwner().equals("someGuy")) {
                entry.getValue().addRating("mid",2,"jim","24/9/2022","jimD");
            }
        }
        double excepted=4.25;
        System.out.println(AM.getRatingAverage("someGuy"));
        assertEquals(excepted,AM.getRatingAverage("someGuy"),0.01);

    }

    @Test
    public void showOwned() {
        System.out.println("Show Owned Accommodations:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Hotel", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Apartment", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Maisonette", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Maisonette", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.showOwned("someGuy3");
    }
}