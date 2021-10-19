package edu.brown.cs.student.main.commands;

import edu.brown.cs.student.main.DataTypes.User;
import edu.brown.cs.student.main.core.KDTree;
import java.util.HashMap;


public class ClassifyCommand implements Command<KDTree> {
  private KDTree _tree;

  public ClassifyCommand(KDTree tree) {
    _tree = tree;
  }

  @Override
  public void executeCommand(String[] arguments) {

    if (arguments.length == 3) {
      User user = _tree.findUser(Integer.parseInt(arguments[2]));
      HashMap<String, Integer>
          classify_map = _tree.classify(Integer.parseInt(arguments[1]), user);
      for (String key : classify_map.keySet()) {
        System.out.println(key + ": " + classify_map.get(key));
      }
    }
    else if (arguments.length == 5) {
      User user = new User(Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]),
          Integer.parseInt(arguments[4]));
      HashMap<String, Integer> classify_map = _tree.classify(Integer.parseInt(arguments[1]), user);
      for (String key : classify_map.keySet()) {
        System.out.println(key + ": " + classify_map.get(key)); }


    }
  }

  @Override
  public KDTree getSavedData() {
    return _tree;
  }
}
