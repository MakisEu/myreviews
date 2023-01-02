package api;

import java.util.ArrayList;
import java.util.Map;

public class AccommodationManagerProviderSub extends AccommodationManager{
    public ArrayList<Apartment> getOwnedApartments(String owner){
        ArrayList<Apartment> a=new ArrayList<>();
        for(Map.Entry<String, Apartment> entry : apartments.entrySet()) {
            Apartment value=entry.getValue();
            if (value.getOwner().equals(owner)) {
                a.add(value);}}
        return a;
    }
    public ArrayList<Hotel> getOwnedHotels(String owner){
        ArrayList<Hotel> a=new ArrayList<>();
        for(Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            Hotel value=entry.getValue();
            if (value.getOwner().equals(owner)) {
                a.add(value);}}
        return a;
    }
    public ArrayList<Maisonette> getOwnedMaisonettes(String owner){
        ArrayList<Maisonette> a=new ArrayList<>();
        for(Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
            Maisonette value=entry.getValue();
            if (value.getOwner().equals(owner)) {
                a.add(value);}}
        return a;
    }
    public int getRatingsNumber(String owner){
        int sum=0;
        for (Map.Entry<String,Apartment> e:apartments.entrySet())
        {
            if (e.getValue().getOwner().equals(owner))
                sum+=e.getValue().getRatingNumber();
        }
        for (Map.Entry<String,Hotel> e:hotels.entrySet())
        {
            if (e.getValue().getOwner().equals(owner))
                sum+=e.getValue().getRatingNumber();
        }

        for (Map.Entry<String,Maisonette> e:maisonettes.entrySet())
        {
            if (e.getValue().getOwner().equals(owner))
                sum+=e.getValue().getRatingNumber();
        }
        return sum; //returns the number of ratings of all accommodations a user has offered
    }

    public double getRatingAverage(String owner){
        int sum=0,i=0;
        for (Map.Entry<String,Apartment> e:apartments.entrySet())
        {
            if (e.getValue().getOwner().equals(owner)) {
                sum += e.getValue().ratingsSum();
                i+=e.getValue().getRatingNumber();
            }
        }
        for (Map.Entry<String,Hotel> e:hotels.entrySet())
        {
            if (e.getValue().getOwner().equals(owner)) {
                sum += e.getValue().ratingsSum();
                i+=e.getValue().getRatingNumber();

            }
        }
        for (Map.Entry<String,Maisonette> e:maisonettes.entrySet()) {
            if (e.getValue().getOwner().equals(owner)) {
                sum += e.getValue().ratingsSum();
                i+=e.getValue().getRatingNumber();
            }
        }
        if (i==0){return 0;}
        return sum/(double)(i);
    }
    /**
     * Method that returns all accommodations owned by an owner as String
     * @param owner The owner
     */
    public String showOwned(String owner) {
        String x = "";
        for(Map.Entry<String, Apartment> entry : apartments.entrySet()) {
            Apartment value=entry.getValue();
            if (value.getOwner().equals(owner)) {
                x=x+value.show()+"\n\n";}}
        for(Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            Hotel value=entry.getValue();
            if (value.getOwner().equals(owner)) {
                x=x+value.show()+"\n\n";}}
        for(Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
            Maisonette value=entry.getValue();
            if (value.getOwner().equals(owner)) {
                x=x+value.show()+"\n\n";}}
        return x;
    }
}
