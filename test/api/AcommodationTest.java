package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AcommodationTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void addRating() {
            System.out.println("Add Rating:");
            Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
            instance.addRating("Its good!!!",4,"Makis");
            instance.show();
    }

    @Test
    public void show() {
        System.out.println("Show:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        instance.show();
    }
    @Test
    public void setAddress() {
        System.out.println("Set Address:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        instance.show();
        instance.setAddress("Center");
        instance.show();
    }

    @Test
    public void setTK() {
        System.out.println("Set TK:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        instance.show();
        instance.setTK("654321");
        instance.show();
    }

    @Test
    public void setCity() {
        System.out.println("Set City:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        instance.show();
        instance.setCity("Athens");
        instance.show();
    }

    @Test
    public void setDescription() {
        System.out.println("Set Description:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        instance.show();
        instance.setDescription("A four strorie building in thessalonikh");
        instance.show();
    }

    @Test
    public void setOwner() {
        System.out.println("Set Owner:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        instance.show();
        instance.setOwner("Dimitris");
        instance.show();
    }

    @Test
    public void getAddress() {
        System.out.println("Get Address:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        System.out.println(instance.getAddress());
    }

    @Test
    public void getTK() {
        System.out.println("Get TK:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        System.out.println(instance.getTK());
    }

    @Test
    public void getOwner() {
        System.out.println("Get Owner:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        System.out.println(instance.getOwner());
    }

    @Test
    public void getName() {
        System.out.println("Get Name:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        System.out.println(instance.getName());
    }

    @Test
    public void getCity() {
        System.out.println("Get City:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        System.out.println(instance.getCity());
    }

    @Test
    public void getDescription() {
        System.out.println("Get Description:");
        Acommodation instance = new Acommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three storie building in thessalonikh","someGuy");
        System.out.println(instance.getDescription());
    }

    @Test
    public void editRating() {
    }

    @Test
    public void setProperties() {
    }
}