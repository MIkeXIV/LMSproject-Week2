package menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BranchController {

	private Connection conn;

	public BranchController(Connection conn) {
		super();
		this.conn = conn;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void displayAllBranch() {
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM library.tbl_library_branch;";
			// person is the table name
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String branchId = rs.getObject(1).toString();
				String branchName = rs.getObject(2).toString();
				String branchAddress = rs.getObject(3).toString();
				System.out.println(branchId + ", " + branchName + ", " + branchAddress);
				// Person table has name and gender column

			}
		} catch (SQLException e) {
			e.printStackTrace();
			for (Throwable ex : e) {
				System.err.println("Error occurred " + ex);
			}
			System.out.println("Error in fetching data");
		}
	}
}
