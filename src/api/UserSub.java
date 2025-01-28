package api;

import java.util.ArrayList;

public class UserSub {
    /**
     * All the Variables in the User class:
     * amu              AccommodationManagerUser object
     * name             The name of a user
     * username         The username of a user
     */
    AccommodationManagerUser amu;
    String name,username;

    /**
     * Normal constructor:
     * @param n The name
     * @param u The username
     */
    public UserSub(String u,String n){
        name=n;
        username=u;
        amu=new AccommodationManagerUser();
    }

    /**
     * Method that Searches and returns all the accommodations with same characteristics with the parameters
     * @param city The city of the accommodation
     * @param type The type of the accommodation
     * @param name The name of the accommodation
     * @param prop The properties of the accommodation
     * @return A string array with the accommodations with the preferred characteristics
     */
    public String[] Search(String city,String type,String name,String[] prop){
        ArrayList<ArrayList<String>> current=null,temp;

        if (city.length()>1){
            temp=amu.findLocation(city);
                current= (ArrayList<ArrayList<String>>) temp.clone();
        }
        if(prop[0].length()>2) {
            System.out.println(prop[0]);
            String[] a1 = new String[prop.length], a2 = new String[prop.length];
            int c=0;
            for (String s: prop){
                a1[c]=s.split("-")[0];
                a2[c]=s.split("-")[1];
                c++;
            }
            temp=amu.findProperties(a1,a2);
            if (current==null){
                current= (ArrayList<ArrayList<String>>) temp.clone();
            }
            else{
                current.get(0).retainAll(temp.get(0));
                current.get(1).retainAll(temp.get(1));
                current.get(2).retainAll(temp.get(2));
            }

        }
        if(name.length()>1){
            temp=amu.findName(name);
            if (current==null){
                current= (ArrayList<ArrayList<String>>) temp.clone();
            }
            else{
                current.get(0).retainAll(temp.get(0));
                current.get(1).retainAll(temp.get(1));
                current.get(2).retainAll(temp.get(2));
            }
        }
        if (type.length()>1){
            if (current==null){
                temp=amu.findType(type);
                current= (ArrayList<ArrayList<String>>) temp.clone();
            }
            else{
                return (current.get(this.getTypeIndex(type)).toArray(new String[0]));
            }
        }
        ArrayList <String> ar=new ArrayList<>();
        if (current==null){return null;}
        if (current.get(0)!=null) {
            for (String s : current.get(0)) {
                ar.add(s + "#Apartment");
            }
        }
        if (current.get(1)!=null) {
            for (String s : current.get(1)) {
                ar.add(s + "#Hotel");
            }
        }
        if (current.get(2)!=null) {
            for (String s : current.get(2)) {
                ar.add(s + "#Maisonette");
            }
        }
        return ar.toArray(new String[0]);
    }

    /**
     * Gets the index of a type
     * @param type The type of the index it will be returned
     * @return      The index of the type
     */
    public int getTypeIndex(String type){
        if (type.equals("Hotel")){
            return 1;
        } else if (type.equals("Apartment")) {
            return 0;
        } else if (type.equals("Maisonette")) {
            return 2;
        }
        else{
            return 999;
        }
    }
}
