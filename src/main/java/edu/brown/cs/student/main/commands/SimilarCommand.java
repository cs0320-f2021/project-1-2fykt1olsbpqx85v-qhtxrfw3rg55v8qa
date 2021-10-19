package edu.brown.cs.student.main.commands;

import edu.brown.cs.student.main.DataTypes.User;
import edu.brown.cs.student.main.core.KDTree;

import java.util.HashMap;

public class SimilarCommand implements Command<KDTree> {

  private KDTree _tree;

  public SimilarCommand(KDTree tree) {
    tree = _tree;
  }

  @Override
  public void executeCommand(String[] arguments) {

    if (_tree != null){
      //If the given command is "similar k user_id":
      if (arguments.length == 3) {

        //First, find the user that corresponds to the user id
        User user = _tree.findUser(Integer.parseInt(arguments[1]));

        //Now, initialize the hashmap of nearest users
        HashMap<User, Double> sim_users =
            _tree.getSimilarUsers(Integer.parseInt(arguments[1]), user, _tree.getRoot());

        //Print out the similar users' IDs
        for (User key : sim_users.keySet()) {
          System.out.println(key.getUserID());
        }
      }

      //If the given command is "similar k weight height age"
      else if (arguments.length == 5) {
        User user = new User(Integer.parseInt(arguments[2]), Integer.parseInt(arguments[3]),
            Integer.parseInt(arguments[4]));
        HashMap<User, Double> sim_users =
            _tree.getSimilarUsers(Integer.parseInt(arguments[1]), user, _tree.getRoot());
        for (User key : sim_users.keySet()) {
          System.out.println(key.getUserID());
        }
      }
    }

    else{
      System.out.println("Tree is null :(");
    }



  }

  @Override
  public KDTree getSavedData() {
    return _tree;
  }
}
