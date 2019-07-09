package models;


public class borrowerTable { 
	
	private String tableName = "tbl_borrower";
	private String cardNum = "cardNo";
	private String name = "name";
	private String address = "address";
	private String phoneNum = "phone";

	public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public String getCardNum() {
		return cardNum;
	}


	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
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


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/*
	public String generateSelectQuery(int searchId, String searchName, String searchAddress, String searchPhone) {
		
		String enteredData = "";
		if(searchId != 0) {enteredData += cardNum + " = " + Integer.toString(searchId) + " OR ";}
		if(!"N/A".equals(searchName)) {enteredData += name + " = " + searchName + " OR ";}
		if(!"N/A".equals(searchAddress)) {enteredData += address + " = " + searchAddress + " OR ";}
		if(!"N/A".equals(searchPhone)) {enteredData += phoneNum + " = " + searchPhone + " OR ";}
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
