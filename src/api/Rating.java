package api;

public class Rating {

    private String rating_description,name_of_user,date;
    private float grade;

    public Rating(String description,float grade,String name_of_user)
    {
        rating_description=description;
        this.grade=grade;
        this.name_of_user=name_of_user;
    }

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

    public void setRatingDescription(String rating_description){
        this.rating_description=rating_description;
    }

    public void setGrade(float grade){
        this.grade=grade;
    }

    public void Show(){
        System.out.println(name_of_user+" "+rating_description+" "+grade);

    }

    public void setDate(String date){
        this.date=date;
    }
    public String getDate(){
        return date;
    }


}
