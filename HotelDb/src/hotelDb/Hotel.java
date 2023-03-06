package hotelDb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;



public class Hotel {
	
	public void hotelTable() {

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
		String sql = "CREATE TABLE Hotel " + "(id INTEGER PRIMARY KEY AUTO_INCREMENT, "
				+ " hotelName VARCHAR(8) NOT NULL, " + "  hotelLocation VARCHAR(8), " + "  createdDate Date NOT NULL, "
				+ " updateddDate Date, " + " isActive bit NOT NULL" + ")";

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
	
	
	public void insertMoreHotels(int num) {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS1";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		// Entering the data
		// Inserting data using SQL query
		Scanner scanner = new Scanner(System.in);

		String hotelName = "Shang";
		String hotelLocation = "Muscat";
		String createdDate = "1996-01-01";
		String updateddDate = "2015-01-01";
		boolean isActive = true;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);

		for (int i = 0; i <= num; i++) {
	String sql = "insert into hotel values (" + i + numberToAdd + ", '" + hotelName + i + "', '" + hotelLocation
				+ i + "', '" + createdDate + "', '" + updateddDate + "', " + isActive + ")";
		
			
			
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
					System.out.println("inserted values successfully : " + sql);
				else
					System.out.println("insertion values failed");

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
	public void printTenHotels(int top) {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS1";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();
			Scanner scanner = new Scanner(System.in);

			int count = 1;
			String sql = "SELECT * FROM hotel ORDER BY id LIMIT " + top;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= top) {
				int id = rs.getInt("id");
				String hotelname = rs.getString("hotelName");
				String hotellocation = rs.getString("hotelLocation");
				Date createddate = rs.getDate("createdDate");
				Date updateddate = rs.getDate("updateddDate");
				String isActive = rs.getString("isActive");
				System.out.println(id + " " + hotelname + " " + hotellocation + " " + createddate + " " + updateddate
						+ " " + isActive);
				count++;

//				try {
//					// Executing query
//					int m = st.executeUpdate(sql);
//					System.out.println("Print SUCCESSFULLY");
//				} catch (Exception ex) {
//					System.err.println(ex);
//				}

			}

		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
	public void makeIsActiveFalseById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS1";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();
			Scanner scanner = new Scanner(System.in);

			System.out.println("Number Of Id You Want To Update (is avtive column)");
			int inputid = scanner.nextInt();
//      int count=1;

			String sql = "UPDATE hotel SET isActive='0' WHERE id<=" + inputid;
			System.out.println(sql);

			try {
				// Executing query
				int m = st.executeUpdate(sql);
				System.out.println("UPDATED SUCCESSFULLY");
			} catch (Exception ex) {
				System.err.println(ex);
			}
			// Closing the connections
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
//	method to insert values in hotel table
	public void insertIntoTable() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS1";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		// Entering the data
		// Inserting data using SQL query
		Scanner scanner = new Scanner(System.in);
		System.out.println(" Enter The Numbers Of  Rows You Want ");
		Integer rows = scanner.nextInt();
		String hotelName = "Shang";
		String hotelLocation = "Muscat";
		String createdDate = "1996-01-01";
		String updateddDate = "2015-01-01";
		boolean isActive = true;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);

		for (int i = 0; i <= rows; i++) {
			String sql = "insert into hotel values (" + i + ", '" + hotelName + i + "', '" + hotelLocation + i + "', '"
					+ createdDate + "', '" + updateddDate + "', " + isActive + ")";

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
					System.out.println("inserted values successfully : " + sql);
				else
					System.out.println("insertion values failed");

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
//	method to read From Table by Id
	public void getById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS1";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Numbers Of Id You Want To Show ");
			int inputid = scanner.nextInt();
			int count = 1;
			String sql = "select * from hotel where id='" + inputid + "'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= inputid) {
				int id = rs.getInt("id");
				String hotelname = rs.getString("hotelName");
				String hotellocation = rs.getString("hotelLocation");
				Date createddate = rs.getDate("createdDate");
				Date updateddate = rs.getDate("updateddDate");
				String isActive = rs.getString("isActive");
				System.out.println(id + " " + hotelname + " " + hotellocation + " " + createddate + " " + updateddate
						+ " " + isActive);
				count++;
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
//	method to read From Table
	public void readFromTable() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS1";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Connection con = null;
		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Numbers Of User You Want To Read ");
			int read = scanner.nextInt();
			int count = 1;
			String sql = "select * from hotel";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next() && count <= read) {
				int id = rs.getInt("id");
				String hotelName = rs.getString("hotelName");
				String hotelLocation = rs.getString("hotelLocation");
				Date createdDate = rs.getDate("createdDate");
				Date updateddDate = rs.getDate("updateddDate");
				String isActive = rs.getString("isActive");
				System.out.println(id + " " + hotelName + " " + hotelLocation + " " + createdDate + " " + updateddDate
						+ " " + isActive);
				count++;
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
//	method to update values by Id
	public void updateById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS1";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();
			Scanner scanner = new Scanner(System.in);

			System.out.println("Number Of Id You Want To Update ");
			int inputid = scanner.nextInt();
//      int count=1;
			System.out.println("Enter Hotel Name: ");
			String hotelNameInput = scanner.next();
			System.out.println("Enter Hotel Location: ");
			String hotelLocatoinInput = scanner.next();
			String sql = "UPDATE Hotel SET hotelname='" + hotelNameInput + "',hotellocation='" + hotelLocatoinInput
					+ "' WHERE id=" + inputid;
			System.out.println(sql);

			try {
				// Executing query
				int m = st.executeUpdate(sql);
				System.out.println("UPDATED SUCCESSFULLY");
			} catch (Exception ex) {
				System.err.println(ex);
			}
			// Closing the connections
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

//	method to delete values by Id
	public void deleteById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con.createStatement();
			Scanner scanner = new Scanner(System.in);

			System.out.println("Number Of Id You Want To Delete ");
			int inputid = scanner.nextInt();
//      int count=1;

			String sql = "delete from hotel where id ='" + inputid + "'";

			System.out.println(sql);

			try {
				// Executing query
				int m = st.executeUpdate(sql);
				System.out.println("UPDATED SUCCESSFULLY");
			} catch (Exception ex) {
				System.err.println(ex);
			}
			// Closing the connections
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
}