package api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static java.util.Collections.sort;

public class AccommodationManagerUser extends AccommodationManagerUserSub{

    /**
     *Constructor:
     */
    public AccommodationManagerUser(){
        super();
    }

    /**
     * @param argv String[] of the name of the properties
     * @param argv2 String[] of the values of the properties
     * @return String[][] of all the accommodation with the required values
     * */
    public ArrayList<ArrayList<String>> findProperties(String[] argv,String[] argv2) {
        int n = argv.length;
        Accommodation value;
        ArrayList<ArrayList<String>> b=new ArrayList<>();
        ArrayList<String> a;
        boolean g;
        for (String type:types) {
            a=new ArrayList<>();
            for (String key : accommodations.get(type).keySet()) {
                value=accommodations.get(type).get(key);
                g=true;
                for (int i=0;i<n && g;i++){
                    g=value.getProperty(argv[i]).equals(argv2[i]);
                }
                if (g){
                    a.add(value.getOwner()+"#"+value.getName());
                }
            }
            b.add((ArrayList<String>) a.clone());
        }
        return b;
    }
    /**
     * @param name the name of the accommodation
     * @return String[][] of all the accommodation with the specified name
     * */
    public ArrayList<ArrayList<String>> findName(String name) {
        Accommodation value;
        ArrayList<ArrayList<String>> b=new ArrayList<>();
        ArrayList<String> a;
        boolean g;
        for (String type:types) {
            a=new ArrayList<>();
            for (String key : accommodations.get(type).keySet()) {
                value=accommodations.get(type).get(key);
                g=value.getName().equals(name);
                if (g) {
                    a.add(value.getOwner() + "#" + value.getName());
                }
            }
            b.add((ArrayList<String>) a.clone());
        }
        return  b;
    }

    /**
     * @param type the type of the accommodation
     * @return String[][] of all the accommodation with the specified type
     * */
    public ArrayList<ArrayList<String>> findType(String type) {
        Accommodation ac;
        ArrayList<ArrayList<String>> b=new ArrayList<>();
        ArrayList<String> a;
        for (String t:types){
            a=new ArrayList<>();
            if (t.equals(type)){
                for (String key: accommodations.get(type).keySet()){
                    ac=accommodations.get(type).get(key);
                    a.add(ac.getOwner()+"#"+ac.getName());
                }

            }
            b.add((ArrayList<String>) a.clone());
        }
        return b;
    }

    /**
     * @param city the city of the accommodation
     * @return String[][] of all the accommodation with the specified city
     * */
    public ArrayList<ArrayList<String>> findLocation(String city) {
        Accommodation value;
        ArrayList<ArrayList<String>> b=new ArrayList<>();
        ArrayList<String> a;
        for(String type:types){
            a=new ArrayList<>();
            for (String key: accommodations.get(type).keySet()){
                value= accommodations.get(type).get(key);
                if (value.getCity().equals(city)) {
                    a.add(value.getOwner() + "#" + value.getName());
                }
            }
            b.add((ArrayList<String>) a.clone());
        }
            return  b;
        }
}
