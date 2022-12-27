package api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

import static org.junit.Assert.*;

public class AccommodationManagerProviderTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("accommodations.dat");
        pw.close();
    }
    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void addAccommodation() throws FileNotFoundException {
        System.out.println("Add Accommodations:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Ξενοδοχείο", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Διαμέρισμα", "three-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Μεζονέτα", "three-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.showAll();

    }

    @Test
    public void editHotel() {
        System.out.println("Edit Hotel:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Ξενοδοχείο", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        //Edit Star
        AM.editHotel("someGuy2","4-story building in Antigonidon(Hotel)",5,AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").getFloors(),AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").isHasSuite());
        //AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").show();
        int expected=5;
        assertEquals(expected,AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").getStars());
        //Edit Floor
        AM.editHotel("someGuy2","4-story building in Antigonidon(Hotel)",AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").getStars(),7,AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").isHasSuite());
        //AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").show();
        expected=7;
        assertEquals(expected,AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").getFloors());
        //Edit Suite
        AM.editHotel("someGuy2","4-story building in Antigonidon(Hotel)",AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").getStars(),AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").getFloors(),true);
        //AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").show();
        boolean exp=true;
        assertEquals(exp,AM.getHotel("someGuy2","4-story building in Antigonidon(Hotel)").isHasSuite());

    }

    @Test
    public void editApartment() {
        System.out.println("Edit Apartment:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Διαμέρισμα", "three-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        int expected=5;
        //Edit Floor
        AM.editApartment("someGuy2","4-story building in Antigonidon(Apartment)",5,AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").getSpace(),AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").isGuard(),AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").isElevator());
        assertEquals(expected,AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").getFloor());
        //Edit Space
        expected=4;
        AM.editApartment("someGuy2","4-story building in Antigonidon(Apartment)",AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").getFloor(),4,AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").isGuard(),AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").isElevator());
        assertEquals(expected,AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").getSpace());
        //Edit Guard
        boolean exp=true;
        AM.editApartment("someGuy2","4-story building in Antigonidon(Apartment)",AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").getFloor(),AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").getSpace(),true,AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").isElevator());
        assertEquals(exp,AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").isGuard());
        //Edit Elevator
        AM.editApartment("someGuy2","4-story building in Antigonidon(Apartment)",AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").getFloor(),AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").getSpace(),AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").isGuard(),true);
        assertEquals(exp,AM.getApartment("someGuy2","4-story building in Antigonidon(Apartment)").isElevator());
        //AM.getApartment("someGuy2","4-story building in Antigonidon(Hotel)").show();

    }

    @Test
    public void editMaisonette() {
        System.out.println("Edit Maisonette:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Μεζονέτα", "three-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        int expected=5;
        //Edit Roommates
        AM.editMaisonette("someGuy2","4-story building in Antigonidon(Maisonette)",5);
        assertEquals(expected,AM.getMaisonette("someGuy2","4-story building in Antigonidon(Maisonette)").getRoommates());
    }

    @Test
    public void deleteAccommodation() {
        System.out.println("Delete Accommodations:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        //Test Hotel
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.deleteAccommodation("someGuy3","5-story building in Antigonidon(Hotel)");
        //Test Apartment
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.deleteAccommodation("someGuy3","5-story building in Antigonidon(Apartment)");
        //Test Maisonette
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.deleteAccommodation("someGuy3","5-story building in Antigonidon(Maisonette)");

        AM.showAll();
    }
    @Test
    public void updateProperty() {
        System.out.println("Update Accommodation Property:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.updateProperty("someGuy2","4-story building in Antigonidon(Hotel)","view","Sea");
        AM.showAll();
    }

    @Test
    public void showOwned() {
        System.out.println("Show Owned Accommodations:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.showOwned("someGuy3");
    }
    @Test
    public void setDescription() {
        System.out.println("Set Description:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="A Hotel";
        AM.setDescription("someGuy2","4-story building in Antigonidon(Hotel)","A Hotel");
        assertEquals(expected,AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)").getDescription());
    }

    @Test
    public void setName() {
        System.out.println("Set Name:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="Smthing";
        AM.setName("someGuy2","4-story building in Antigonidon(Hotel)","Smthing");
        assertEquals(expected,AM.getMaisonette("someGuy2","Smthing").getName());
    }

    @Test
    public void setTK() {
        System.out.println("Set TK:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="321654";
        AM.setTK("someGuy2","4-story building in Antigonidon(Hotel)","321654");
        assertEquals(expected,AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)").getTK());
    }

    @Test
    public void setCity() {
        System.out.println("Set City:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="Athens";
        AM.setCity("someGuy2","4-story building in Antigonidon(Hotel)","Athens");
        assertEquals(expected,AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)").getCity());
    }

    @Test
    public void setAddress() {
        System.out.println("Set Address:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="center";
        AM.setAddress("someGuy2","4-story building in Antigonidon(Hotel)","center");
        assertEquals(expected,AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)").getAddress());
    }


    @Test
    public void getRatingsNumber() {
        System.out.println("get Ratings Number:");
        AccommodationManagerProvider AM = new AccommodationManagerProvider();
        AM.addAccommodation("Ξενοδοχείο", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Ξενοδοχείο", "three-story building in ggg(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");

        for (Map.Entry<String, Hotel> entry : AM.hotels.entrySet()) {
            if (entry.getValue().getOwner().equals("someGuy")) {
                entry.getValue().addRating("SuperR!", 4, "KOSTAS", "1/1/2022");
            }
        }
        for (Map.Entry<String, Maisonette> entry : AM.maisonettes.entrySet()) {
            if (entry.getValue().getOwner().equals("someGuy")) {
                entry.getValue().addRating("Very good", 5, "vlad", "3/1/2022");
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
        AM.addAccommodation("Ξενοδοχείο", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Ξενοδοχείο", "three-story building in ggg(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        for (Map.Entry<String, Hotel> entry : AM.hotels.entrySet()) {
            if (entry.getValue().getOwner().equals("someGuy")) {
                entry.getValue().addRating("ok!", 5, "gio", "1/1/2022");
            }
        }
        for (Map.Entry<String, Maisonette> entry : AM.maisonettes.entrySet()) {
            if (entry.getValue().getOwner().equals("someGuy")) {
                entry.getValue().addRating("Very good", 5, "vlad", "3/1/2022");
            }
        }
        for (Map.Entry<String,Apartment> entry : AM.apartments.entrySet()) {
            if (entry.getValue().getOwner().equals("someGuy")) {
                entry.getValue().addRating("mid",2,"jim","24/9/2022");
            }
        }
        double excepted=4.25;
        System.out.println(AM.getRatingAverage("someGuy"));
        assertEquals(excepted,AM.getRatingAverage("someGuy"),0.01);

    }























}