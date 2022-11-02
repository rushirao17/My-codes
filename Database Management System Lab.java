import java.sql.*;
import java.util.*;

public class Test {

	
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");

	      // variables
	      final String url = "jdbc:mysql:///DBMSLC";
	      final String user = "root";
	      final String password = "root";
	      int roll;
	      String subject="";
	      Scanner sc = new Scanner(System.in);
	      // establish the connection
	      Connection con = DriverManager.getConnection(url, user, password);

	      // display status message
	      if (con == null) {
	         System.out.println("JDBC connection is not established");
	         return;
	      } else
	         System.out.println("Congratulations," + 
	              " JDBC connection is established successfully.\n");
	      
	      
	      CallableStatement smt = con.prepareCall("{CALL BookFine(?,?)}");
	      System.out.println("Book Return ");
	      System.out.print("Enter Rollno : ");
	      roll=sc.nextInt();
	      System.out.print("Enter Subject : ");
	      subject=sc.next();
	      smt.setInt(1,roll);
	      smt.setString(2, subject);
	      ResultSet rs = smt.executeQuery();
	      System.out.println("Book Returned and Fine if applicable is calculated");
	      
	      Statement stmt = con.createStatement();
	      
	      rs = stmt.executeQuery("Select * From Borrower");
	      System.out.println("Borrower Details : ");
	      while (rs.next()) {
              System.out.println("Rollno : " + rs.getString("Rollno") + " Name : " 
	                   + rs.getString("Name").trim() + " Issue Date : "+ rs.getString("DateofIssue") + " Book Name : " 
	    	                   + rs.getString("BookName").trim() + " Status : "+ rs.getString("status"));
          }
	      
	      rs = stmt.executeQuery("Select * From Fine");
	      System.out.println("Fine Details : ");
	      while (rs.next()) {
              System.out.println("Rollno : " + rs.getString("Rollno") + " Date : " 
	                   + rs.getString("FDate").trim() + " Amount : "+ rs.getInt("Amount"));
          }
	      // close JDBC connection
	      
	      rs.close();
          smt.close();
          con.close();

	}

}
