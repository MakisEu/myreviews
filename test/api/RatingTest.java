package api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RatingTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getRatingDescription(){
        System.out.println("get Rating");
        Rating rating=new Rating("Pretty good!",4,"user1234","19/11/2022","u1234");
        String expected="Pretty good!";
        assertEquals(expected,rating.getRatingDescription());
    }

    @Test
    public void getGrade(){
        System.out.println("get grade");
        Rating rating=new Rating("Pretty good!",4,"user1234","19/11/2022","u1234");
        float expected=4;
        assertEquals(expected,rating.getGrade(),0.1);
    }

    @Test
    public void getDate(){
        System.out.println("get date");
        Rating rating=new Rating("Pretty good!",4,"user1234","19/11/2022","u1234");
        String expected="19/11/2022";
        assertEquals(expected,rating.getDate());
    }

    @Test
    public void setRatingDescription(){
        System.out.println("set Rating");
        Rating rating=new Rating("Pretty good!",4,"user1234","19/11/2022","u1234");
        rating.setRatingDescription("Pretty good!","19/11/2022");
        String expected="Pretty good!";
        assertEquals(expected,rating.getRatingDescription());
    }

    @Test
    public void setGrade(){
        System.out.println("set grade");
        Rating rating=new Rating("Pretty good!",4,"user1234","19/11/2022","u1234");
        rating.setGrade(4,"19/11/2022");
        float expected=4;
        assertEquals(expected,rating.getGrade(),0.1);
    }

    @Test
    public void setDate(){
        System.out.println("set date");
        Rating rating=new Rating("Pretty good!",4,"user1234","19/11/2022","u1234");
        rating.setDate("19/11/2022");
        String expected="19/11/2022";
        assertEquals(expected,rating.getDate());
    }






}
