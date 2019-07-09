package dao;

import java.sql.*;
import java.text.MessageFormat;

public class ActionsByUniqueId {

	private Connection conn;

	public ActionsByUniqueId(Connection conn) {
		super();
		this.conn = conn;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
/*	
	public storeResultSet(ResultSet myRs) {
		try {
			ResultSetMetaData metaData = myRs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (myRs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String columnValue = myRs.getString(i);
					System.out.print(columnValue + " " );//+ metaData.getColumnName(i));
				}
				System.out.println("");
			}

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	} */

	// need a display function too!!!
	public ResultSet selectRow(String tableName, String uniqueColumnName, int uniqueId) {

		String baseQuery = MessageFormat.format("SELECT * FROM {0} WHERE {1} = ?;", tableName, uniqueColumnName);
		try {
			PreparedStatement selectStmt = conn.prepareStatement(baseQuery);
		//	selectStmt.setString(1, tableName);
			selectStmt.setInt(1, uniqueId);
			ResultSet myRs = selectStmt.executeQuery();
			return myRs;
			//return myRs; // move out of the try block
	/*		ResultSetMetaData metaData = myRs.getMetaData();
			int columnCount = metaData.getColumnCount();
			System.out.println("I ran up to here");
			while(myRs.next()) {
				for (int i = 1; i <= columnCount; i++) {
			           if (i > 1) System.out.print(",  ");
			           String columnValue = myRs.getString(i);
			           System.out.print(columnValue + " " + metaData.getColumnName(i));
			       }
			       System.out.println("");
			}
	*/
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
			return null;
		}
	}

	public void insertRow(String tableName, String[] values) { // need to auto gen a new unique id?? or enter manually
		String baseQuery = MessageFormat.format("INSERT INTO {0} VALUES ", tableName);
		String valueStr = "(";
		for (int i = 0; i < values.length; i++) {
			valueStr += "?,";
		}
		
		String valueString = valueStr.substring(0, valueStr.length() - 1) + ");";
		try {
			PreparedStatement insertStmt = conn.prepareStatement(baseQuery + valueString);
			for (int i = 0; i < values.length; i++) {
				insertStmt.setString(i+1, values[i]);
			}
			insertStmt.execute();
			System.out.println("Inserted Row");
			
		} 
		catch (Exception e) {
			System.err.println("Got an exception");
			System.err.println(e.getMessage());
		}
	}

// does one column at a time
	public void updateRow(String tableName, String columnName,  String value, String uniqueColumnName, int uniqueId) {
		
		String baseQuery = MessageFormat.format("UPDATE {0} SET {1} = ? WHERE {2} = ?;", tableName, columnName, uniqueColumnName);
		try {
			PreparedStatement updateStmt = conn.prepareStatement(baseQuery);
			updateStmt.setString(1, value);
			updateStmt.setInt(2, uniqueId);
			updateStmt.execute();
			System.out.println("updated column");
		}
		catch(Exception e) {
			System.err.println("Got an exception");
			System.err.println(e.getMessage());
		}

	}
// does one at a time
	public void deleteRow(String tableName, String uniqueColumnName, int uniqueId) {
		String baseQuery = MessageFormat.format("DELETE FROM {0} WHERE {1} = ?;", tableName, uniqueColumnName);
		try {
			PreparedStatement deleteStmt = conn.prepareStatement(baseQuery);
			deleteStmt.setInt(1, uniqueId);
			deleteStmt.execute();
			System.out.println("Deleted Row");
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
}
