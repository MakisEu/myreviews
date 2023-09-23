
package api;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegistrationTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("Database/accommodations.dat");
        pw.close();
    }

    @Test
    public void getUsername(){
        System.out.println("get user's name");
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        String expected="FranzLiszt";
        assertEquals(expected,reg.getUsername());
    }

    @Test
    public void getUserType(){
        System.out.println("get user's type");
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        String expected="User";
        assertEquals(expected,reg.getUserType());
    }

    @Test
    public void getSurname(){
        System.out.println("get user's surname");
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        String expected="Liszt";
        assertEquals(expected,reg.getSurname());
    }

    @Test
    public void getPassword(){
        System.out.println("get user's password");
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        String expected="piano123";
        assertEquals(expected,reg.getPassword());
    }


    @Test
    public void setUsername(){
        System.out.println("set user's username");
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        reg.setUsername("Werner");
        String expected="Werner";
        assertEquals(expected,reg.getUsername());
    }

    @Test
    public void getName() {
        System.out.println("get user's surname");
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        String expected="Franz";
        assertEquals(expected,reg.getName());
    }

    @Test
    public void setName() {
        System.out.println("set user's name");
        Registration reg=new Registration("FranzLiszt","piano123","Franz","Liszt","User");
        reg.setName("Werner");
        String expected="Werner";
        assertEquals(expected,reg.getName());
    }
}
