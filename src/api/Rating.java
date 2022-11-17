package api;

public class Rating {

    private String rating_description,name_of_user;
    private float grade;

    public Rating(String description,float grade,String name_of_user)
    {
        rating_description=description;
        this.grade=grade;
        this.name_of_user=name_of_user;
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



}
