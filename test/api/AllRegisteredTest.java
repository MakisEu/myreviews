package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AllRegisteredTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void add_registration(){
        System.out.println("add a registration");
        AllRegistered R=new AllRegistered();
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        R.add_registration("FranzLiszt","piano123","Franz","Liszt","User");
        //Registration expected=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        String expected="Liszt";
        assertEquals(expected,reg.getSurname());

    }





}