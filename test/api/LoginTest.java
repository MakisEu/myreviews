package api;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;

import static org.junit.Assert.*;

public class LoginTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("accommodations.dat");
        pw.close();
    }
    @Test
    public void log_in() {
        System.out.println("add a registration");
        AllRegistered R=new AllRegistered();
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        R.add_registration("FranzLiszt","piano123","Franz","Liszt","User");
        //Registration expected=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        String expected="Provider#SG";
        R.add_registration("someGuy","1234567","SG","someOtherGuy","Provider");
        Login l=new Login();
        String s=l.log_in("someGuy","1234567");
        assertEquals(expected,s);
    }
}