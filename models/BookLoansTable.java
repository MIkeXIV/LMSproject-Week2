package models;

import java.sql.Date;
import java.text.MessageFormat;

public class BookLoansTable {

	private String tableName = "tbl_book_loans";
	private String bookId = "bookId";
	private String branchId = "branchId";
	private String cardNum = "cardNo";
	private String dateOut = "dateOut";  // both are sql datetimes  what are they in java
	private String dueDate = "dueDate";
	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getDateOut() {
		return dateOut;
	}
	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	
/*
	public String generateSelectQuery(int searchBookId, int  searchBranchId, int cardNumber, Date rented, Date due) { // handle this Date vs String
		
		String enteredData = "";
		if(searchBookId != 0) {enteredData += bookId + " = " + Integer.toString(searchBookId) + " OR ";}
		if(searchBranchId != 0) {enteredData += branchId + " = " + Integer.toString(searchBranchId) + " OR ";}
		if(cardNumber != 0) {enteredData += cardNum + " = " + Integer.toString(cardNumber) + " OR ";}
// perform date operatons rented
// perform date operations due
		
		__________________
		Need to learn date to continue...or it can get messy
		didnt do anything below here
		above needs some fixing as well
		_________________________________
		if(enteredData.substring(enteredData.length() -4).equals(" OR ")) {enteredData = enteredData.substring(0,enteredData.length() -4);}
		
		String baseQuery = MessageFormat.format("SELECT * FROM {0}", tableName);
		String searchQuery = MessageFormat.format("{0} WHERE {1}", baseQuery, enteredData);
		return searchQuery;
	}
	
	
	public String generateInsertQuery(String newName, String newAddress, String newPhone) {
		
		String baseQuery = MessageFormat.format("INSERT INTO {0} VALUES ({1}, {2}, {3})" , tableName, newName, newAddress, newPhone); //id auto gen??
		return baseQuery;
		// add prepared statment
		// add execute statement
		//return something????
	}
	
	public String generateUpdateQuery(int Id, String newName, String newAddress, String newPhone) {
		
		String enteredData = "";
		if(!"N/A".equals(newName)) {enteredData += name + " = " + newName + ",";}
		if(!"N/A".equals(newAddress)) {enteredData += address + " = " + newAddress + ",";}
		if(!"N/A".equals(newPhone)) {enteredData += phoneNum + " = " + newPhone + ",";}	 // dont need the comma here
		if(enteredData.substring(enteredData.length() -1).equals(",")) {enteredData = enteredData.substring(0,enteredData.length() -1);}
		String baseQuery = MessageFormat.format("UPDATE {0} SET {1} WHERE {2} = {3}", tableName, enteredData, cardNum, Id);
		return baseQuery;
	}

	public String generateDeleteQuery(int Id) {
		
		String baseQuery = MessageFormat.format("DELETE FROM {0} WHERE {1} = {2}", tableName, cardNum, Id);
		return baseQuery;
	}
*/
}
