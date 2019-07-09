package menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BorrowerController {
	private Connection conn;

	public BorrowerController(Connection conn) {
		super();
		this.conn = conn;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<String> getAllBorrower() throws SQLException {
		ArrayList<String> allCopies = new ArrayList<String>();
		String query = "SELECT * FROM library.tbl_borrower";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String cardNum = rs.getString("cardNo");
			allCopies.add(cardNum);

		}

		return allCopies;

	}
}