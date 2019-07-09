package models;


public class BookCopiesTable {
	
	private String tableName = "tbl_book_copies";
	private String bookId = "bookId";
	private String branchId = "branchId";
	private String copies = "noOfCopies";
	
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
	public String getCopies() {
		return copies;
	}
	public void setCopies(String copies) {
		this.copies = copies;
	}
	
	
/*
	public String generateSelectQuery(int searchBookId, int searchBranchId, int copiesNum) {
		
		String enteredData = "";
		if(searchBookId != 0) {enteredData += bookId + " = " + Integer.toString(searchBookId) + " OR ";}
		if(searchBranchId != 0) {enteredData += branchId + " = " + Integer.toString(searchBranchId) + " OR ";}
		if(copiesNum != 0) {enteredData += copies + " = " + Integer.toString(copiesNum) + " OR ";}
		if(enteredData.substring(enteredData.length() -4).equals(" OR ")) {enteredData = enteredData.substring(0,enteredData.length() -4);}
		
		String baseQuery = MessageFormat.format("SELECT * FROM {0}", tableName);
		String searchQuery = MessageFormat.format("{0} WHERE {1}", baseQuery, enteredData);
		return searchQuery;
	}
	
	
	public String generateInsertQuery (int newBookId, int newBranchId, int newCopiesNum) {
		
		String baseQuery = MessageFormat.format("INSERT INTO {0} VALUES ({1}, {2}, {3})" , tableName, newBookId, newBranchId, newCopiesNum); //id auto gen??
		return baseQuery;
	}
	
	public String generateUpdateQuery(int searchBookId, int searchBranchId, int newCopiesNum) { // what about a negative book value
		
		String enteredData = copies + " = " + Integer.toString(newCopiesNum);
		String baseQuery = MessageFormat.format("UPDATE {0} SET {1} WHERE {2} = {3} AND {4} = {5}", tableName, enteredData, bookId, searchBookId, branchId, searchBranchId);
		return baseQuery;
	}

	public String generateDeleteQuery(int searchBookId, int searchBranchId) {
		
		String baseQuery = MessageFormat.format("DELETE FROM {0} WHERE {1} = {2} AND {3} = {4}", tableName, bookId, searchBookId, branchId, searchBranchId);
		return baseQuery;
	}
	*/

}

