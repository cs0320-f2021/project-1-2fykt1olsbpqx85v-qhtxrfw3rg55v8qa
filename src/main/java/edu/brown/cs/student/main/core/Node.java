package edu.brown.cs.student.main.core;

import edu.brown.cs.student.main.DataTypes.User;

public class Node {

  private Node _parent = null;
  private final User _value;
  private Node _left = null;
  private Node _right = null;

  public Node(User value) {
    _value = value;
  }

  public Node getParent(){
    return _parent;
  }

  public Node getLeft(){
    return _left;
  }

  public Node getRight(){
    return _right;
  }

  public void addLeft(Node left){
    _left = left;
    _left.setParent(this);
  }

  public void addRight(Node right){
    _right = right;
    _right.setParent(this);
  }

  public boolean hasLeft(){
    return _left != null;
  }

  public boolean hasRight(){
    return _right != null;
  }


  public User getValue(){
    return _value;
  }


  public int getDepth(){
    if (_parent==null){
      return 0;
    }
    else{
      return _parent.getDepth() + 1;
    }
  }

  public void setParent(Node p){
    _parent = p;
  }

}
