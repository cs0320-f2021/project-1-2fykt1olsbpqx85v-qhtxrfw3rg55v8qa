package edu.brown.cs.student.main;

import edu.brown.cs.student.main.core.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class NodeTest {

  public NodeTest(){
  }

  @Test
  public void simpleTreeTest(){
    Node<Integer> root = new Node<>(1);
    Node<Integer> left = new Node<>(2);
    Node<Integer> right = new Node<>(3);

    assertEquals(1, (int) root.getValue());
    assertEquals(0, root.getDepth());
    assertNull(root.getParent());

    root.addLeft(left);
    assertEquals(1, left.getDepth());
    assertTrue(root.hasLeft());
    assertEquals(root.getLeft(), left);
    assertEquals(left.getParent(), root);

    root.addRight(right);
    assertEquals(1, right.getDepth());
    assertTrue(root.hasRight());
    assertEquals(root.getRight(), right);
    assertEquals(right.getParent(), root);

  }



}
