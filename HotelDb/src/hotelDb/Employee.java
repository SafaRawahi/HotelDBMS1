package hotelDb;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	public void employeeTable() {

		// Java Program to Establish Connection in JDBC

		// Main class

		// Main driver method

		// Creating the connection using Oracle DB
		// Note: url syntax is standard, so do grasp
		String url = "jdbc:mysql://localhost:3306/HotelDBMS1";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		// Entering the data
		Scanner scanner = new Scanner(System.in);

//	        String sql = "CREATE TABLE Employees "+
//	        
//	        "(id INTEGER ,"+
//	        "employee_Type_id INTEGER REFERENCES EmployeeType (id)," +
//	        
//	        	"Room_id INTEGER REFERENCES Hotel (id),"+ 
//	        	  "created_Date Date NOT NULL,"+
//	              "updated_Date Date, "+
//	        	  "is_Active Boolean NOT NULL,"+ 
//	              "PRIMARY KEY (id))";

		String sql = "CREATE TABLE Employees (id INTEGER , employee_Type_id INTEGER REFERENCES EmployeeType (id), "
				+ " Room_id INTEGER " + " REFERENCES Rooms (id),  " + "  created_Date Date NOT NULL, "
				+ "  updated_Date Date, " + " is_Active Boolean NOT NULL, " + "PRIMARY KEY (id) " + ")";

		// Connection class object
		Connection con = null;

		// Try block to check for exceptions
		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();

			// Executing query
			int m = st.executeUpdate(sql);
			if (m >= 0)
				System.out.println("inserted successfully : " + sql);
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
