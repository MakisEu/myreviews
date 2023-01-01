package api;

import java.util.Arrays;
import java.util.Map;

public class AccommodationManagerUser extends AccommodationManager{
    public AccommodationManagerUser(){
        super();
    }
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
    public void addRating(String o, String n, String desc, float ra, String user, String date) {
        //System.out.println(o+" "+n+" "+desc+" "+ra+" "+user+" "+date);
        String type = this.getType(o, n);
        System.out.println("all ok");
        switch (type) {
            case "Hotel":
                if (hotels.get(o + n) != null) {
                    hotels.get(o + n).addRating(desc, ra, user, date);
                }
                break;
            case "Apartment":
                if (apartments.get(o + n) != null) {
                    apartments.get(o + n).addRating(desc, ra, user, date);
                }
                break;
            case "Maisonette":
                if (maisonettes.get(o + n) != null) {
                    maisonettes.get(o + n).addRating(desc, ra, user, date);
                }
                break;
        }
    }

    public void editRatings(String o, String n, String desc, float ra, String user) {
        String type = this.getType(o, n);
        switch (type) {
            case "Hotel":
                if (hotels.get(o + n) != null) {
                    hotels.get(o + n).editRating(user, desc, ra);
                }
                break;
            case "Apartment":
                if (apartments.get(o + n) != null) {
                    apartments.get(o + n).editRating(user, desc, ra);
                }
                break;
            case "Maisonette":
                if (maisonettes.get(o + n) != null) {
                    maisonettes.get(o + n).editRating(user, desc, ra);
                }
                break;
        }
    }

    public void deleteRating(String o, String n, String user) {
        String type = this.getType(o, n);
        switch (type) {
            case "Hotel":
                if (hotels.get(o + n) != null) {
                    hotels.get(o + n).deleteRating(user);
                }
                break;
            case "Apartment":
                if (apartments.get(o + n) != null) {
                    apartments.get(o + n).deleteRating(user);
                }
                break;
            case "Maisonette":
                if (maisonettes.get(o + n) != null) {
                    maisonettes.get(o + n).deleteRating(user);
                }
                break;
        }
    }

    public String[] allRatings(String o, String n, String username) {
        String[] all=new String[0];
        int k=0;
        String type = this.getType(o, n);
        switch (type) {
            case "Hotel":
                for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
                    all= Arrays.copyOf(all,k+1);
                    all[k++]=entry.getValue().getRating(username).getRatingDescription()+" "+entry.getValue().getRating(username).getGrade()+" "+entry.getValue().getRating(username).getDate();
                }
                break;
            case "Apartment":
                for (Map.Entry<String, Apartment> entry : apartments.entrySet()) {
                    all= Arrays.copyOf(all,k+1);
                    all[k++]=entry.getValue().getRating(username).getRatingDescription()+" "+entry.getValue().getRating(username).getGrade()+" "+entry.getValue().getRating(username).getDate();
                }
                break;
            case "Maisonette":
                for (Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
                    all= Arrays.copyOf(all,k+1);
                    all[k++]=entry.getValue().getRating(username).getRatingDescription()+" "+entry.getValue().getRating(username).getGrade()+" "+entry.getValue().getRating(username).getDate();
                }
        }
        return all;
    }







}
