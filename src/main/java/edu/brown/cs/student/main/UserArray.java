package edu.brown.cs.student.main;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;

public class UserArray {

  private ArrayList<Dictionary<String, String>> _userArray;

  public UserArray(String filePath) throws IOException {
    BufferedReader usersReader = new BufferedReader(new FileReader(filePath));
    Gson gson = new Gson();
    _userArray = gson.fromJson(usersReader.readLine(), _userArray.getClass());
    System.out.println(_userArray);
  }

  public ArrayList<Dictionary<String, String>> getUserArray(){
    return _userArray;
  }


}
