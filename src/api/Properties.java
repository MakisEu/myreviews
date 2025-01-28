package api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Properties implements Serializable {

    /**Variables in Properties class:
     * properties     A hashmap that contains all the accommodation's properties
     */
    private final HashMap<String,String> properties;

    /**
     * Normal Constructor:
     * initialises all hashmaps elements to "none"
     */
    public Properties(){
        properties=new HashMap<>();
        properties.put("view","none");
        properties.put("bath","none");
        properties.put("laundry","none");
        properties.put("entertainment","none");
        properties.put("heating","none");
        properties.put("internet","none");
        properties.put("kitchen_room","none");
        properties.put("outside","none");
        properties.put("parking","none");
    }

    /**
     * Method that add a property to the hashmap
     * @param key   The hashmap's key
     * @param value    The hashmap's value
     */
    public void add_property(String key,String value){
        properties.put(key,value);
    }

    /**
     * Getter for properties
     * @param key The hashmap's key
     * @return The value of the hashmap for our provided key
     */
    public String getProperties(String key){
        return properties.get(key);
    }

    /**
     * Method that finds all the properties of an accommodation
     * @return A string array with all the properties of the accommodation
     */
    public String show_properties(){
        StringBuilder x= new StringBuilder("|");
        for (Map.Entry<String,String> e:properties.entrySet())
            {
                x.append(e.getKey()).append(": ").append(e.getValue()).append("|");
            }
        return x.toString();
    }










}
