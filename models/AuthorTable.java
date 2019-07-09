package models;


public class AuthorTable {

	private String tableName = "tbl_author";
	private String authorId = "authorId";
	private String name = "authorName";
	
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
/* Ignore these... this is all old versions of the code	
	public String generateSelectQuery(int searchId, String searchName) {

		String enteredData = "";
		if (searchId != 0) {
			enteredData += authorId + " = " + Integer.toString(searchId) + " OR ";
		}
		if (!"N/A".equals(searchName)) {
			enteredData += name + " = " + searchName + " OR ";
		}
		if (enteredData.substring(enteredData.length() - 4).equals(" OR ")) {
			enteredData = enteredData.substring(0, enteredData.length() - 4);
		}

		String baseQuery = MessageFormat.format("SELECT * FROM {0}", tableName);
		String searchQuery = MessageFormat.format("{0} WHERE {1}", baseQuery, enteredData);
		return searchQuery;
	}

	public String generateInsertQuery(String newName) { // id???

		String baseQuery = MessageFormat.format("INSERT INTO {0} VALUES ({1})", tableName, newName); // id auto gen??
		return baseQuery;
	}

	public String generateUpdateQuery(int Id, String newName) {

		if ("N/A".equals(newName)) {
			System.out.println("Need an author name to continue");
			return "N/A";
		} else {
			String enteredData = name + " = " + newName;
			String baseQuery = MessageFormat.format("UPDATE {0} SET {1} WHERE {2} = {3}", tableName, enteredData,
					authorId, Id);
			return baseQuery;
		}
	}

	public String generateDeleteQuery(int Id) {

		String baseQuery = MessageFormat.format("DELETE FROM {0} WHERE {1} = {2}", tableName, authorId, Id);
		return baseQuery;
	}
	*/
}
