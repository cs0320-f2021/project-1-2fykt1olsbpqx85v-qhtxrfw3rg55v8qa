package edu.brown.cs.student.main.commands;

import edu.brown.cs.student.main.core.FileParser;
import edu.brown.cs.student.main.core.KDTree;


public class UsersCommand implements Command<KDTree> {
  private KDTree _tree;

  public UsersCommand(KDTree tree){
    tree = _tree;
  }


  @Override
  public void executeCommand(String[] arguments) {


    FileParser fp = new FileParser(arguments[1]);
    _tree = new KDTree(fp.linesToUsers());

    System.out.println(_tree.getRoot());//.getValue().getUserID());

    if (_tree.getRoot() != null){
      System.out.println("Loaded " + _tree.getNodes().size() + " user(s) from " + arguments[1]);
    }



    else{
      System.out.println("ERROR: Tree is not built.");
    }
  }

  @Override
  public KDTree getSavedData() {
    return _tree;
  }

}
