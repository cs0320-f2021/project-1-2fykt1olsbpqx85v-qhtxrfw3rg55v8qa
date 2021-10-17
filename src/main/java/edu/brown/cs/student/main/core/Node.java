package edu.brown.cs.student.main.core;

import edu.brown.cs.student.main.DataTypes.User;

public class Node<E> {

  private Node _parent = null;
  private final E _value;
  private Node _left = null;
  private Node _right = null;

  public Node(E value) {
    _value = value;
  }

  public Node<E> getParent(){
    return _parent;
  }

  public Node<E> getLeft(){
    return _left;
  }

  public Node<E> getRight(){
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


  public E getValue(){
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
