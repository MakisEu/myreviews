package api;


public class Helper {

    public  void updateProperties(Accommodation acc,String[] pr){
        if(pr.length>1){
            for (String pro:pr){
                String[] keyval=pro.split("-");
                acc.updateProperty(keyval[0],keyval[1]);
            }
        }
    }
    public Accommodation AddProperties(String type,Provider service,String name,String[] prop){
        Accommodation ac = null;
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
        return ac;
    }
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
