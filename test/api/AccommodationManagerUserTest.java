package api;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

public class AccommodationManagerUserTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("accommodations.dat");
        pw.close();
    }

    @Test
    public void findProperties() throws FileNotFoundException {
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.updateProperty("someGuy","three-story building in Antigonidon(Hotel)","view","Sea");
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Hotel", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Apartment", "three-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.updateProperty("someGuy","three-story building in Antigonidon(Apartment)","view","Sea");
        AMP.updateProperty("someGuy","three-story building in Antigonidon(Apartment)","internet","fast");
        AMP.updateProperty("someGuy","three-story building in Antigonidon(Apartment)","laundry","yes");
        AMP.addAccommodation("Apartment", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Maisonette", "three-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Maisonette", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Maisonette", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.updateProperty("someGuy3","5-story building in Antigonidon(Maisonette)","view","Sea");
        AMP.updateProperty("someGuy3","5-story building in Antigonidon(Maisonette)","laundry","yes");
        AMP.destructor();
        AccommodationManagerUser AM = new AccommodationManagerUser();
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
    public void findName() throws FileNotFoundException {
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "three-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Hotel", "5-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Apartment", "three-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Apartment", "5-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Maisonette", "three-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Maisonette", "4-story building in Antigonidon", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Maisonette", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.destructor();
        AccommodationManagerUser AM = new AccommodationManagerUser();
        String[][] n=AM.findName("three-story building in Antigonidon");
        System.out.println(Arrays.deepToString(n));
        n=AM.findName("5-story building in Antigonidon(Maisonette)");
        System.out.println(Arrays.deepToString(n));

    }

    @Test
    public void findType() throws FileNotFoundException {
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Hotel", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Apartment", "three-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Apartment", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Maisonette", "three-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Maisonette", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Maisonette", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.destructor();
        AccommodationManagerUser AM = new AccommodationManagerUser();
        String[][] n=AM.findType("Hotel");
        System.out.println(Arrays.deepToString(n));

    }
    @Test
    public void findLocation() throws FileNotFoundException {
        AccommodationManagerProvider AMP = new AccommodationManagerProvider();
        AMP.addAccommodation("Hotel", "three-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Athens", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Hotel", "4-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Hotel", "5-story building in Antigonidon(Hotel)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Apartment", "three-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Apartment", "4-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Athens", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Apartment", "5-story building in Antigonidon(Apartment)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy3");
        AMP.addAccommodation("Maisonette", "three-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy");
        AMP.addAccommodation("Maisonette", "4-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Thessalonikh", "A three story building in Thessaloniki", "someGuy2");
        AMP.addAccommodation("Maisonette", "5-story building in Antigonidon(Maisonette)", "Κέντρο", "123456", "Athens", "A three story building in Thessaloniki", "someGuy3");
        AMP.destructor();
        AccommodationManagerUser AM = new AccommodationManagerUser();
        String[][] n=AM.findLocation("Athens");
        System.out.println(Arrays.deepToString(n));
    }
}