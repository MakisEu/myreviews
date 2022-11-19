package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccommodationTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addRating() {
            System.out.println("Add Rating:");
            Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
            instance.addRating("Its good!!!",4,"Makis","19/11/2022 20:02");
            instance.show();
    }

    @Test
    public void show() {
        System.out.println("Show:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.show();
    }
    @Test
    public void setAddress() {
        System.out.println("Set Address:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.setAddress("Center");
        String expected="Center";
        assertEquals(expected,instance.getAddress());
    }

    @Test
    public void setTK() {
        System.out.println("Set TK:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.setTK("654321");
        String expected="654321";
        assertEquals(expected,instance.getTK());
    }

    @Test
    public void setCity() {
        System.out.println("Set City:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.setCity("Athens");
        String expected="Athens";
        assertEquals(expected,instance.getCity());
    }

    @Test
    public void setDescription() {
        System.out.println("Set Description:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.setDescription("A four story building in Thessalonikh");
        String expected="A four story building in Thessalonikh";
        assertEquals(expected,instance.getDescription());
    }

    @Test
    public void setOwner() {
        System.out.println("Set Owner:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.setOwner("Dimitris");
        String expected="Dimitris";
        assertEquals(expected,instance.getOwner());
    }

    @Test
    public void getAddress() {
        System.out.println("Get Address:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        String expected="Κέντρο";
        assertEquals(expected,instance.getAddress());
    }

    @Test
    public void getTK() {
        System.out.println("Get TK:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        String expected="123456";
        assertEquals(expected,instance.getTK());
    }

    @Test
    public void getOwner() {
        System.out.println("Get Owner:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        String expected="someGuy";
        assertEquals(expected,instance.getOwner());
    }

    @Test
    public void getName() {
        System.out.println("Get Name:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        String expected="three-story building in Antigonidon";
        assertEquals(expected,instance.getName());
    }

    @Test
    public void getCity() {
        System.out.println("Get City:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        String expected="Thessalonikh";
        assertEquals(expected,instance.getCity());
    }

    @Test
    public void getDescription() {
        System.out.println("Get Description:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        String expected="A three story building in Thessalonikh";
        assertEquals(expected,instance.getDescription());
    }

    @Test
    public void editRating() {
        System.out.println("Edit Rating:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
        instance.addRating("Its good!!!",4,"Makis","19/11/2022 20:02");
        instance.showRatings();
        instance.editRating("Makis","It sucks",1);
        instance.showRatings();

    }
    @Test
    public void deleteRating() {
        System.out.println("Delete Rating:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
        instance.addRating("Its good!!!",4,"Makis","19/11/2022");
        instance.addRating("Its good5!!!",4,"John","20/11/2022");
        instance.showRatings();
        instance.deleteRating("Makis");
        instance.showRatings();
    }
    @Test
    public void setProperties() {
    }
}