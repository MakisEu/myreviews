package api;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("accommodations.dat");
        pw.close();
    }

    @Test
    public void getName() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("a","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        assertEquals("mk",user.getName());
    }

    @Test
    public void getUsername() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("a","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        assertEquals("Makis",user.getUsername());
    }

    @Test
    public void addRating() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        assertTrue(!user.AddRating("h#someGuy#This is a name","This is good",5));
    }

    @Test
    public void getApartment() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("a","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        assertNotNull(user.getApartment("someGuy","This is a name"));
    }

    @Test
    public void getHotel() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        assertNotNull(user.getHotel("someGuy","This is a name"));
    }

    @Test
    public void getMaisonette() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("m","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        assertNotNull(user.getMaisonette("someGuy","This is a name"));
    }

    @Test
    public void editRating() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        user.AddRating("h#someGuy#This is a name","This is good",5);
        assertTrue(!user.EditRating("h#someGuy#This is a name","This is bad",3));
    }

    @Test
    public void deleteRating() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        user.AddRating("h#someGuy#This is a name","This is good",5);
        assertTrue(!user.DeleteRating("h#someGuy#This is a name"));
    }

    @Test
    public void allRatings() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        user.AddRating("h#someGuy#This is a name","This is good",5);
        String[] s=user.allRatings();
        String expected="This is a name,Hotel,someGuy,Athens,5.0";
        assertEquals(expected,s[0]);

    }

    @Test
    public void destructor() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        user.AddRating("h#someGuy#This is a name","This is good",5);
        user.destructor();
        user=new User("Makis","mk");
        Hotel h=user.getHotel("someGuy","This is a name");
        assertNotNull(h.getRating("Makis"));

    }

    @Test
    public void getMean() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        User user=new User("Makis","mk");
        user.AddRating("h#someGuy#This is a name","This is good",5);
        assertEquals(5,user.getMean(),0.01);
    }
}