package edu.brown.cs.student.main.DataTypes;

//Instance variables for the justreviewsSmall.json
public class Reviews {
    private String review_text;
    private String review_summary;
    private String date;
    private int id;

    //Constructor
    public Reviews(String review_text, String review_summary, String date, int id){
        this.review_text = review_text;
        this.review_summary = review_summary;
        this.date = date;
        this.id = id;
    }

   //Accessor methods for each attribute
    public String getReviewText(){
        return review_text;
    }

    public String getReviewSummary(){
        return review_summary;
    }

    public String getDate(){
        return date;
    }

    public int getId(){
        return id;
    }


}
