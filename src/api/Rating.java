package api;

import java.io.Serializable;

public class Rating implements Serializable {

    private String rating_description,name_of_user,date;
    private float grade;

    public Rating(String description,float grade,String name_of_user,String date)
    {
        rating_description=description;
        this.grade=grade;
        this.name_of_user=name_of_user;
        this.date=date;
    }



    public String getRatingDescription()
    {
        return rating_description;
    }

    public float getGrade()
    {
        return grade;
    }

    public void setRatingDescription(String rating_description,String date){
        this.rating_description=rating_description;
        this.date=date;
    }

    public void setGrade(float grade,String date){
        this.grade=grade;
        this.date=date;
    }


    public void setDate(String date){
        this.date=date;
    }
    public String getDate(){
        return date;
    }

    public String Show(){
        String x=date+" | "+name_of_user+" | "+(int)grade+"/5 stars"+"\n";
        x=x+rating_description;
        return x;
    }
    public String getUser(){return name_of_user;}
}
