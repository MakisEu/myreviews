package api;

import java.util.Arrays;
import java.util.Map;

public class AccommodationManagerUserSub extends AccommodationManager{
    public boolean addRating(String o, String n, String desc, float ra, String user, String date,String name) {
        //System.out.println(o+" "+n+" "+desc+" "+ra+" "+user+" "+date);
        boolean bool = false;
        String type = this.getType(o, n);
        switch (type) {
            case "Hotel":
                if (hotels.get(o + n) != null) {
                    hotels.get(o + n).addRating(desc, ra, user, date,name);
                }
                else
                    bool=true;
                break;
            case "Apartment":
                if (apartments.get(o + n) != null) {
                    apartments.get(o + n).addRating(desc, ra, user, date,name);
                }
                else
                    bool=true;
                break;
            case "Maisonette":
                if (maisonettes.get(o + n) != null) {
                    maisonettes.get(o + n).addRating(desc, ra, user, date,name);
                }
                else
                    bool=true;
                break;
        }
        return bool;
    }

    public boolean editRatings(String o, String n, String desc, float ra, String user) {
        boolean bool=false;
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
        return bool;
    }

    public boolean deleteRating(String o, String n, String user) {
        boolean bool=false;
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
    return bool;
    }

    public String[] allRatings(String username) {
        String[] all=new String[0];
        int k=0;
                for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
                    if (entry.getValue().getRating(username) != null) {
                        all = Arrays.copyOf(all, k + 1);
                        all[k++] = entry.getValue().getName() + "," + "Hotel," + entry.getValue().getOwner() + "," + entry.getValue().getCity() + "," + entry.getValue().getRating(username).getGrade();
                    }
                }
                for (Map.Entry<String, Apartment> entry : apartments.entrySet()) {
                    if (entry.getValue().getRating(username) != null) {
                        all = Arrays.copyOf(all, k + 1);
                        all[k++] = entry.getValue().getName() + "," + "Apartment," + entry.getValue().getOwner() + "," + entry.getValue().getCity() + "," + entry.getValue().getRating(username).getGrade();
                    }
                }
                for (Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
                    if (entry.getValue().getRating(username) != null) {
                        all = Arrays.copyOf(all, k + 1);
                        all[k++] = entry.getValue().getName() + "," + "Maisonette," + entry.getValue().getOwner() + "," + entry.getValue().getCity() + "," + entry.getValue().getRating(username).getGrade();
                    }
                }
        return all;
    }

    public double getMean(String username) {
        double mean = 0;
        int sum=0;
        for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            mean += entry.getValue().getRating(username).getGrade();
            sum+=entry.getValue().number_of_ratings_of_user(username);
        }
        for (Map.Entry<String, Apartment> entry : apartments.entrySet()) {
            mean+=entry.getValue().getRating(username).getGrade();
            sum+=entry.getValue().number_of_ratings_of_user(username);
        }
        for (Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
            mean+=entry.getValue().getRating(username).getGrade();
            sum+=entry.getValue().number_of_ratings_of_user(username);
        }
        return (double)mean/sum;

        }





}
