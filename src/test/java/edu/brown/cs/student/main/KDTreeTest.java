package edu.brown.cs.student.main;

import edu.brown.cs.student.main.DataTypes.User;
import edu.brown.cs.student.main.core.FileParser;
import edu.brown.cs.student.main.core.KDTree;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class KDTreeTest {

  private KDTree _tree;

  public KDTreeTest(){
    FileParser fp = new FileParser("data/project-1/justusersSMALL.json");
    ArrayList<User> userArray = fp.linesToUsers();
    KDTree tree = new KDTree(userArray);
    tree.buildKDTree(0);
  }

  @Test
  public void testRoot(){
    assertTrue(_tree.getRoot().getValue().getUserID() == 533900);
  }


}
