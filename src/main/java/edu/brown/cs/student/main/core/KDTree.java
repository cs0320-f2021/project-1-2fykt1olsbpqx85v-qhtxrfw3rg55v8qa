package edu.brown.cs.student.main.core;

import edu.brown.cs.student.main.DataTypes.User;
import edu.brown.cs.student.main.core.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KDTree {

  private Node _root;

  public KDTree(ArrayList<User> userList){
    _root = this.buildKDTree(userList, 0);
  }

  /**
   * This method is called when the user calls the "users" command, followed by a file path.
   * https://en.wikipedia.org/wiki/K-d_tree#Construction
   */
  public Node buildKDTree(List<User> userList, int depth){
    List<User> sortedList;

    //Select axis based on depth, first use weight.
    if (depth % 3 == 0) {
      sortedList = this.sortByWeight(userList);
    }

    //Select axis based on depth, next use weight.
    else if (depth % 3 == 1) {
      sortedList = this.sortByHeight(userList);
    }

    //Select axis based off age, next use age.
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

    //Add the children to the node
    if (node.hasLeft()){
      node.addLeft(this.buildKDTree(beforeMedian, depth+1));
    }
    if (node.hasRight()){
      node.addRight(this.buildKDTree(afterMedian, depth+1));
    }

    return node;
  }


  User farthestUser = null;
  HashMap<User, Double> simUsers = new HashMap<User, Double>();
  /**
   * This method is called when the user calls the "similar" command (followed by a userID or the
   * weight, height, and age of a new user).
   * @param numOfUsers the number of similar users to find.
   * @param user the given user
   * @return
   */
  public HashMap<User, Double> getSimilarUsers(int numOfUsers, User user, Node currentNode){

    double straightDistance = Math.sqrt((Math.pow(user.getWeight() - currentNode.getValue().getWeight(), 2)
        + Math.pow(user.getHeight() - currentNode.getValue().getHeight(), 2)
        + Math.pow(user.getAge()-currentNode.getValue().getAge(), 2)));

    if (simUsers.size()<numOfUsers){
      simUsers.put(currentNode.getValue(), straightDistance);
      if (farthestUser == null || simUsers.get(farthestUser)>straightDistance){
        farthestUser = currentNode.getValue();
      }
    }
    else {

      //Weight
      if (currentNode.getDepth()%3 == 0){
        if (simUsers.get(farthestUser) > Math.abs(currentNode.getValue().getWeight() - user.getWeight())) {
          getSimilarUsers(numOfUsers, user, currentNode.getLeft());
          getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
        else if (currentNode.getValue().getWeight() < user.getWeight()){
          getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
        else if (currentNode.getValue().getWeight() > user.getWeight()){
          getSimilarUsers(numOfUsers, user, currentNode.getLeft());
        }
      }

      //Height
      else if (currentNode.getDepth()%3 == 1){
        if (simUsers.get(farthestUser) > Math.abs(currentNode.getValue().getHeight() - user.getHeight())) {
          getSimilarUsers(numOfUsers, user, currentNode.getLeft());
          getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
        else if (currentNode.getValue().getHeight() < user.getHeight()){
          getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
        else if (currentNode.getValue().getHeight() > user.getHeight()){
          getSimilarUsers(numOfUsers, user, currentNode.getLeft());
        }
      }

      //Age
      else if (currentNode.getDepth()%3 == 2){
        if (simUsers.get(farthestUser) > Math.abs(currentNode.getValue().getAge() - user.getAge())) {
          getSimilarUsers(numOfUsers, user, currentNode.getLeft());
          getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
        else if (currentNode.getValue().getAge() < user.getAge()){
          getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
        else if (currentNode.getValue().getAge() > user.getAge()){
          getSimilarUsers(numOfUsers, user, currentNode.getLeft());
        }
      }
    }

    //Get the straight-line distance from the user's coordinates to the current node in the tree


    /*If the current node is closer to your target point than one of your k-nearest neighbors, or
      if your collection of neighbors is not full, update the list */

    return null;
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

}
