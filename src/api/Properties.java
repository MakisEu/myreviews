package api;

import java.util.HashMap;
import java.util.Map;

public class Properties {
    private HashMap<String,String> properties;

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
    public void add_property(String key,String value){
        properties.put(key,value);
    }

    public String getProperties(String key){
        return properties.get(key);
    }

    public void show_properties(){
        int i;
        System.out.print("|");
        for (Map.Entry<String,String> e:properties.entrySet())
            {
                System.out.print(e.getKey()+": "+e.getValue()+"|");
            }
        System.out.println();
    }










}
