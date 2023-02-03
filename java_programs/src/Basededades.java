import java.sql.*;

public class Basededades {
  public static void main(String[] args) throws Exception {
    Connection con;
    con = DriverManager.getConnection("jdbc:sqlite:basededades.sqlite");
    Statement smt = con.createStatement();
    String q = "select * from clients";
    ResultSet rs = smt.executeQuery(q);
    while (rs.next()) {
      System.out.println(rs.getString("nom"));
    }
  }
}
