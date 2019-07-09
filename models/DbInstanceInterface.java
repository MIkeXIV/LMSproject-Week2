package models;

public interface DbInstanceInterface {
	
	final String driver = "com.mysql.jdbc.Driver";
	final String url = "jdbc:mysql://localhost:3306/library"; // final??
	
	String generateSelectQuery();
	
	String generateInsertQuery();
	
	String generateUpdateQuery();
	
	String generateDeleteQuery();
	

}
