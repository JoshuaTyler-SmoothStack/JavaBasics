package coms.ss.javabasics.week1.assignment6;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FixThisSingleton {

  private static Connection conn = null;

  private static volatile FixThisSingleton _instance = null;

  public static FixThisSingleton getInstance() {
    synchronized (_instance) {
      if (_instance == null) {
        _instance = new FixThisSingleton();
      }
    }
    return _instance;
  }

  public static void databaseQuery(BigDecimal input) {
    try {
      conn = DriverManager.getConnection("url of database");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select id from table");
      BigDecimal x = new BigDecimal(0);
      while (rs.next()) {
        x = input.multiply(BigDecimal.valueOf(rs.getInt(1)));
        System.out.println(x);
      }
    } catch(SQLException e) {
      System.err.println(e);
    }
  }
}
