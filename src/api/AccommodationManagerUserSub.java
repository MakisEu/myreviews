package api;

import java.util.Arrays;

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
        if (accommodations.get(type).get(o + n) != null && accommodations.get(type).get(o + n).getRating(user)==null) {
            accommodations.get(type).get(o + n).addRating(desc, ra, user, date,name);
        }
        else if (accommodations.get(type).get(o + n) != null && accommodations.get(type).get(o + n).getRating(user)!=null) {
            q = 1;
        }
        else{
            q=2;
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
        if (accommodations.get(type).get(o + n) != null && accommodations.get(type).get(o + n)!=null) {
            accommodations.get(type).get(o + n).editRating(user, desc, ra);
        }
        else if (accommodations.get(type).get(o + n) != null && accommodations.get(type).get(o + n).getRating(user)==null) {
            q = 1;
        }
        else{
            q=2;
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
        if (accommodations.get(type).get(o + n) != null && accommodations.get(type).get(o + n).getRating(user)!=null) {
            accommodations.get(type).get(o + n).deleteRating(user);
        }
        else if (accommodations.get(type).get(o + n) != null && accommodations.get(type).get(o + n).getRating(user)==null)
            q=1;
        else
            q=2;
    return q;
    }
    /**
     * This method returns all accommodation that the user has rated
     *  @param username The username of the user
     *  @return String[] that has the accommodation that the user has rated
     *  */
    public String[] allRatings(String username) {
        String[] all=new String[0];
        Accommodation a;
        int k=0;
        for (String type:accommodations.keySet()){
            for (String key: accommodations.get(type).keySet()){
                a=accommodations.get(type).get(key);
                if (a.getRating(username) != null) {
                    all = Arrays.copyOf(all, k + 1);
                    all[k++] = a.getName() + "," + type + "," + a.getOwner() + "," + a.getCity() + "," + a.getRating(username).getGrade();
                }
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
        Rating r;
        int sum=0;
        for (String type:accommodations.keySet()){
            for (String key: accommodations.get(type).keySet()){
                r=accommodations.get(type).get(key).getRating(username);
                if(r!=null){
                    mean += r.getGrade();
                    sum+=accommodations.get(type).get(key).number_of_ratings_of_user(username);
                }
            }
        }
        return mean /sum;

        }

}
