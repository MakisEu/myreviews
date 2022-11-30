package api;

import java.util.ArrayList;
import java.util.Map;

public class AccommodationManagerUser extends AccommodationManager{
    public AccommodationManagerUser(){
        super();
    }


    /*public void findAnd(String[] argv,String[] argv2){
        String[][] a=this.getAll();
        String searchTerm,type;
        for (int i = 0; i < argv.length; i++) {
            searchTerm=argv[i];
            type=argv2[i];
            if (type=="Name"){
                a=this.findName(a,searchTerm);
            }
            else if (type=="Type"){
                if (searchTerm=="Διαμέρισμα"){
                    a[1]=null;
                    a[2]=null;
                }
                else if (searchTerm=="Ξενοδοχείο"){
                    a[0]=null;
                    a[2]=null;
                }
                else{
                    a[0]=null;
                    a[1]=null;
                }
            }
            else if (type=="Location"){
                a=findLocation(a,searchTerm);
            }
            else{
                String[] b=searchTerm.split(" ");
                a=findProperties(a,b[0],b[1]);
            }

        }
    }
    public String[][] getAll(){
        String[][] a=new String[6][];
        return a;
    }*/

    public String[][] findProperties(String[] argv,String[] argv2) {
        int n = argv.length,cnt=0;;
        String[] a=new String[n],h=new String[n],m=new String[n];
        boolean g;
        for (Map.Entry<String, Apartment> entry : apartments.entrySet()) {
            Apartment value=entry.getValue();
            g=true;
            for (int i=0;i<n && g==true;i++){
                g=value.getProperty(argv[i])==argv2[i];

            }
            if (g){
                a[cnt]=value.getOwner()+"#"+value.getName();
                cnt++;
            }
        }
        cnt=0;
        for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            Hotel value=entry.getValue();
            g=true;
            for (int i=0;i<n && g==true;i++){
                g=value.getProperty(argv[i])==argv2[i];
            }
            if (g){
                h[cnt]=value.getOwner()+"#"+value.getName();
                cnt++;
            }
        }
        cnt=0;
        for (Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
            Maisonette value = entry.getValue();
            g = true;
            for (int i = 0; i < n && g == true; i++) {
                g = value.getProperty(argv[i]) == argv2[i];
            }
            if (g) {
                m[cnt] =value.getOwner()+"#"+value.getName();
                cnt++;

            }
        }
        String[][] b=new String[3][];
        b[0]=a;
        b[1]=h;
        b[2]=m;
        return b;
    }
    public void findName(String name) {
        for (Map.Entry<String, Apartment> entry : apartments.entrySet()) {
            Apartment value = entry.getValue();
            if (name.contains(value.getName())) {
                value.show();
            }
        }
        for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            Hotel value = entry.getValue();
            if (name.contains(value.getName())) {
                value.show();
            }
       }
        for (Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
            Maisonette value = entry.getValue();
            if (name.contains(value.getName())) {
                value.show();
            }
        }
    }
    /*public void findType(String type) {
        if (type == "Ξενοδοχείο") {
            for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
                entry.getValue().show();
            }
        } else if (type == "Διαμέρισμα") {
            for (Map.Entry<String, Apartment> entry : apartments.entrySet()) {
                entry.getValue().show();
            }
        } else if (type == "Μεζονέτα") {
            for (Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
                entry.getValue().show();
            }
        } else return;
    }
    public void findLocation(String location) {
        if (type == "Ξενοδοχείο") {
            for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
                entry.getValue().show();
            }
        } else if (type == "Διαμέρισμα") {
            for (Map.Entry<String, Apartment> entry : apartments.entrySet()) {
                entry.getValue().show();
            }
        } else if (type == "Μεζονέτα") {
            for (Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
                entry.getValue().show();
            }
        } else return;
    }*/
    public void addRating(String o, String n, String desc, float ra, String user, String date) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο") {
            if (hotels.get(o + n) != null) {
                hotels.get(o + n).addRating(desc, ra, user, date);}}
        else if (type == "Διαμέρισμα") {
            if (apartments.get(o + n) != null) {
                apartments.get(o + n).addRating(desc, ra, user, date);}}
        else if (type == "Μεζονέτα") {
            if (maisonettes.get(o + n) != null) {
                maisonettes.get(o + n).addRating(desc, ra, user, date);}}
    }

    public void editRatings(String o, String n, String desc, float ra, String user) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο") {
            if (hotels.get(o + n) != null) {
                hotels.get(o + n).editRating(user, desc, ra);}}
        else if (type == "Διαμέρισμα") {
            if (apartments.get(o + n) != null) {
                apartments.get(o + n).editRating(user, desc, ra);}}
        else if (type == "Μεζονέτα") {
            if (maisonettes.get(o + n) != null) {
                maisonettes.get(o + n).editRating(user, desc, ra);}}
    }

    public void deleteRating(String o, String n, String user) {
        String type = this.getType(o, n);
        if (type == "Ξενοδοχείο") {
            if (hotels.get(o + n) != null) {
                hotels.get(o + n).deleteRating(user);}}
        else if (type == "Διαμέρισμα") {
            if (apartments.get(o + n) != null) {
                apartments.get(o + n).deleteRating(user);}}
        else if (type == "Μεζονέτα") {
            if (maisonettes.get(o + n) != null) {
                maisonettes.get(o + n).deleteRating(user);}}
    }
}
