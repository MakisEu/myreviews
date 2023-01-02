package api;

import java.util.Arrays;
import java.util.Map;

public class AccommodationManagerUserSub extends AccommodationManager{
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
