package dao;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class ActionsWithNoPrimaryKey {

	private Connection conn;

	public ActionsWithNoPrimaryKey(Connection conn) {
		super();
		this.conn = conn;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void displayResultSet(ResultSet myRs) {
		try {

			ResultSetMetaData metaData = myRs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (myRs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					if (i > 1) System.out.print(",  ");
					String columnValue = myRs.getString(i);
					System.out.print(metaData.getColumnName(i) + "..." + columnValue + " " );//+ metaData.getColumnName(i));
				}
				System.out.println("");
			}

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}
	
	public String storeResultSet(ResultSet myRs) {
		//List<String> dataArr = new ArrayList<String>();
		String dataStr = "";
		try {
			ResultSetMetaData metaData = myRs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (myRs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					// if (i > 1) System.out.print(",  ");
					dataStr = myRs.getString(i);
					//String columnValue = myRs.getString(i);
					//System.out.print(metaData.getColumnName(i) + "..." + columnValue + " " );//+ metaData.getColumnName(i));
				}
			}
			return dataStr;

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
			return null;
		}
	}

	public ResultSet selectAll(String tableName) {
		String baseQuery = MessageFormat.format("SELECT * FROM {0};", tableName);
		try {
			PreparedStatement selectStmt = conn.prepareStatement(baseQuery);
			ResultSet myRs = selectStmt.executeQuery();
			return myRs;
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
			return null; // does this do anything??
		}
	}

	public ResultSet selectRow(String tableName, String[] selectCols, String[] selectVals, String andorOperator) {

		String baseQuery = MessageFormat.format("SELECT * FROM {0} WHERE ", tableName);
		String valueQuery = "";
		for (int i = 0; i < selectCols.length; i++) {
			if (i < selectCols.length - 1) {
				valueQuery += MessageFormat.format("{0} = ? {1} ", selectCols[i], andorOperator);
			} else {
				valueQuery += MessageFormat.format("{0} = ?;", selectCols[i]);
			}
		}
		try {
			PreparedStatement selectStmt = conn.prepareStatement(baseQuery + valueQuery);
			for (int i = 0; i < selectCols.length; i++) {
				selectStmt.setString(i + 1, selectVals[i]);
			}
			ResultSet myRs = selectStmt.executeQuery();
			return myRs;
			/*
			ResultSetMetaData metaData = myRs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (myRs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					if (i > 1)
						System.out.print(",  ");
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
	
	
	
	public ResultSet selectColInRow(String tableName, String resultCol, String[] selectCols, String[] selectVals, String andorOperator) {

		String baseQuery = MessageFormat.format("SELECT {0} FROM {1} WHERE ", resultCol, tableName);
		String valueQuery = "";
		for (int i = 0; i < selectCols.length; i++) {
			if (i < selectCols.length - 1) {
				valueQuery += MessageFormat.format("{0} = ? {1} ", selectCols[i], andorOperator);
			} else {
				valueQuery += MessageFormat.format("{0} = ?;", selectCols[i]);
			}
		}
		try {
			PreparedStatement selectStmt = conn.prepareStatement(baseQuery + valueQuery);
			for (int i = 0; i < selectCols.length; i++) {
				selectStmt.setString(i + 1, selectVals[i]);
			}
			ResultSet myRs = selectStmt.executeQuery();
			return myRs;

		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
			return null;
		}
	}

	public void updateRow(String tableName, String updateCol, String newValue, String[] conditionCols,
			String[] conditionVals, String andorOperator) {
		String baseQuery = MessageFormat.format("UPDATE {0} SET {1} = ? WHERE ", tableName, updateCol);
		String valueQuery = "";
		for (int i = 0; i < conditionCols.length; i++) {
			if (i < conditionCols.length - 1) {
				valueQuery += MessageFormat.format("{0} = ? {1} ", conditionCols[i], andorOperator);
			} else {
				valueQuery += MessageFormat.format("{0} = ?;", conditionCols[i]);
			}
		}
		try {
			PreparedStatement updateStmt = conn.prepareStatement(baseQuery + valueQuery);
			updateStmt.setString(1, newValue);
			for (int i = 0; i < conditionCols.length; i++) {
				{
					updateStmt.setString(i + 2, conditionVals[i]);
				}
				/*
				 * try { int subVal = Integer.parseInt(conditionVals[i]); updateStmt.setInt(i+2,
				 * subVal); System.out.print(subVal); } catch (Exception e)
				 * {updateStmt.setString(i+2, conditionVals[i]);} //updateStmt.setString(i+2,
				 * conditionVals[i]);
				 */
			}
			updateStmt.execute();
			System.out.println("Updated Column");
		} catch (Exception e) {
			System.err.println("Got an exception");
			System.err.println(e.getMessage());
		}
	}

	// overload and make 2??
	public void deleteRow(String tableName, String[] columns, String[] valueData, String andorOperator) {

		// if( ! andorOperator.equals("AND") || ! andorOperator.equals("OR"))
		// {andorOperator = "";} // what about And Or ??
		String baseQuery = MessageFormat.format("DELETE FROM {0} WHERE ", tableName);
		String values = "";
		for (int i = 0; i < columns.length; i++) {
			if (i < columns.length - 1) {
				values += MessageFormat.format("{0} = ? {1} ", columns[i], andorOperator);
			} else {
				values += MessageFormat.format("{0} = ?;", columns[i]);
			}
		}
		try {
			PreparedStatement deleteStmt = conn.prepareStatement(baseQuery + values); // can do some Int to Str magic if
																						// needed
			for (int i = 0; i < columns.length; i++) {
				deleteStmt.setString(i + 1, valueData[i]);
			}
			deleteStmt.execute();
		}

		catch (Exception e) {
			System.err.println("Got an exception");
			System.err.println(e.getMessage());
		}
	}
}
