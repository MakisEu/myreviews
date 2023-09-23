package api;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class UserSubTest {

    @Before
    public void setUp() throws Exception {
        PrintWriter pw = new PrintWriter("Database/accommodations.dat");
        pw.close();
    }
    @Test
    public void search() throws FileNotFoundException {
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("h","This is a name","Address","214365","Athens","Its a hotel");
        p.destructor();
        UserSub user=new UserSub("Makis","mk");
        String[] prop=new String[2];
        prop[0]="";
        String expected="someGuy#This is a name#Hotel";
        String[] s=user.Search("","","This is a name",prop);
        assertEquals(expected,s[0]);
    }
}