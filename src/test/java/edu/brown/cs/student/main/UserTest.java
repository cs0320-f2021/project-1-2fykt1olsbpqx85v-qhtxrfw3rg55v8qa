package edu.brown.cs.student.main;



import java.io.IOException;

import edu.brown.cs.student.main.DataTypes.User;
import edu.brown.cs.student.main.main.UserArray;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UserTest {

  private User _user1;

  public UserTest() throws IOException {
    _user1 = new User(new UserArray("data/project-1/justusersSMALL.json").getUserArray().get(0));

  }

  @Test
  public void testGetUserID(){
    assertEquals(_user1.getUserID(), 151944);
  }

  @Test
  public void testGetWeight(){
    assertEquals(_user1.getWeight(), 145);
  }

  @Test
  public void testGetHeight(){
    assertTrue(_user1.getHeight() == 5 + (double) (9/12));
  }

  @Test
  public void testGetAge(){
    assertEquals(_user1.getAge(), 27);
  }

  @Test
  public void testGetHoroscope(){
    assertTrue(_user1.getHoroscope().equals("Libra"));
  }

}
