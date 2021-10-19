package edu.brown.cs.student.main.commands;

import java.util.ArrayList;

public class StarCommand implements Command{

  private ArrayList<String[]> _starsList;

  public StarCommand(ArrayList<String[]> starsList){
    _starsList = starsList;
  }

  @Override
  public void executeCommand(String[] arguments) {

  }

  @Override
  public Object getSavedData() {
    return null;
  }
}
