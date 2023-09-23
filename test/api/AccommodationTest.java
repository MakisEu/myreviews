package api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;

import static org.junit.Assert.*;

public class AccommodationTest {


    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("Database/accommodations.dat");
        pw.close();
    }

    @Test
    public void addRating() {
            System.out.println("Add Rating:");
            Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
            instance.addRating("Its good!!!",4,"Makis","19/11/2022 20:02","mk");
            instance.show();
    }

    @Test
    public void show() {
        System.out.println("Show:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        System.out.println (instance.show());
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
        instance.addRating("Its good!!!",4,"Makis","19/11/2022 20:02","mk");
        instance.showRatings();
        instance.editRating("Makis","It sucks",1);
        instance.showRatings();

    }
    @Test
    public void deleteRating() {
        System.out.println("Delete Rating:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
        instance.addRating("Its good!!!",4,"Makis","19/11/2022","mk");
        instance.addRating("Its good5!!!",4,"John","20/11/2022","mk");
        instance.showRatings();
        instance.deleteRating("Makis");
        instance.showRatings();
    }
    @Test
    public void updateProperty() {
        System.out.println("Add property:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
        instance.updateProperty("view","good");
        instance.updateProperty("outside","balcony");
        instance.updateProperty("parking","yes");
        instance.show();

    }
    @Test
    public void getRatingNumber(){
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
        instance.addRating("Its good!!!",4,"Makis","19/11/2022 20:02","mk");
        instance.addRating("Its good!!!",2,"John","19/11/2022 20:02","jn");
        assertEquals(2,instance.getRatingNumber());
    }
    @Test
    public void getRatingsAverage(){
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
        instance.addRating("Its good!!!",4,"Makis","19/11/2022 20:02","mk");
        instance.addRating("Its good!!!",2,"John","19/11/2022 20:02","jn");
        assertEquals(3,instance.getRatingsAverage(),0.01);
    }

    @Test
    public void getRating() {
        System.out.println("Add Rating:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
        instance.addRating("Its good!!!",4,"Makis","19/11/2022 20:02","mk");
        assertNotNull(instance.getRating("Makis"));

    }

    @Test
    public void number_of_ratings_of_user() {
        System.out.println("Number of ratings of a user in an accommodation:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
        instance.addRating("Its good!!!",4,"Makis","19/11/2022 20:02","mk");
        assertEquals(1,instance.number_of_ratings_of_user("Makis"));
        assertEquals(0,instance.number_of_ratings_of_user("John"));
    }

    @Test
    public void ratingsSum() {
        System.out.println("Sum of ratings in an accommodation:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessaloniki","someGuy");
        instance.addRating("Its good!!!",4,"Makis","19/11/2022 20:02","mk");
        instance.addRating("Its good!!!",2,"John","19/11/2022 20:02","jn");
        instance.addRating("Its good!!!",1,"Jim","19/11/2022 20:02","jm");
        float expected=7;
        assertEquals(expected,instance.ratingsSum(),0.01);
    }

    @Test
    public void setName() {
        System.out.println("Set Name:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.setName("HI");
        String expected="HI";
        assertEquals(expected,instance.getName());
    }

    @Test
    public void getProperty() {
        System.out.println("Set Name:");
        Accommodation instance = new Accommodation("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy");
        instance.updateProperty("view","Sea");
        assertEquals("Sea",instance.getProperty("view"));

    }
}