package api;

import org.junit.Test;

import static org.junit.Assert.*;

public class Helper2Test {

    @Test
    public void setApartment() {
        Apartment instance = new Apartment("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        Helper2 h=new Helper2();
        h.setApartment("4","3","true","true",instance);
        assertEquals(4,instance.getFloor());
        assertEquals(3,instance.getSpace());
        assertEquals(true,instance.isGuard());
        assertEquals(true,instance.isElevator());
    }

    @Test
    public void setHotel() {
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        Helper2 h=new Helper2();
        h.setHotel("4","3","true",instance);
        assertEquals(4,instance.getStars());
        assertEquals(3,instance.getFloors());
        assertEquals(true,instance.isHasSuite());
    }

    @Test
    public void setMaisonette() {
        Maisonette instance = new Maisonette("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        Helper2 h=new Helper2();
        h.setMaisonette("4",instance);
        assertEquals(4,instance.getRoommates());
    }
}