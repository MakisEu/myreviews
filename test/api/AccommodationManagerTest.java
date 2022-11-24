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
    public void addAccommodation() {
        System.out.println("Add Accommodations:");
        AccommodationManager AM = new AccommodationManager();
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
        AccommodationManager AM = new AccommodationManager();
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
        AccommodationManager AM = new AccommodationManager();
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
        AccommodationManager AM = new AccommodationManager();
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
        AccommodationManager AM = new AccommodationManager();
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
    public void showOwned() {
        System.out.println("Show Owned Accommodations:");
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.showOwned("someGuy3");
    }

    @Test
    public void updateProperty() {
        System.out.println("Update Accommodation Property:");
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.updateProperty("someGuy2","4-story building in Antigonidon(Hotel)","view","Sea");
        AM.showAll();
    }
    @Test
    public void addRating() {
        System.out.println("Add Accommodation Rating:");
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"Makis",date);
        AM.showAll();
    }

    @Test
    public void editRatings() {
        System.out.println("Edit Accommodation Rating:");
        AccommodationManager AM = new AccommodationManager();
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
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        AM.addRating("someGuy2","4-story building in Antigonidon(Hotel)","This sucks!!!",2,"Makis",date);
        AM.showAll();
        AM.deleteRating("someGuy2","4-story building in Antigonidon(Hotel)","Makis");
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

    @Test
    public void setDescription() {
            System.out.println("Set Description:");
            AccommodationManager AM = new AccommodationManager();
            AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
            String expected="A Hotel";
            AM.setDescription("someGuy2","4-story building in Antigonidon(Hotel)","A Hotel");
            assertEquals(expected,AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)").getDescription());
    }

    @Test
    public void setName() {
        System.out.println("Set Name:");
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="Smthing";
        AM.setName("someGuy2","4-story building in Antigonidon(Hotel)","Smthing");
        assertEquals(expected,AM.getMaisonette("someGuy2","Smthing").getName());
    }

    @Test
    public void setTK() {
        System.out.println("Set TK:");
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="321654";
        AM.setTK("someGuy2","4-story building in Antigonidon(Hotel)","321654");
        assertEquals(expected,AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)").getTK());
    }

    @Test
    public void setCity() {
        System.out.println("Set City:");
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="Athens";
        AM.setCity("someGuy2","4-story building in Antigonidon(Hotel)","Athens");
        assertEquals(expected,AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)").getCity());
    }

    @Test
    public void setAddress() {
        System.out.println("Set Address:");
        AccommodationManager AM = new AccommodationManager();
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        String expected="center";
        AM.setAddress("someGuy2","4-story building in Antigonidon(Hotel)","center");
        assertEquals(expected,AM.getMaisonette("someGuy2","4-story building in Antigonidon(Hotel)").getAddress());
    }
}