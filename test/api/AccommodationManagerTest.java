package api;

import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void showAll() {
    }

    @Test
    public void showOwned() {
    }

    @Test
    public void updateProperty() {
    }

    @Test
    public void addRating() {
    }

    @Test
    public void editRatings() {
    }

    @Test
    public void deleteRating() {
    }

    @Test
    public void getHotel() {
    }

    @Test
    public void getApartment() {
    }

    @Test
    public void getMaisonette() {
    }

    @Test
    public void getType() {
    }

    @Test
    public void setDescription() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void setTK() {
    }

    @Test
    public void setCity() {
    }

    @Test
    public void setAddress() {
    }
}