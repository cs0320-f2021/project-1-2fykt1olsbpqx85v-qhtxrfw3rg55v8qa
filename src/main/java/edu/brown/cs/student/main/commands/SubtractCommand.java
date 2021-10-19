package edu.brown.cs.student.main.commands;

import edu.brown.cs.student.main.main.MathBot;

public class SubtractCommand implements Command {


  @Override
  public void executeCommand(String[] arguments) {
    //Create a new MathBot, and use it to subtract and print the 1st and 2nd arguments
    MathBot math = new MathBot();
    System.out.println(math.subtract(Double.parseDouble(arguments[1]),
        Double.parseDouble(arguments[2]))); {
    }
  }

  @Override
  public Object getSavedData() {
    return null;
  }
}
