package api;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PropertiesTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void add_property(){
        System.out.println("add a property");
        Properties property=new Properties();
        property.add_property("View","Sea");
        String expected="Sea";
        assertEquals(expected,property.getProperties("View"));
    }



}
