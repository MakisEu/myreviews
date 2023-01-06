package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AllRegisteredTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("Accounts.dat");
        pw.close();

    }

    @Test
    public void add_registration(){
        System.out.println("add a registration");
        AllRegistered R=new AllRegistered();
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        R.add_registration("FranzLiszt","piano123","Franz","Liszt","User");
        //Registration expected=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        String expected="Liszt";
        R.add_registration("someGuy","1234567","SG","someOtherGuy","Provider");
        assertEquals(expected,reg.getSurname());

    }


    @Test
    public void contains() {
        System.out.println("Contains registration");
        AllRegistered R=new AllRegistered();
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        R.add_registration("FranzLiszt","piano123","Franz","Liszt","User");
        //Registration expected=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        String expected="Liszt";
        R.add_registration("someGuy","1234567","SG","someOtherGuy","Provider");
        assertEquals(true,R.contains("someGuy"));
    }

    @Test
    public void getUserRegistration() {
        System.out.println("Get registration");
        AllRegistered R=new AllRegistered();
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        R.add_registration("FranzLiszt","piano123","Franz","Liszt","User");
        assertNotNull(R.getUserRegistration("FranzLiszt"));
    }
}