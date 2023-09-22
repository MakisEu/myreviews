package api;

import java.util.Arrays;
import java.util.Map;

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
    public String[][] findProperties(String[] argv,String[] argv2) {
        int n = argv.length,cnt=0;
        String[] a=new String[apartments.size()],h=new String[hotels.size()],m=new String[maisonettes.size()];
        boolean g;
        for (Map.Entry<String,Apartment> entry:apartments.entrySet()) {
            Apartment value=entry.getValue();
            g=true;
            for (int i=0;i<n && g;i++){
                g=value.getProperty(argv[i]).equals(argv2[i]);
            }
            if (g){
                a[cnt]=value.getOwner()+"#"+value.getName();
            }
            else{
                a[cnt]=null;
            }
            cnt++;
        }
        cnt=0;
        for (Map.Entry<String,Hotel> entry:hotels.entrySet()) {
            Hotel value=entry.getValue();
            g=true;
            for (int i=0;i<n && g;i++){
                g=value.getProperty(argv[i]).equals(argv2[i]);
            }
            if (g){
                h[cnt]=value.getOwner()+"#"+value.getName();
            }
            else{
                h[cnt]=null;
            }
            cnt++;
        }
        cnt=0;
        for (Map.Entry<String,Maisonette> entry:maisonettes.entrySet()) {
            Maisonette value=entry.getValue();
            g=true;
            for (int i=0;i<n && g;i++){
                g=value.getProperty(argv[i]).equals(argv2[i]);
            }
            if (g){
                m[cnt]=value.getOwner()+"#"+value.getName();
            }
            else{
                m[cnt]=null;
            }
            cnt++;
        }
        String[][] b=new String[3][];
        b[0]=a;
        b[1]=h;
        b[2]=m;
        return b;
    }
    /**
     * @param name the name of the accommodation
     * @return String[][] of all the accommodation with the specified name
     * */
    public String[][] findName(String name) {
        int cnt=0;
        String[] a=new String[apartments.size()],h=new String[hotels.size()],m=new String[maisonettes.size()];
        for (Map.Entry<String,Apartment> entry:apartments.entrySet()) {
            Apartment value=entry.getValue();
            if (value.getName().equals(name)) {
                a[cnt] = value.getOwner() + "#" + value.getName();
            }
            else{
                a[cnt]=null;
            }
            cnt++;
        }
        cnt=0;
        for (Map.Entry<String,Hotel> entry:hotels.entrySet()) {
            Hotel value=entry.getValue();
            if (value.getName().equals(name)){
                h[cnt]=value.getOwner()+"#"+value.getName();
            }
            else {
                h[cnt] = null;
            }
            cnt++;
        }
        cnt=0;
        for (Map.Entry<String,Maisonette> entry:maisonettes.entrySet()) {
            Maisonette value=entry.getValue();
            if (value.getName().equals(name)){
                m[cnt]=value.getOwner()+"#"+value.getName();
            }
            else{
                m[cnt]=null;
            }
            cnt++;
        }
        String[][] b=new String[3][];
        b[0]=a;
        b[1]=h;
        b[2]=m;
        return  b;
    }

    /**
     * @param type the type of the accommodation
     * @return String[][] of all the accommodation with the specified type
     * */
    public String[][] findType(String type) {
        int cnt=0;
        String[] a=new String[apartments.size()],h=new String[hotels.size()],m=new String[maisonettes.size()];
        if (type.equals("Hotel")) {
            for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
                Hotel value=entry.getValue();
                h[cnt]=value.getOwner()+"#"+value.getName();
                cnt++;
            }
        } else if (type.equals("Apartment")) {
            for (Map.Entry<String, Apartment> entry : apartments.entrySet()) {
                Apartment value=entry.getValue();
                a[cnt]=value.getOwner()+"#"+value.getName();
                cnt++;
            }
        } else {
            for (Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
                Maisonette value = entry.getValue();
                m[cnt] = value.getOwner() + "#" + value.getName();
                cnt++;
            }
        }
        String[][] b=new String[3][];
        b[0]=a;
        b[1]=h;
        b[2]=m;
        return b;
    }

    /**
     * @param city the city of the accommodation
     * @return String[][] of all the accommodation with the specified city
     * */
    public String[][] findLocation(String city) {
            int cnt=0;
            String[] a=new String[apartments.size()],h=new String[hotels.size()],m=new String[maisonettes.size()];
            for (Map.Entry<String,Apartment> entry:apartments.entrySet()) {
                Apartment value=entry.getValue();
                if (value.getCity().equals(city)) {
                    a[cnt] = value.getOwner() + "#" + value.getName();
                }
                else{
                    a[cnt]=null;
                }
                cnt++;
            }
            cnt=0;
            for (Map.Entry<String,Hotel> entry:hotels.entrySet()) {
                Hotel value=entry.getValue();
                if (value.getCity().equals(city)){
                    h[cnt]=value.getOwner()+"#"+value.getName();
                }
                else {
                    h[cnt] = null;
                }
                cnt++;
            }
            cnt=0;
            for (Map.Entry<String,Maisonette> entry:maisonettes.entrySet()) {
                Maisonette value=entry.getValue();
                if (value.getCity().equals(city)){
                    m[cnt]=value.getOwner()+"#"+value.getName();
                }
                else{
                    m[cnt]=null;
                }
                cnt++;
            }
            String[][] b=new String[3][];
            b[0]=a;
            b[1]=h;
            b[2]=m;
            return  b;
        }







}
