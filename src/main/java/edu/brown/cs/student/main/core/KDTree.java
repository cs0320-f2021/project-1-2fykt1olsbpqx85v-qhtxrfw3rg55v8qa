package edu.brown.cs.student.main.core;

import edu.brown.cs.student.main.DataTypes.User;
import freemarker.log._Log4jLoggerFactory;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KDTree {

  private Node<User> _root; //Stores the root of the tree.
  private User _farthestUser = null; //The farthest user from a given user.
  private ArrayList<Node<User>> _nodes; //All the nodes of the tree.

  /*simUsers is a HashMap, with Users as keys and the distance between a given user and a target
    User as the value. */
  private HashMap<User, Double> _simUsers = new HashMap<User, Double>();
  private ArrayList<User> _userList;

  /**
   * The KDTree constructor. It builds the KDTree, and initializes its root. A new KDTree should
   * be called every time the command "users <filepath>" is called.
   * @param userList a list of users that will be used to construct a new KD Tree.
   */

  public KDTree(ArrayList<User> userList){
    _userList = userList;
    _nodes = new ArrayList<>();
    _root = this.buildKDTree(_userList, 0);
  }

  public User findUser(int id) {
    for (User user : _userList){
      if (id == user.getUserID()){
        return user;
      }
    }
    return null;
  }


  /**
   * This method builds a new KDTree, in 3 dimensions.
   * @param depth the depth indicates which axis to consider when contructing the tree.
   * @return the root node of the tree.
   */
  public Node<User> buildKDTree(ArrayList<User> userList, int depth){
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
    Node<User> node = new Node(median);
    _nodes.add(node);

    //Split userList into users that came before the median, and users that came after it.
    ArrayList<User> beforeMedian = new ArrayList<>();
    ArrayList<User> afterMedian = new ArrayList<>();

    //For all users in the sorted list,
    for (int i = 0; i<sortedList.size(); i++){

      /*if the current user is before the median (and is not the median user), add it to the
        */
      if (i < userList.size()/2 && sortedList.get(i) != median){
        beforeMedian.add(sortedList.get(i));
      }

      else if (i > userList.size()/2 && sortedList.get(i) != median){
        afterMedian.add(sortedList.get(i));
      }
    }

    //Add the children to the node (finding the children recursively)
    if (!beforeMedian.isEmpty() && !node.hasLeft()) {
      node.addLeft(this.buildKDTree(beforeMedian, depth + 1));
    }

    if (!beforeMedian.isEmpty() && !node.hasRight()){
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
  public HashMap<User, Double> getSimilarUsers(int numOfUsers, User user, Node<User> currentNode){
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



    //If the depth of the current node is 0, use the weight component.
    if (currentNode.getDepth()%3 == 0){

      /*If the farthest user's distance is greater than the weight distance between the given
        user and the target user, recur on both children*/
      if (_simUsers.get(_farthestUser) >
          Math.abs(currentNode.getValue().getWeight() - user.getWeight())) {

        if (currentNode.hasLeft()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
        }

        if (currentNode.hasRight()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
      }

      //If the current node's weight is less than the target's weight, recur on the right child
      else if (currentNode.getValue().getWeight() < user.getWeight() && currentNode.hasRight()){
        this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
      }

      //If the current node's weight is greater than the target weight, recur on the left child
      else if (currentNode.getValue().getWeight() > user.getWeight() && currentNode.hasLeft()){
        this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
      }
    }

    //We repeat the above logic but for height.
    else if (currentNode.getDepth()%3 == 1){

      if (_simUsers.get(_farthestUser) >
          Math.abs(currentNode.getValue().getHeight() - user.getHeight())) {

        if (currentNode.hasLeft()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
        }

        if (currentNode.hasRight()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
      }

      else if (currentNode.getValue().getHeight() < user.getHeight() && currentNode.hasRight()){
        this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
      }

      else if (currentNode.getValue().getHeight() > user.getHeight() && currentNode.hasLeft()){
        this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
      }
    }

    //We repeat the above logic but for age.
    else if (currentNode.getDepth()%3 == 2){

      if (_simUsers.get(_farthestUser) >
          Math.abs(currentNode.getValue().getAge() - user.getAge())) {

        if (currentNode.hasLeft()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
        }

        if (currentNode.hasRight()){
          this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
        }
      }

      else if (currentNode.getValue().getAge() < user.getAge() && currentNode.hasRight()){
        this.getSimilarUsers(numOfUsers, user, currentNode.getRight());
      }

      else if (currentNode.getValue().getAge() > user.getAge() && currentNode.hasLeft()){
        this.getSimilarUsers(numOfUsers, user, currentNode.getLeft());
      }
    }

    return _simUsers;
  }

  /**
   * This method looks at all the similar users of a given user, and creates a hashmap that
   * keeps track of the star signs of all the similar users.
   *
   * @param k: number of star sign predictions we want to make
   * @param user: the user whose star sign we want to predict
   * @return: a hashmap with star signs for keys and the number of people we found with
   * that star sign, given we searched for the k most similar people
   */
  public HashMap<String, Integer> classify(int k, User user) {

    //Initialize the hashmap.
    HashMap<String, Integer> star_counter = new HashMap<String, Integer>();
    star_counter.put("Aries",0);
    star_counter.put("Taurus",0);
    star_counter.put("Gemini",0);
    star_counter.put("Cancer",0);
    star_counter.put("Leo",0);
    star_counter.put("Virgo",0);
    star_counter.put("Libra",0);
    star_counter.put("Scorpio",0);
    star_counter.put("Sagittarius",0);
    star_counter.put("Capricorn",0);
    star_counter.put("Aquarius",0);
    star_counter.put("Pisces",0);

    //Edit the hashmap with the proper values
    HashMap<User, Double> hashmap_ = new HashMap(getSimilarUsers(k, user, _root));
    for (Map.Entry<User, Double> entry : hashmap_.entrySet()) {
      star_counter.replace(entry.getKey().getHoroscope(),
          star_counter.get(entry.getKey().getHoroscope()) + 1);
    }

    return star_counter;
  }


  /**
   * This method sorts the given list of users from smallest weight to biggest weight.
   * @param userList the given user list
   * @return a new list, sorted by weight
   */
  public ArrayList<User> sortByWeight(ArrayList<User> userList) {
    ArrayList<User> sortedList = userList;

    //Iterate through the list from the first to the last element.
    for (int i = 0; i < sortedList.size(); i++) {

      //Iterate through the list from the ith element to the first element
      for (int j = i; j > 0; j--) {

        /*if the weight of the jth element is smaller than the weight of the element before the jth
          element, swap the two. */
        if (sortedList.get(j).getWeight() < sortedList.get(j - 1).getWeight()) {
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


  /**
   * This method sorts a given list of users by height, from smallest to biggest.
   * @param userList the given list
   * @return a new list, sorted by height
   */
  public ArrayList<User> sortByHeight(ArrayList<User> userList) {
    ArrayList<User> sortedList = userList;

    //Iterate through the list from the first to the last element.
    for (int i = 0; i < sortedList.size(); i++) {

      //Iterate through the list from the ith element to the first element
      for (int j = i; j > 0; j--) {

        /*if the height of the jth element is smaller than the height of the element before the jth
          element, swap the two. */
        if (sortedList.get(j).getHeight() < sortedList.get(j - 1).getHeight()) {
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


  /**
   * This method sorts a given list of users by age, from youngest to oldest.
   * @param userList the given list
   * @return a new list, sorted by age
   */
  public ArrayList<User> sortByAge(ArrayList<User> userList) {
    ArrayList<User> sortedList = userList;

    //Iterate through the list from the first to the last element.
    for (int i = 0; i < sortedList.size(); i++) {

      //Iterate through the list from the ith element to the first element
      for (int j = i; j > 0; j--) {

        /*if the age of the jth element is smaller than the age of the element before the jth
          element, swap the two. */
        if (sortedList.get(j).getAge() < sortedList.get(j - 1).getAge()) {
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

  /**
   * This method returns the root of the tree.
   * @return root
   */
  public Node<User> getRoot(){
    return _root;
  }

  /**
   * This method returns a list of all the nodes in the tree.
   * @return list of nodes
   */
  public ArrayList<Node<User>> getNodes(){
    return _nodes;
  }

}
