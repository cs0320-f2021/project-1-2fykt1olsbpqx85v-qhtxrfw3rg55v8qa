package edu.brown.cs.student.main.DataTypes;

// instance variables corresponding with justrentSMALL.json
public class Rent {
    private String fit;
    private int user_id;
    private int item_id;
    private int rating;
    private String rented_for;
    private String category;
    private int size;
    private int id;

    // constructor to initialize the fields
    public Rent(String fit, int user_id, int item_id, int rating, String rented_for, String category, int size, int id) {
        this.fit = fit;
        this.user_id = user_id;
        this.item_id = item_id;
        this.rating = rating;
        this.rented_for = rented_for;
        this.category = category;
        this.size = size;
        this.id = id;
    }

    // Accessor methods
    public String getFit() {
        return fit;
    }

    public int getUserID() {
        return user_id;
    }

    public int getItemID() {
        return item_id;
    }

    public int getRating() {
        return rating;
    }

    public String getRentedFor() {
        return rented_for;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    public int getID() {
        return id;
    }

}
