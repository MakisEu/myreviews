package api;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;

import static org.junit.Assert.*;

public class MaisonetteTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("accommodations.dat");
        pw.close();
    }

    @Test
    public void getRoommates() {
        System.out.println("Get Roommates:");
        Maisonette instance = new Maisonette("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",2);
        int expected=2;
        assertEquals(expected,instance.getRoommates());
    }

    @Test
    public void setRoommates() {
        System.out.println("Set Roommates:");
        Maisonette instance = new Maisonette("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",2);
        instance.setRoommates(4);
        int expected=4;
        assertEquals(expected,instance.getRoommates());
    }

    @Test
    public void show() {
        System.out.println("Show:");
        Maisonette instance = new Maisonette("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.show();
    }
}