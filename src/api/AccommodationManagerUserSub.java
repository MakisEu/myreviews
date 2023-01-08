package api;

import java.util.Arrays;
import java.util.Map;

/** A subclass of AccommodationManagerUser that holds the rating part*/
public class AccommodationManagerUserSub extends AccommodationManager{
    /**
     * This method adds a rating to the accommodation
     *  @param o The owner of the accommodation
     *  @param n The name of the accommodation
     *  @param desc Description of the rating
     *  @param ra   The grade of the rating (up to 5)
     *  @param user The user tha created the rating
     *  @param date The date the rating was created
     *  @param name The small name of the user
     *  @param type The type of the accommodation
     *  @return int that is used for error messages in GUI
     *  */
    public int addRating(String o, String n, String desc, float ra, String user, String date,String name,String type) {
        int q = 0;
        //String type = this.getType(o, n);
        switch (type) {
            case "Hotel":
                if (hotels.get(o + n) != null && hotels.get(o+n).getRating(user)==null) {
                    hotels.get(o + n).addRating(desc, ra, user, date,name);
                }
                else if (hotels.get(o + n) != null && hotels.get(o+n).getRating(user)!=null)
                    q=1;
                else
                    q=2;
                break;
            case "Apartment":
                if (apartments.get(o + n) != null && apartments.get(o+n).getRating(user)==null) {
                    apartments.get(o + n).addRating(desc, ra, user, date,name);
                }
                else if (apartments.get(o + n) != null && apartments.get(o+n).getRating(user)!=null)
                    q=1;
                else
                    q=2;
                break;
            case "Maisonette":
                if (maisonettes.get(o + n) != null && maisonettes.get(o+n).getRating(user)==null) {
                    maisonettes.get(o + n).addRating(desc, ra, user, date,name);
                }
                else if (maisonettes.get(o + n) != null && maisonettes.get(o+n).getRating(user)!=null)
                    q=1;
                else
                    q=2;
                break;
        }
        return q;
    }

    /**
     * This method edits a rating to the accommodation
     *  @param o The owner of the accommodation
     *  @param n The name of the accommodation
     *  @param desc Description of the rating
     *  @param ra   The grade of the rating (up to 5)
     *  @param user The user tha created the rating
     *  @param type The type of the accommodation
     *  @return int that is used for error messages in GUI
     *  */
    public int editRatings(String o, String n, String desc, float ra, String user,String type) {
        int q=0;
        switch (type) {
            case "Hotel":
                if (hotels.get(o + n) != null && hotels.get(o+n).getRating(user)!=null) {
                    hotels.get(o + n).editRating(user, desc, ra);
                }
                else if (hotels.get(o + n) != null && hotels.get(o+n).getRating(user)==null)
                    q=1;
                else
                    q=2;
                break;
            case "Apartment":
                if (apartments.get(o + n) != null && apartments.get(o+n).getRating(user)!=null) {
                    apartments.get(o + n).editRating(user, desc, ra);
                }
                else if (apartments.get(o + n) != null && apartments.get(o+n).getRating(user)==null)
                    q=1;
                else
                    q=2;
                break;
            case "Maisonette":
                if (maisonettes.get(o + n) != null && maisonettes.get(o+n).getRating(user)!=null) {
                    maisonettes.get(o + n).editRating(user, desc, ra);
                }
                else if (maisonettes.get(o + n) != null && maisonettes.get(o+n).getRating(user)==null)
                    q=1;
                else
                    q=2;
                break;
        }
        return q;
    }
    /**
     * This method deletes a rating to the accommodation
     *  @param o The owner of the accommodation
     *  @param n The name of the accommodation
     *  @param user The user tha created the rating
     *  @param type The type of the accommodation
     *  @return int that is used for error messages in GUI
     *  */
    public int deleteRating(String o, String n, String user,String type) {
        int q=0;
        //String type = this.getType(o, n);
        switch (type) {
            case "Hotel":
                if (hotels.get(o + n) != null && hotels.get(o+n).getRating(user)!=null) {
                    hotels.get(o + n).deleteRating(user);
                }
                else if (hotels.get(o + n) != null && hotels.get(o+n).getRating(user)==null)
                    q=1;
                else
                    q=2;
                break;
            case "Apartment":
                if (apartments.get(o + n) != null && apartments.get(o+n).getRating(user)!=null) {
                    apartments.get(o + n).deleteRating(user);
                }
                else if (apartments.get(o + n) != null && apartments.get(o+n).getRating(user)==null)
                    q=1;
                else
                    q=2;
                break;
            case "Maisonette":
                if (maisonettes.get(o + n) != null && maisonettes.get(o+n).getRating(user)!=null) {
                    maisonettes.get(o + n).deleteRating(user);
                }
                else if (maisonettes.get(o + n) != null && maisonettes.get(o+n).getRating(user)==null)
                    q=1;
                else
                    q=2;
                break;
        }
    return q;
    }
    /**
     * This method returns all accommodation that the user has rated
     *  @param username The username of the user
     *  @return String[] that has the accommodation that the user has rated
     *  */
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
    /**
     * This method returns the mean of all ratings of user
     *  @param username The username of the user
     *  @return the mean of all the ratings of user
     *  */
    public double getMean(String username) {
        double mean = 0;
        Rating r=null;
        int sum=0;
        for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
            r=entry.getValue().getRating(username);
            if (r!=null)
            {
                mean += r.getGrade();
                sum+=entry.getValue().number_of_ratings_of_user(username);
            }
        }
        for (Map.Entry<String, Apartment> entry : apartments.entrySet()) {
            r=entry.getValue().getRating(username);
            if (r!=null)
            {
                mean += r.getGrade();
                sum+=entry.getValue().number_of_ratings_of_user(username);
            }
        }
        for (Map.Entry<String, Maisonette> entry : maisonettes.entrySet()) {
            r=entry.getValue().getRating(username);
            if (r!=null)
            {
                mean += r.getGrade();
                sum+=entry.getValue().number_of_ratings_of_user(username);
            }
        }
        return (double)mean/sum;

        }





}
