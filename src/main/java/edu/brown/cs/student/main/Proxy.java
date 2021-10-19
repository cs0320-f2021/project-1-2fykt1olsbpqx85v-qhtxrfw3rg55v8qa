package edu.brown.cs.student.main;

import edu.brown.cs.student.orm.Database;

import java.sql.SQLException;

public class Proxy {

  private Database db = new Database("data/project-1/integration.sqlite3");


  public Proxy() throws SQLException, ClassNotFoundException {
  }
}
