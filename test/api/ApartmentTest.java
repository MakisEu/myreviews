package api;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;

import static org.junit.Assert.*;

public class ApartmentTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("Database/accommodations.dat");
        pw.close();
    }

    @Test
    public void isGuard() {
            System.out.println("It has Guard:");
            Apartment instance = new Apartment("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,3,true,true);
            boolean expected=true;
            assertEquals(expected,instance.isGuard());
    }

    @Test
    public void setGuard() {
        Apartment instance = new Apartment("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,3,true,true);
        instance.setGuard(false);
        boolean expected=false;
        assertEquals(expected,instance.isGuard());
    }

    @Test
    public void isElevator() {
        Apartment instance = new Apartment("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,3,true,true);
        boolean expected=true;
        assertEquals(expected,instance.isElevator());
    }

    @Test
    public void setElevator() {
        Apartment instance = new Apartment("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,3,true,true);
        instance.setElevator(false);
        boolean expected=false;
        assertEquals(expected,instance.isElevator());
    }

    @Test
    public void getFloor() {
        Apartment instance = new Apartment("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,3,true,true);
        int expected=4;
        assertEquals(expected,instance.getFloor());
    }

    @Test
    public void setFloor() {
        Apartment instance = new Apartment("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,3,true,true);
        instance.setFloor(7);
        int expected=7;
        assertEquals(expected,instance.getFloor());
    }

    @Test
    public void getSpace() {
        Apartment instance = new Apartment("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,3,true,true);
        int expected=3;
        assertEquals(expected,instance.getSpace());
    }

    @Test
    public void setSpace() {
        Apartment instance = new Apartment("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,3,true,true);
        instance.setSpace(4);
        int expected=4;
        assertEquals(expected,instance.getSpace());
    }

    @Test
    public void show() {
        System.out.println("Show:");
        Apartment instance = new Apartment("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.show();
    }
}