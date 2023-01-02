package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HelperTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void updateProperties() {
        Hotel instance = new Hotel("three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh","someGuy",4,6,true);
        Helper h=new Helper();
        String[] s=new String[2];
        s[0]="view-sea";
        s[1]="internet-fast";
        h.updateProperties(instance,s);
        String expected="sea";
        assertEquals(expected,instance.getProperty("view"));
        expected="fast";
        assertEquals(expected,instance.getProperty("internet"));
    }

    @Test
    public void addProperties() {
        Helper h=new Helper();
        String[] s=new String[2];
        Provider p=new Provider("someGuy","SG");
        p.addAccommodation("h","three-story building in Antigonidon","Κέντρο","123456","Thessalonikh","A three story building in Thessalonikh");
        s[0]="view-sea";
        s[1]="internet-fast";
        h.AddProperties("h",p,"three-story building in Antigonidon",s);
        String expected="sea";
        assertEquals(expected,p.getHotel("three-story building in Antigonidon").getProperty("view"));
        expected="fast";
        assertEquals(expected,p.getHotel("three-story building in Antigonidon").getProperty("internet"));
    }

    @Test
    public void getTitle() {
        Helper h=new Helper();
        String expected="Hotel";
        assertEquals(expected,h.getTitle("h"));
        expected="Apartment";
        assertEquals(expected,h.getTitle("a"));
        expected="Maisonette";
        assertEquals(expected,h.getTitle("m"));

    }

    @Test
    public void UIDResolve() {

    }
}