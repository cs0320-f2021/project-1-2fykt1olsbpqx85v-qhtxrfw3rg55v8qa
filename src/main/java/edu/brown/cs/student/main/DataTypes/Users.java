package edu.brown.cs.student.main.DataTypes;

// Instance variables for justusersSMALL.json
public class Users {
    private int user_id;
    private int weight;
    private String height;
    private int age;
    private String body_type;
    private String horoscope;

    //Constructor
    public Users(int user_id, int weight, String height, int age, String body_type, String horoscope){
        this.user_id = user_id;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.body_type = body_type;
        this.horoscope = horoscope;
    }

    //Accessor methods for each attribute
    public int getUser_id() {
        return user_id;
    }

    public int getWeight() {
        return weight;
    }

    public String getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public String getBody_type() {
        return body_type;
    }

    public String getHoroscope() {
        return horoscope;
    }
}
