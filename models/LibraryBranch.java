package models;

import java.text.MessageFormat;
import java.sql.*;


public class LibraryBranch {
	
	// HAVE A CONNECTION INSTANCE FOR ALL METHODS TO USE?? MAKE PART OF CONSTRUCTOR??
	/*
	private Connection conn;
	public LibraryBranch(Connection conn) {
		this.conn = conn;
	}
	*/
	

	private String tableName = "tbl_library_branch";
	private String branchId = "branchId";
	private String name = "branchName";
	private String address = "branchAddress";
	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

	/*
	
	public String generateSelectQuery(int searchId, String searchName, String searchAddress) {
		
		String enteredData = "";
		if(searchId != 0) {enteredData += branchId + " = " + Integer.toString(searchId) + " OR ";}
		if(!"N/A".equals(searchName)) {enteredData += name + " = " + searchName + " OR ";}
		if(!"N/A".equals(searchAddress)) {enteredData += address + " = " + searchAddress + " OR ";}
		if(enteredData.substring(enteredData.length() -4).equals(" OR ")) {enteredData = enteredData.substring(0, enteredData.length() -4);}
		String baseQuery = MessageFormat.format("SELECT * FROM {0}", tableName);
		String searchQuery = MessageFormat.format("{0} WHERE {1}", baseQuery, enteredData);
		return searchQuery;
	}
	
	
	public String generateInsertQuery(String newName, String newAddress) {
		
		
		String baseQuery = MessageFormat.format("INSERT INTO {0} VALUES ({1}, {1}, {1});" , tableName, "?"); //id auto gen??
		System.out.println(baseQuery);
		try {
		PreparedStatement insertStmt = conn.prepareStatement(baseQuery);
		insertStmt.setString(1, "4");
		insertStmt.setString(2, newName);
		insertStmt.setString(3, newAddress);
		insertStmt.execute();
		System.out.println(insertStmt);
		return "check the DB if it worked";
		}
		catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	      return e.getMessage();
	    }
		// add prepared statment
		// add execute statement
		//return something????
	}
	
	public String generateUpdateQuery(int Id, String newName, String newAddress) {
		
		String enteredData = "";
		if(!"N/A".equals(newName)) {enteredData += name + " = " + newName + ",";}
		if(!"N/A".equals(newAddress)) {enteredData += address + " = " + newAddress + ",";} // dont need the comma here
		if(enteredData.substring(enteredData.length() -1).equals(",")) {enteredData = enteredData.substring(0,enteredData.length() -1);}
		String baseQuery = MessageFormat.format("UPDATE {0} SET {1} WHERE {2} = {3}", tableName, enteredData, branchId, Id);
		return baseQuery;
	}

	public String generateDeleteQuery(int Id) {
		
		String baseQuery = MessageFormat.format("DELETE FROM {0} WHERE {1} = {2}", tableName, branchId, Id);
		return baseQuery;
	}
*/
}

