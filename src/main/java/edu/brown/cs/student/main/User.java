package edu.brown.cs.student.main;

import java.util.Dictionary;

public class User implements Parser{

  private Dictionary<String, String> _line;
  private int _userID;
  private int _weight;
  private int _height;
  private int _age;
  private String _horoscope;


  public User(Dictionary<String, String> line){
    _line = line;
    this.readLine(line);

  }


  @Override
  public void readLine(Dictionary<String, String> line) {
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




}
