package edu.brown.cs.student.main.core;

import edu.brown.cs.student.main.DataTypes.User;
import edu.brown.cs.student.main.core.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KDTree {

  private Node _root; //Stores the root of the tree.
  private User _farthestUser = null; //The farthest user from a given user.

<<<<<<< HEAD:src/main/java/edu/brown/cs/student/main/core/KDTree.java
=======
  /*simUsers is a HashMap, with Users as keys and the distance between a given user and a target
    User as the value. */
  private HashMap<User, Double> _simUsers = new HashMap<User, Double>();

  /**
   * The KDTree constructor. It builds the KDTree, and initializes its root. A new KDTree should be
   * called every time the command "users <filepath>" is called.
   * @param userList a list of users that will be used to construct a new KD Tree.
   */
>>>>>>> ac6cb10d0f2a99ba4dee31d18ca54371aa93ef6b:src/main/java/edu/brown/cs/student/main/KDTree.java
  public KDTree(ArrayList<User> userList){
    _root = this.buildKDTree(userList, 0);

  }

  /**
   * This method builds a new KDTree, in 3 dimensions.
   * @param userList a list of users that will be used to construct the tree
   * @param depth the depth indicates which axis to consider when contructing the tree.
   * @return the root node of the tree.
   */
  public Node buildKDTree(List<User> userList, int depth){
    List<User> sortedList;

    //Select axis based on depth: first use weight. Then, Sort the users based off their weight.
    if (depth % 3 == 0) {
      sortedList = this.sortByWeight(userList);
    }

    //Select axis based on depth: next use height. Then, Sort the users based off their height.
    else if (depth % 3 == 1) {
      sortedList = this.sortByHeight(userList);
    }

    //Select axis based on depth: last use age. Then, Sort the users based off their age.
    else{
      sortedList = this.sortByAge(userList);
    }

    //Choose the median in pointList as the pivot element.
    User median = sortedList.get(userList.size()/2);

    //Create a node with median as the value
    Node node = new Node(median);

    //Split userList into users that came before the median, and users that came after it.
    List<User> beforeMedian = sortedList.subList(0, sortedList.indexOf(median));
    List<User> afterMedian = sortedList.subList(sortedList.indexOf(median)+1, sortedList.size());

    //Add the children to the node (finding the children recursively)
    if (node.hasLeft()){
      node.addLeft(this.buildKDTree(beforeMedian, depth+1));
    }
    if (node.hasRight()){
      node.addRight(this.buildKDTree(afterMedian, depth+1));
    }

    return node;
  }




  /**
   * This method is called when the user calls the "similar" command (followed by a userID or the
   * weight, height, and age of a new user).
   * @param numOfUsers the number of similar users to find.
   * @param user the given user
   * @return
   */
  public HashMap<User, Double> getSimilarUsers(int numOfUsers, User user, Node currentNode){
    /*Calculate the straight line distance between the given user and the user stored in
      the current node. */
    double straightDistance =
        Math.sqrt((Math.pow(user.getWeight() - currentNode.getValue().getWeight(), 2)
        + Math.pow(user.getHeight() - currentNode.getValue().getHeight(), 2)
        + Math.pow(user.getAge()-currentNode.getValue().getAge(), 2)));

    //If simUsers is not full yet, put the current user into the map.
    if (_simUsers.size()<numOfUsers){
      _simUsers.put(currentNode.getValue(), straightDistance);

      /*Additionally, if the farthest user is null, or the farthest user's distance is less than the
        distance of the current user, update the farthest user. */
      if (_farthestUser == null || _simUsers.get(_farthestUser)>straightDistance){
        _farthestUser = currentNode.getValue();
      }
    }

    //If simUsers is full:
    else {

      //If the depth of the current node is 0, use the weight component.
      if (currentNode.getDepth()%3 == 0){

        /*If the farthest user's distance is greater than the weight distance between the given
          user and the target user, recur on both children*/
        if (_simUsers.get(_farthestUser) >
            Math.abs(currentNode.getValue().getWeight() - user.getWeight())) {
          this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
          this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }

        //If the current node's weight is less than the target's weight, recur on the right child
        else if (currentNode.getValue().getWeight() < user.getWeight()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }

        //If the current node's weight is greater than the target weight, recur on the left child
        else if (currentNode.getValue().getWeight() > user.getWeight()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
        }
      }

      //We repeat what the above logic but for height.
      else if (currentNode.getDepth()%3 == 1){
        if (_simUsers.get(_farthestUser) > Math.abs(currentNode.getValue().getHeight() - user.getHeight())) {
          this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
          getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
        else if (currentNode.getValue().getHeight() < user.getHeight()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
        else if (currentNode.getValue().getHeight() > user.getHeight()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
        }
      }

      //We repeat what the above logic but for age.
      else if (currentNode.getDepth()%3 == 2){
        if (_simUsers.get(_farthestUser) > Math.abs(currentNode.getValue().getAge() - user.getAge())) {
          this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
          this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
        else if (currentNode.getValue().getAge() < user.getAge()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
        else if (currentNode.getValue().getAge() > user.getAge()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
        }
      }
    }

    return _simUsers;
  }


  /**
   * This method sorts the users in three turns: by weight, height, and age. I used insertion sort
   * as it is simpler to code.
   */
  public List<User> sortByWeight(List<User> list) {
    List<User> sortedList = list;
    for (int i = 0; i < sortedList.size(); i++) {
      for (int j = i; j < 0; j--) {

        //Sort the weight
        if (sortedList.get(j).getWeight() > sortedList.get(j - 1).getWeight()) {
          User max = sortedList.get(j);
          sortedList.set(j, sortedList.get(j - 1));
          sortedList.set(j - 1, max);
        }
        else {
          break;
        }
      }
    }
    return sortedList;
  }


  public List<User> sortByHeight(List<User> list) {
    List<User> sortedList = list;
    for (int i = 0; i < sortedList.size(); i++) {
      for (int j = i; j < 0; j--) {

        //Sort the weight
        if (sortedList.get(j).getHeight() > sortedList.get(j - 1).getHeight()) {
          User max = sortedList.get(j);
          sortedList.set(j, sortedList.get(j - 1));
          sortedList.set(j - 1, max);
        } else {
          break;
        }
      }
    }
    return sortedList;
  }


  public List<User> sortByAge(List<User> list) {
    List<User> sortedList = list;
    for (int i = 0; i < sortedList.size(); i++) {
      for (int j = i; j < 0; j--) {

        //Sort the weight
        if (sortedList.get(j).getAge() > sortedList.get(j - 1).getAge()) {
          User max = sortedList.get(j);
          sortedList.set(j, sortedList.get(j - 1));
          sortedList.set(j - 1, max);
        } else {
          break;
        }
      }
    }
    return sortedList;
  }

  public Node getRoot(){
    return _root;
  }

}
