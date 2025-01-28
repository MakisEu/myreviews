package api;


public class Helper {

    /**
     * This method updates the properties of an accommodation
     *  @param acc The Accommodation that will be updated
     *  @param pr The properties-values that will be updated
     *  */
    public  void updateProperties(Accommodation acc,String[] pr){
        if(pr.length>=1 && pr[0].contains("-")){
            for (String pro:pr){
                String[] keyval=pro.split("-");
                acc.updateProperty(keyval[0],keyval[1]);
            }
        }
    }
    /**
     * This method adds properties to accommodation of Provider
     *  @param type The type of accommodation
     *  @param service The Provider that has the accommodation
     *  @param name The name of the accommodation
     *  @param prop The properies-values that will be updated
     *  */
    public void AddProperties(String type,Provider service,String name,String[] prop){
        Accommodation ac;
        switch (type) {
            case "a":
                ac = service.getApartment(name);
                new Helper().updateProperties(ac, prop);
                break;
            case "h":
                ac = service.getHotel(name);
                new Helper().updateProperties(ac, prop);
                break;
            case "m":
                ac = service.getMaisonette(name);
                new Helper().updateProperties(ac, prop);
                break;
        }
    }
    /**
     * This method gets the title of accommodation from the first letter of the type
     *  @param type The type of accommodation
     *  @return the title of the type of accommodation
     *  */
    public String getTitle(String type){
        switch (type) {
            case "a":
                return "Apartment";
            case "h":
                return "Hotel";
            case "m":
                return "Maisonette";
        }
        return null;
    }
}
