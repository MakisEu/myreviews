package api;

public class Properties {
    private String view,bath,laundry,entertainment,heating,internet,kitchen_room,outside,parking;

    public String getView(){
        return view;
    }

    public String getBath(){
        return bath;
    }

    public String getLaundry(){
        return laundry;
    }

    public String getEntertainment(){
        return entertainment;
    }

    public String getHeating(){
        return heating;
    }

    public String getInternet(){
        return internet;
    }

    public String getKitchen_room(){
        return kitchen_room;
    }

    public String getOutside(){
        return outside;
    }

    public String getParking(){
        return parking;
    }

    public void setBath(String bath){
        this.bath=bath;
    }

    public void setLaundry(String laundry){
        this.laundry=laundry;
    }

    public void setView(String view){
        this.view=view;
    }

    public void setHeating(String heating){
        this.heating=heating;
    }

    public void setInternet(String internet){
        this.internet=internet;
    }

    public void setKitchen_room(String kitchen_room){
        this.kitchen_room=kitchen_room;
    }

    public void setOutside(String outside){
        this.outside=outside;
    }

    public void setParking(String parking){
        this.parking=parking;
    }

    public void setEntertainment(String entertainment) {
        this.entertainment = entertainment;
    }
}
