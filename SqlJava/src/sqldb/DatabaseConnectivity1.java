package sqldb;

import java.sql.*;
//Importing required classes
import java.util.*;

public class DatabaseConnectivity1 {
	 public static void main(String a[]) {

	     // Creating the connection using Oracle DB
	     // Note: url syntax is standard, so do grasp
	     String url = "jdbc:MySQL://127.0.0.1:3306/my_sql_db";

	     // Username and password to access DB
	     // Custom initialization
	     String user = "root";
	     String pass = "root";

	     // Entering the data
	     Scanner scanner = new Scanner(System.in);

	     System.out.println("enter name");
	     String name = scanner.next();

	     System.out.println("enter roll no");
	     Integer roll = scanner.nextInt();

	     System.out.println("enter class");
	     String cls = scanner.next();

	     // Inserting data using SQL query
	     String sql = "insert into Students values('" + name
	             + "'," + roll + ",'" + cls + "')";

	     // Connection class object
	     Connection con = null;

	     // Try block to check for exceptions
	     try {

	         Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	         // Registering drivers
	         DriverManager.registerDriver(driver);

	         // Reference to connection interface
	         con = DriverManager.getConnection(url, user,
	                 pass);

	         // Creating a statement
	         Statement st = con.createStatement();

	         // Executing query
	         int m = st.executeUpdate(sql);
	         if (m >=  1)
	             System.out.println(
	                     "inserted successfully : " + sql);
	         else
	             System.out.println("insertion failed");

	         // Closing the connections
	         con.close();
	     }

	     // Catch block to handle exceptions
	     catch (Exception ex) {
	         // Display message when exceptions occurs
	         System.err.println(ex);
	     }
	 }
}
