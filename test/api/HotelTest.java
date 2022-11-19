package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HotelTest {

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void getStars() {
        System.out.println("Get Stars:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        int expected=4;
        assertEquals(expected,instance.getStars());
    }

    @Test
    public void getFloors() {
        System.out.println("Get Floors:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        int expected=6;
        assertEquals(expected,instance.getFloors());
    }

    @Test
    public void isHasSuite() {
        System.out.println("It has Suite:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        boolean expected=true;
        assertEquals(expected,instance.isHasSuite());
    }

    @Test
    public void setStars() {
        System.out.println("Set Stars:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        instance.setStars(3);
        int expected=3;
        assertEquals(expected,instance.getStars());

    }

    @Test
    public void setFloors() {
        System.out.println("Set Floors:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        instance.setFloors(9);
        int expected=9;
        assertEquals(expected,instance.getFloors());
    }

    @Test
    public void setHasSuite() {
        System.out.println("Set Suite:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        instance.setHasSuite(false);
        boolean expected=false;
        assertEquals(expected,instance.isHasSuite());
    }

    @Test
    public void show() {
        System.out.println("Show:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        instance.show();
    }
}