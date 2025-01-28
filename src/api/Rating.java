package api;

import java.io.Serializable;

public class Rating implements Serializable {

    /**All the variables in Rating class:
     * rating_description    The description of a rating
     * name_of_user    The name of the user who added the rating
     * date    The date that the rating was added
     * small_name    The small name of the user who added the rating
     */
    private String rating_description;
    private final String name_of_user;
    private String date;
    private final String small_name;
    private float grade;

    /**
     * Normal constructor:
     * @param description The description of the rating
     * @param grade The grade of the rating
     * @param name_of_user The name of the user
     * @param date The date the rating was added
     * @param sn The small-name of the User
     */
    public Rating(String description,float grade,String name_of_user,String date,String sn)
    {
        rating_description=description;
        this.grade=grade;
        this.name_of_user=name_of_user;
        this.date=date;
        small_name=sn;
    }


    /**
     * Getter for the description
     * @return The description of a rating
     */
    public String getRatingDescription()
    {
        return rating_description;
    }

    /**
     * Getter for the grade
     * @return The grade of a rating
     */
    public float getGrade()
    {
        return grade;
    }

    /**
     * Setter for the description
     * @param rating_description The new description of rating
     * @param date The date the new description was added
     */
    public void setRatingDescription(String rating_description,String date){
        this.rating_description=rating_description;
        this.date=date;
    }

    /**
     * Setter for the grade
     * @param grade The new grade
     * @param date The date the new grade was added
     */
    public void setGrade(float grade,String date){
        this.grade=grade;
        this.date=date;
    }

    /**
     * Setter for the date
     * @param date The new date of the rating
     */
    public void setDate(String date){
        this.date=date;
    }

    /**
     * Getter for the date
     * @return The date of a rating
     */
    public String getDate(){
        return date;
    }

    /**
     * Method that puts a rating into a String and returns it
     * @return The rating in a String
     */
    public String Show(){
        String x=date+" | "+small_name+" | "+(int)grade+"/5 stars"+"\n";
        x=x+rating_description;
        return x;
    }

    /**
     * Getter for the user
     * @return The name of the user that added a rating
     */
    public String getUser(){return name_of_user;}
}
