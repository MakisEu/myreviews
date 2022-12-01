package api;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
        AM.updateProperty("someGuy","three-story building in Antigonidon(Apartment)","view","Sea");
        AM.updateProperty("someGuy","three-story building in Antigonidon(Apartment)","internet","fast");
        AM.updateProperty("someGuy","three-story building in Antigonidon(Apartment)","laundry","yes");
        AM.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Μεζονέτα", "three-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.updateProperty("someGuy3","5-story building in Antigonidon(Maisonette)","view","Sea");
        AM.updateProperty("someGuy3","5-story building in Antigonidon(Maisonette)","laundry","yes");
        String[] keys=new String[1],values=new String[1],split;
        keys[0]="view";
        values[0]="Sea";

        String[][] n=AM.findProperties(keys,values);
        System.out.println(Arrays.deepToString(n));
        keys=new String[2];
        values=new String[2];
        keys[0]="view";
        keys[1]="laundry";
        values[0]="Sea";
        values[1]="yes";
        n=AM.findProperties(keys,values);
        System.out.println(Arrays.deepToString(n));
        keys=new String[3];
        values=new String[3];
        keys[0]="view";
        keys[1]="laundry";
        values[0]="Sea";
        values[1]="yes";
        keys[2]="internet";
        values[2]="fast";
        n=AM.findProperties(keys,values);
        System.out.println(Arrays.deepToString(n));
        /*for (int j=0;j<n[0].length;j++){
            if (n[0][j]!=null){
                split=n[0][j].split("#");
                AM.getApartment(split[0],split[1]).show();}
        }
        for (int j=0;j<n[1].length;j++){
            if (n[1][j]!=null){
                split=n[1][j].split("#");
                AM.getHotel(split[0],split[1]).show();}
        }
        for (int j=0;j<n[2].length;j++){
            if (n[2][j]!=null){
                split=n[2][j].split("#");
                AM.getMaisonette(split[0],split[1]).show();}
        }*/
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
    @Test
    public void findName() {
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addAccommodation("Ξενοδοχείο", "three-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Διαμέρισμα", "three-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Μεζονέτα", "three-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        String[][] n=AM.findName("three-story building in Antigonidon");
        System.out.println(Arrays.deepToString(n));
        n=AM.findName("5-story building in Antigonidon(Maisonette)");
        System.out.println(Arrays.deepToString(n));

    }

    @Test
    public void findType() {
        AccommodationManagerUser AM = new AccommodationManagerUser();
        AM.addAccommodation("Ξενοδοχείο", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Ξενοδοχείο", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Ξενοδοχείο", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Διαμέρισμα", "three-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Διαμέρισμα", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Διαμέρισμα", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AM.addAccommodation("Μεζονέτα", "three-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AM.addAccommodation("Μεζονέτα", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AM.addAccommodation("Μεζονέτα", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        String[][] n=AM.findType("Ξενοδοχείο");
        System.out.println(Arrays.deepToString(n));

    }
}