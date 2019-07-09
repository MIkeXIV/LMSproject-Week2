package dao;

import java.sql.*;

public class MySQLDAO {

	private String driver; // = "com.mysql.jdbc.Driver"; // private
	private String url; // = "jdbc:mysql://localhost:3306/library"; // private
	private Connection localConn;
	private Connection serverConn;

	public MySQLDAO(String driver, String url) {
		super();
		this.driver = driver;
		this.url = url;
		this.localConn = null;
		this.serverConn = null;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Connection getLocalConn() {
		return localConn;
	}

	public void setLocalConn(String userName, String password) {
		this.localConn = getLocalHostConnection(userName, password);
	}

	public Connection getServerConn() {
		return serverConn;
	}

	public void setServerConn(String userName, String password) {
		this.serverConn = getServerConnection(userName, password); 
	}

	public Connection getLocalHostConnection(String username, String pass) {

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, pass);
			System.out.println("Connected");
			return conn;
		}

		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public Connection getServerConnection(String username, String pass) {

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, pass);
			System.out.println("Connected");
			return conn;
		}

		catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
/*
 * public boolean updateCopies(Connection conn, int bookId, int branchId, int
 * increment) { // need try catch here & // need branch location
 * 
 * try { String getQuery = "SELECT noOfCopies FROM book_copies WHERE bookId = "
 * + Integer.toString(bookId) + " AND branchId =  " +
 * Integer.toString(branchId); PreparedStatement getAmount =
 * conn.prepareStatement(getQuery); ResultSet copies = getAmount.executeQuery();
 * ArrayList<Integer> bookNum = new ArrayList<Integer>(); while (copies.next())
 * { bookNum.add(copies.getInt(1)); // why isnt't this .get(0) } int newCopy =
 * bookNum.get(0) + increment; if (newCopy < 0) {
 * System.out.println("Unable to perform command. Not enough copies of books");/
 * / or return null return false; // is this the best way to do this }
 * 
 * String updateQuery = String.format("UPDATE book_copies SET noOfCopies =",
 * newCopy); PreparedStatement updateAmount =
 * conn.prepareStatement(updateQuery); return true; } catch (Exception e) {
 * System.out.println(e); return false; // is this the way to go } }
 */