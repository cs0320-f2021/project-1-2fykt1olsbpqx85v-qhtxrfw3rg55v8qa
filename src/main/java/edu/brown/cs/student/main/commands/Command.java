package edu.brown.cs.student.main.commands;

public interface Command<K> {

  public void executeCommand(String[] arguments);

  public K getSavedData();

}
