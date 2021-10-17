package edu.brown.cs.student.main.DataTypes;

public class User {

  private int _userID;
  private int _weight;
  private int _height;
  private int _age;
  private String _horoscope;

  public User(String userString){
    String[] userArray = userString.split(" ");

    try {

      _userID = Integer.parseInt(userArray[1].substring(1, userArray[1].length()-2));
      _weight = Integer.parseInt(userArray[3].substring(1, 4));
      _height = Integer.parseInt(userArray[7].substring(1, 2))*12
          + Integer.parseInt(userArray[8].substring(0, 1));
      _age = Integer.parseInt(userArray[10].substring(1, 3));
      this.parseHoroscope(userString);
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

  public void parseHoroscope(String s){
    if (s.contains("Aquarius")){
      _horoscope = "Aquarius";
    }
    else if (s.contains("Pisces")){
      _horoscope = "Pisces";
    }
    else if (s.contains("Aries")){
      _horoscope = "Aries";
    }
    else if (s.contains("Taurus")){
      _horoscope = "Taurus";
    }
    else if (s.contains("Gemini")){
      _horoscope = "Gemini";
    }
    else if (s.contains("Cancer")){
      _horoscope = "Cancer";
    }
    else if (s.contains("Leo")){
      _horoscope = "Leo";
    }
    else if (s.contains("Virgo")){
      _horoscope = "Virgo";
    }
    else if (s.contains("Libra")){
      _horoscope = "Libra";
    }
    else if (s.contains("Scorpio")){
      _horoscope = "Scorpio";
    }
    else if (s.contains("Sagittarius")){
      _horoscope = "Sagittarius";
    }
    else if (s.contains("Capricorn")){
      _horoscope = "Capricorn";
    }
  }

}
