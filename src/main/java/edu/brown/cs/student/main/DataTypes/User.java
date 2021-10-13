package edu.brown.cs.student.main.DataTypes;

import edu.brown.cs.student.main.core.FileParser;

import java.io.IOException;
import java.util.Dictionary;

public class User {

  private int _userID;
  private int _weight;
  private int _height;
  private int _age;
  private String _horoscope;


  public User(String userString){
    String[] userArray = userString.split(" ");

    for (String s: userArray){
      System.out.println(userArray);
    }


    try {
      _userID = Integer.parseInt(userArray[1].substring(1, 7));
      _weight = Integer.parseInt(userArray[3].substring(1, 4));
      _height = Integer.parseInt(userArray[7].substring(1, 2))*12
          + Integer.parseInt(userArray[8].substring(0, 1));
      _age = Integer.parseInt(userArray[10].substring(1, 3));
      _horoscope = userArray[14].split("\"")[1];
    }
    catch(Exception e) {
      System.out.println("Unable to parse data into users class.");
    }


  }

  public User(int weight, int height, int age){
    _weight = weight;
    _height = height;
    _age = age;
  }


  public int getUserID(){
    return _userID;
  }

  public int getWeight(){
    return _weight;
  }

  public int getHeight(){
    return _height;
  }

  public int getAge(){
    return _age;
  }

  public String getHoroscope(){
    return _horoscope;
  }

  public void printUserData(){
    System.out.print("id: " + this.getUserID() + ";");
    System.out.print(" weight: " + this.getWeight() + ";");
    System.out.print(" height: " + this.getHeight() + ";");
    System.out.print(" age: " + this.getAge() + ";");
    System.out.println(" horoscope: " + this.getHoroscope() + ";");
  }

}
