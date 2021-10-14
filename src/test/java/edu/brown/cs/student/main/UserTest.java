package edu.brown.cs.student.main;

import edu.brown.cs.student.main.DataTypes.User;
import edu.brown.cs.student.main.core.FileParser;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;

public class UserTest {

  private ArrayList<User> _userArray;

  public UserTest(){
    FileParser fp = new FileParser("data/project-1/justusersSMALL.json");
    _userArray = fp.linesToUsers();
  }


  @Test
  public void userArraySize(){
    assertTrue(_userArray.size() == 15);
  }


  @Test
  public void firstUserID(){
    User firstUser = _userArray.get(0);
    assertTrue(firstUser.getUserID() == 151944);
  }

  @Test
  public void firstUserWeight(){
    User firstUser = _userArray.get(0);
    assertTrue(firstUser.getWeight() == 145);
  }

  @Test
  public void firstUserHeight(){
    User firstUser = _userArray.get(0);
    assertTrue(firstUser.getHeight() == 69);
  }

  @Test
  public void firstUserAge(){
    User firstUser = _userArray.get(0);
    assertTrue(firstUser.getAge() == 27);
  }

  @Test
  public void firstUserHoroscope(){
    User firstUser = _userArray.get(0);
    assertTrue(firstUser.getHoroscope().equals("Libra"));
  }

  @Test
  public void lastUserID(){
    User firstUser = _userArray.get(14);
    assertTrue(firstUser.getUserID() == 909926);
  }

  @Test
  public void lastUserWeight(){
    User firstUser = _userArray.get(14);
    assertTrue(firstUser.getWeight() == 135);
  }

  @Test
  public void lastUserHeight(){
    User firstUser = _userArray.get(14);
    assertTrue(firstUser.getHeight() == 65);
  }

  @Test
  public void lastUserAge(){
    User firstUser = _userArray.get(14);
    assertTrue(firstUser.getAge() == 34);
  }

  @Test
  public void lastUserHoroscope(){
    User firstUser = _userArray.get(14);
    assertTrue(firstUser.getHoroscope().equals("Libra"));
  }



}
