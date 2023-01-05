package api;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class ProviderTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("accommodations.dat");
        pw.close();
    }

    @Test
    public void addAccommodation() {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        assertNotNull(service.getHotel("This is a name"));
    }

    @Test
    public void editAccommodation() {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        String[] pr=new String[2];
        pr[0]="view-sea";
        pr[1]="internet-fast";
        service.editAccommodation("h","New name","New address","654321","Thessalonikh","New description","This is a name",pr);
        assertNotNull(service.getHotel("New name"));
        Accommodation acc=service.getHotel("New name");
        assertEquals("654321",acc.getTK());
        assertEquals("Thessalonikh",acc.getCity());
        assertEquals("New description",acc.getDescription());
        assertEquals("New address",acc.getAddress());
    }

    @Test
    public void getAllRatingsNumber() {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        Hotel ac=service.getHotel("This is a name");
        ac.addRating("This works",5,"Makis","19/11/2022","mk");
        service.addAccommodation("h","New name","New address","654321","Thessalonikh","New description");
        ac=service.getHotel("New name");
        ac.addRating("This works",4,"Makis","19/11/2022","mk");
        assertEquals(2,service.getAllRatingsNumber());

    }

    @Test
    public void getAllAccommodationsGrades() {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        Hotel ac=service.getHotel("This is a name");
        ac.addRating("This works",5,"Makis","19/11/2022","mk");
        service.addAccommodation("h","New name","New address","654321","Thessalonikh","New description");
        ac=service.getHotel("New name");
        ac.addRating("This works",4,"Makis","19/11/2022","mk");
        assertEquals(4.5,service.getAllAccommodationsGrades(),0.1);
    }

    @Test
    public void showOwned() {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        Hotel ac=service.getHotel("This is a name");
        ac.addRating("This works",5,"Makis","19/11/2022","mk");
        service.addAccommodation("h","New name","New address","654321","Thessalonikh","New description");
        String expected="Accommodation Type: Hotel\n" + "UID:h#Makis#This is a name\n" + "Name:       This is a name\n" + "Address:    Address\n" + "TK:         214365\n" + "City:       Athens\n" + "Description:Its a hotel\n" + "Owner:      Makis\n" + "Properties:\n" + "|parking: none|view: none|entertainment: none|laundry: none|kitchen_room: none|outside: none|heating: none|bath: none|internet: none|\n" + "Number of ratings:1\n" + "Average ratings:5.0\n" + "\n" + "Stars:      0\n" + "floors:     1\n" + "Has Suite:  false\n" + "Ratings:19/11/2022 | mk | 5/5 stars\n" + "This works\n" + "\n" + "\n" + "Accommodation Type: Hotel\n" + "UID:h#Makis#New name\n" + "Name:       New name\n" + "Address:    New address\n" + "TK:         654321\n" + "City:       Thessalonikh\n" + "Description:New description\n" + "Owner:      Makis\n" + "Properties:\n" + "|parking: none|view: none|entertainment: none|laundry: none|kitchen_room: none|outside: none|heating: none|bath: none|internet: none|\n" + "Number of ratings:0\n" + "Average ratings:0.0\n" + "\n" + "Stars:      0\n" + "floors:     1\n" + "Has Suite:  false\n" + "Ratings:\n" + "\n" + "\n";
        assertEquals(expected,service.showOwned());


    }

    @Test
    public void deleteAccommodation() {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        assertNotNull(service.getHotel("This is a name"));
        service.deleteAccommodation("This is a name","h");
        assertNull(service.getHotel("This is a name"));
    }

    @Test
    public void getApartment() {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("a","This is a name","Address","214365","Athens","Its a hotel");
        assertNotNull(service.getApartment("This is a name"));

    }

    @Test
    public void getHotel() {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        assertNotNull(service.getHotel("This is a name"));
    }

    @Test
    public void getMaisonette() {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("m","This is a name","Address","214365","Athens","Its a hotel");
        assertNotNull(service.getMaisonette("This is a name"));
    }

    @Test
    public void destructor() throws FileNotFoundException {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        service.destructor();
        service=new Provider("Makis","mk");
        assertNotNull(service.getHotel("This is a name"));
    }

    @Test
    public void getNames() {
        Provider service=new Provider("Makis","mk");
        service.addAccommodation("m","This is a name","Address","214365","Athens","Its a hotel");
        String[] s=service.getNames();
        String exp="This is a name#Maisonette#Athens#0.0";
        assertEquals(exp,s[0]);
        assertTrue(s.length==1);
    }
}