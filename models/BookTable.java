package models;



public class BookTable {
	
	private String tableName = "tbl_book";
	private String bookId = "bookId";
	private String name = "title";
	private String authorId = "authId";
	private String publisherId = "pubId";
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	

/*
	public String generateSelectQuery(int searchId, String searchName, int searchAuthId, int searchPubId) {
		
		String enteredData = "";
		if(searchId != 0) {enteredData += bookId + " = " + Integer.toString(searchId) + " OR ";}
		if(!"N/A".equals(searchName)) {enteredData += name + " = " + searchName + " OR ";}
		if(searchAuthId != 0) {enteredData += authorId + " = " + Integer.toString(searchAuthId) + " OR ";}
		if(searchPubId != 0) {enteredData += publisherId + " = " + Integer.toString(searchPubId);}
		if(enteredData.substring(enteredData.length() -4).equals(" OR ")) {enteredData = enteredData.substring(0,enteredData.length() -4);}
		
		String baseQuery = MessageFormat.format("SELECT * FROM {0}", tableName);
		String searchQuery = MessageFormat.format("{0} WHERE {1}", baseQuery, enteredData);
		return searchQuery;
	}
	
	
	public String generateInsertQuery(String newName, int newAuthId, int newPubId) {
		
		String baseQuery = MessageFormat.format("INSERT INTO {0} VALUES ({1}, {2}, {3})" , tableName, newName, newAuthId, newPubId); //id auto gen??
		return baseQuery;
		// add prepared statment
		// add execute statement
		//return something????
	}
	
	public String generateUpdateQuery(int Id, String newName, int newAuthId, int newPubId) {
		
		String enteredData = "";
		if(!"N/A".equals(newName)) {enteredData += name + " = " + newName + ",";}
		if(newAuthId != 0) {enteredData += authorId + " = " + Integer.toString(newAuthId) + ",";}
		if(newPubId != 0) {enteredData += publisherId + " = " + Integer.toString(newPubId);}	 
		if(enteredData.substring(enteredData.length() -1).equals(",")) {enteredData = enteredData.substring(0,enteredData.length() -1);}
		String baseQuery = MessageFormat.format("UPDATE {0} SET {1} WHERE {2} = {3}", tableName, enteredData, bookId, Id);
		return baseQuery;
	}

	public String generateDeleteQuery(int Id) {
		
		String baseQuery = MessageFormat.format("DELETE FROM {0} WHERE {1} = {2}", tableName, bookId, Id);
		return baseQuery;
	}
*/
}
