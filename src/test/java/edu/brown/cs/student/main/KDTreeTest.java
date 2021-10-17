package edu.brown.cs.student.main;

import edu.brown.cs.student.main.DataTypes.User;
import edu.brown.cs.student.main.core.FileParser;
import edu.brown.cs.student.main.core.KDTree;
import edu.brown.cs.student.main.core.Node;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class KDTreeTest {

  private ArrayList<User> _userArray;
  private KDTree _tree;

  public KDTreeTest(){
    FileParser fp = new FileParser("data/project-1/justusersSMALL.json");
    _userArray = fp.linesToUsers();
    _tree = new KDTree(_userArray);
  }

  @Test
  public void buildTreeTest(){
    assertEquals(15, _tree.getNodes().size());
    assertEquals(533900, _tree.getRoot().getValue().getUserID());
  }

  @Test
  public void treeLogicCorrect(){
    for (Node<User> node: _tree.getNodes()){

      //If the node has a left child,
      if (node.hasLeft()){
        Node<User> left = node.getLeft();

        //Compare the node to its child according to the correct coordinate.
        if (node.getDepth() == 0){
          assertTrue(left.getValue().getWeight() <= node.getValue().getWeight());
        }
        else if (node.getDepth() == 1){
          assertTrue(left.getValue().getHeight() <= node.getValue().getHeight());
        }
        else{
          assertTrue(left.getValue().getAge() <= node.getValue().getAge());
        }
      }

      //If the node has a right child,
      if (node.hasRight()){
        Node<User> right = node.getRight();

        //Compare the node to its child according to correct coordinate.
        if (node.getDepth() == 0){
          assertTrue(right.getValue().getWeight() >= node.getValue().getWeight());
        }
        else if (node.getDepth() == 1){
          assertTrue(right.getValue().getHeight() >= node.getValue().getHeight());
        }
        else{
          assertTrue(right.getValue().getAge() >= node.getValue().getAge());
        }
      }
    }
  }

  @Test
  public void sortUsersByWeight(){
    ArrayList<User> usersByWeight = _tree.sortByWeight(_userArray);

    for (int i = 0; i<_userArray.size()-1; i++){
      assertTrue(usersByWeight.get(i).getWeight() <= usersByWeight.get(i+1).getWeight());
    }
  }

  @Test
  public void sortUsersByHeight(){
    ArrayList<User> usersByHeight = _tree.sortByHeight(_userArray);

    for (int i = 0; i<_userArray.size()-1; i++){
      assertTrue(usersByHeight.get(i).getHeight() <= usersByHeight.get(i+1).getHeight());
    }
  }

  @Test
  public void sortUsersByAge(){
    ArrayList<User> usersByAge = _tree.sortByAge(_userArray);

    for (int i = 0; i<_userArray.size()-1; i++){
      assertTrue(usersByAge.get(i).getAge() <= usersByAge.get(i+1).getAge());
    }
  }


  @Test
  public void testFindUser(){
    User user = _tree.findUser(151944);
    assertTrue(user.getWeight() == 145);
    assertTrue(user.getHeight() == 69);
    assertTrue(user.getAge() == 27);
    assertTrue(user.getHoroscope().equals("Libra"));
  }


  @Test
  public void testSimilarUsers(){
    HashMap<User, Double> simUsers =
        _tree.getSimilarUsers(5, _tree.findUser(151944), _tree.getRoot());

    assertFalse(simUsers.isEmpty());
    for (User u: simUsers.keySet()){
      System.out.println(u.getUserID());
    }

    assertTrue(simUsers.size() == 5);
    /*assertTrue(simUsers.containsKey(_tree.findUser(829124)));
    assertTrue(simUsers.containsKey(_tree.findUser(391778)));
    assertTrue(simUsers.containsKey(_tree.findUser(420272)));
    assertTrue(simUsers.containsKey(_tree.findUser(533900)));
    assertTrue(simUsers.containsKey(_tree.findUser(909926)));*/


  }


}
