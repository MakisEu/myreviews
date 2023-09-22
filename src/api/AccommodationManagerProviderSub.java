package api;

import java.util.ArrayList;
import java.util.Map;

public class AccommodationManagerProviderSub extends AccommodationManager{

    /**
     * Method that returns an ArrayList of all the owner's apartments
     * @param owner name of owner
     * @return ArrayList of all owned apartments */
    public ArrayList<Apartment> getOwnedApartments(String owner){
        ArrayList<Apartment> a=new ArrayList<>();
        for(Map.Entry<String, Apartment> entry : apartments.entrySet()) {
            Apartment value=entry.getValue();
            if (value.getOwner().equals(owner)) {
                a.add(value);}}
        return a;
    }
    /**
     * Method that returns an ArrayList of all the owner's hotels
     * @param owner name of owner
     * @return ArrayList of all owned hotels */
    public ArrayList<Hotel> getOwnedHotels(String owner){
        ArrayList<Hotel> a=new ArrayList<>();
        for(Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            Hotel value=entry.getValue();
            if (value.getOwner().equals(owner)) {
                a.add(value);}}
        return a;
    }
    /**
     * Method that returns an ArrayList of all the owner's maisonette
     * @param owner name of owner
     * @return ArrayList of all owned maisonettes */
    public ArrayList<Maisonette> getOwnedMaisonettes(String owner){
        ArrayList<Maisonette> a=new ArrayList<>();
        for(Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
            Maisonette value=entry.getValue();
            if (value.getOwner().equals(owner)) {
                a.add(value);}}
        return a;
    }
    /**
     * Method that returns the number of all ratings of the owner's all accommodations
     * @param owner name of owner
     * @return the number of ratings of all accommodations of an owner */
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
    /**
     * Method that returns the average of all ratings of the owner's all accommodations
     * @param owner name of owner
     * @return the average of all ratings of all accommodations of an owner */
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
