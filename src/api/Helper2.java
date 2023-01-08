package api;

public class Helper2 {
    /**
     * This method set the special properties of an apartment
     * @param floor The floor that the apartment is on
     * @param space The number of people the apartment can house
     * @param guard The apartment has guard
     * @param el The apartment has elevator
     * @param a The apartment that will be edited
     *  */
    public void setApartment(String floor,String space,String guard,String el,Apartment a){
        if (floor.length()>=1){
            a.setFloor(Integer.parseInt(floor));
        }
        if (space.length()>=1){
            a.setSpace(Integer.parseInt(space));
        }
        if (guard.length()>=1){
            if (guard.equalsIgnoreCase("true")) {
                a.setGuard(true);
            } else if (guard.equalsIgnoreCase("false")) {
                a.setGuard(false);
            }else {System.out.println("Error, not valid boolean type");}
        }
        if (el.length()>=1){
            if (el.equalsIgnoreCase("true")) {
                a.setElevator(true);
            } else if (el.equalsIgnoreCase("false")) {
                a.setElevator(false);
            }else {System.out.println("Error, not valid boolean type");}
        }
    }
    /**
     * This method set the special properties of a hotel
     * @param stars  The stars the hotel has
     * @param floor The floors the hotel has
     * @param suite The hotel has suite
     * @param h The hotel that will be edited
     *  */
    public void setHotel(String stars,String floor,String suite,Hotel h){
        if (stars.length()>=1){
            h.setStars(Integer.parseInt(stars));
        }
        if (floor.length()>=1){
            h.setFloors(Integer.parseInt(floor));
        }
        if (suite.length()>=1){
            if (suite.equalsIgnoreCase("true")) {
                h.setHasSuite(true);
            } else if (suite.equalsIgnoreCase("false")) {
                h.setHasSuite(false);
            }else {System.out.println("Error, not valid boolean type");}
        }
    }
    /**
     * This method set the special properties of a maisonette
     * @param roommates    The number of roommates in the accommodation
     * @param m The Maisonette that will be edited

     *  */
    public void setMaisonette(String roommates,Maisonette m){
        if (roommates.length()>=1){
            m.setRoommates(Integer.parseInt(roommates));
        }
    }
}
