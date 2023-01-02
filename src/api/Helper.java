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
    /*public Accommodation Change(String type,String name,Provider service,String[] change,boolean command){
        Accommodation acc = null;
        switch (type) {
            case "a":

                Apartment a = service.getApartment(name);
                if (a != null) {
                    if (command) {
                        new Helper2().setApartment(change[0], change[1], change[2], change[3], a);
                    }
                    acc = a;
                } else {
                    return null;
                    //JOptionPane.showMessageDialog(this, "ACCOMMODATION NOT FOUND. PLEASE CHECK THAT THE UID IS CORRECT", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "h":

                Hotel h = service.getHotel(name);
                if (h != null) {
                    if (command) {
                        new Helper2().setHotel(change[0], change[1], change[2], h);
                    }
                    acc = h;
                } else {
                    return null;
                    //JOptionPane.showMessageDialog(this, "ACCOMMODATION NOT FOUND. PLEASE CHECK THAT THE UID IS CORRECT", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                }

                break;
            case "m":

                Maisonette m = service.getMaisonette(name);
                if (m != null) {
                    if (command) {
                        new Helper2().setMaisonette(change[0], m);
                    }
                    acc = m;
                } else {
                    return null;
                    //JOptionPane.showMessageDialog(this, "ACCOMMODATION NOT FOUND. PLEASE CHECK THAT THE UID IS CORRECT", "ERROR!!!", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
        return acc;
    }*/
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
    /*public String UIDResolve(String uid){
        return uid.split("#")[1]+"#"+uid.split("#")[2];
    }*/
}
