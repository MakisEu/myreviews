package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void getStars() {
        System.out.println("Get Stars:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        System.out.println(instance.getStars());
    }

    @Test
    public void getFloors() {
        System.out.println("Get Floors:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        System.out.println(instance.getFloors());
    }

    @Test
    public void isHasSuite() {
        System.out.println("It has Suite:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        System.out.println(instance.isHasSuite());
    }

    @Test
    public void setStars() {
        System.out.println("Set Stars:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        System.out.println(instance.getStars());
        instance.setStars(3);
        System.out.println(instance.getStars());

    }

    @Test
    public void setFloors() {
        System.out.println("Set Floors:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        System.out.println(instance.getFloors());
        instance.setFloors(9);
        System.out.println(instance.getFloors());
    }

    @Test
    public void setHasSuite() {
        System.out.println("Set Suite:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        System.out.println(instance.isHasSuite());
        instance.setHasSuite(false);
        System.out.println(instance.isHasSuite());
    }

    @Test
    public void show() {
        System.out.println("Show:");
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        instance.show();
    }
}