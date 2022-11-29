package api;

import java.util.Map;

public class AccommodationManagerUser extends AccommodationManager{
    public AccommodationManagerUser(){
        super();
    }
    public void findProperties(String[] argv,String[] argv2) {
        int n = argv.length;
        String key, val;
        for (int i = 0; i < n; i++) {
            key = argv[i];
            val = argv2[i];
            for (Map.Entry<String, Apartment> entry : apartments.entrySet()) {
                Apartment value = entry.getValue();
                if (value.getProperty(key) == val) {
                    value.show();
                }
            }
            for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
                Hotel value = entry.getValue();
                if (value.getProperty(key) == val) {
                    value.show();
                }
            }
            for (Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
                Maisonette value = entry.getValue();
                if (value.getProperty(key) == val) {
                    value.show();
                }
            }
        }
    }
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
