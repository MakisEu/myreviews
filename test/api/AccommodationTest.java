package api;

import org.junit.Before;
import org.junit.Test;

public class AccommodationTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addRating() {
            System.out.println("Add Rating:");
            Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
            instance.addRating("Its good!!!",4,"Makis");
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
        instance.show();
        instance.setAddress("Center");
        instance.show();
    }

    @Test
    public void setTK() {
        System.out.println("Set TK:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.show();
        instance.setTK("654321");
        instance.show();
    }

    @Test
    public void setCity() {
        System.out.println("Set City:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.show();
        instance.setCity("Athens");
        instance.show();
    }

    @Test
    public void setDescription() {
        System.out.println("Set Description:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.show();
        instance.setDescription("A four strorie building in Thessalonikh");
        instance.show();
    }

    @Test
    public void setOwner() {
        System.out.println("Set Owner:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.show();
        instance.setOwner("Dimitris");
        instance.show();
    }

    @Test
    public void getAddress() {
        System.out.println("Get Address:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        System.out.println(instance.getAddress());
    }

    @Test
    public void getTK() {
        System.out.println("Get TK:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        System.out.println(instance.getTK());
    }

    @Test
    public void getOwner() {
        System.out.println("Get Owner:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        System.out.println(instance.getOwner());
    }

    @Test
    public void getName() {
        System.out.println("Get Name:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        System.out.println(instance.getName());
    }

    @Test
    public void getCity() {
        System.out.println("Get City:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        System.out.println(instance.getCity());
    }

    @Test
    public void getDescription() {
        System.out.println("Get Description:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        System.out.println(instance.getDescription());
    }

    @Test
    public void editRating() {
    }

    @Test
    public void setProperties() {
    }
}