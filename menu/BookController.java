package menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.ActionsWithNoPrimaryKey;
import models.BookCopiesTable;

public class BookController {
	private Connection conn;

	public BookController(Connection conn) {
		super();
		this.conn = conn;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	BookCopiesTable bookCopies = new BookCopiesTable();
	ActionsWithNoPrimaryKey noId = new ActionsWithNoPrimaryKey(conn);

	public void displayAllBooks() {
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM library.tbl_book;";
			// person is the table name
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String bookId = rs.getObject(1).toString();
				String bookTitle = rs.getObject(2).toString();
				String authId = rs.getObject(3).toString();
				String pubId = rs.getObject(4).toString();
				System.out.println(bookId + ", " + bookTitle + ", Author ID:");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			for (Throwable ex : e) {
				System.err.println("Error occurred " + ex);
			}
			System.out.println("Error in fetching data");
		}
	}

//	public void increaseCopies(String bookID, String choice, String branchId) {
//		List<String> value = new ArrayList<String>();
//		String[] selectCols = { "bookId", "branchId" };
//		String[] selectVals = { bookID, branchId };
//		ResultSet rs = noId.selectColInRow("tbl_book_copies", "noOfCopies", selectCols, selectVals, "AND");
//		value = noId.storeResultSet(rs);
//		int amountOfCopies = Integer.parseInt(value.get(0));
//		amountOfCopies += 1;
//		System.out.print(amountOfCopies);
//		System.out.print("I ran");
//		String copyNum = Integer.toString(amountOfCopies);
//
//		String[] condCols = { bookCopies.getBranchId(), bookCopies.getBookId() };
//		String[] condVals = { branchId, bookID };
//		noId.updateRow(bookCopies.getTableName(), bookCopies.getCopies(), copyNum, condCols, condVals, "AND");
//		System.out.println("Copy added back to the library");
//	}

	public void decreaseCopies(String bookID, String choice) {
		String copyNum = "-1";
		String[] condCols = { bookCopies.getBranchId(), bookCopies.getBookId() };
		String[] condVals = { choice, bookID };
		noId.updateRow(bookCopies.getTableName(), bookCopies.getCopies(), copyNum, condCols, condVals, "AND");
		System.out.println("Copy checked out");
	}

	public ArrayList<String> getNumOfCopies() throws SQLException {
		ArrayList<String> borrowers = new ArrayList<String>();
		String query = "SELECT * FROM library.tbl_book_copies";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String noOfCopies = rs.getString("noOfCopies");
			borrowers.add(noOfCopies);

		}

		return borrowers;

	}
	
	public String countCopiesofBookInBranch(String bookId, String branchId) {
	       // TODO Auto-generated method stub
	       String returnValue = "";
	       try {
	           String sqlQuery = "select * from tbl_book_copies where bookId=? and branchId=?";
	           PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
	           preparedStmt.setString(1, bookId);
	           preparedStmt.setString(2, branchId);
	           ResultSet result = preparedStmt.executeQuery();
	           if (result.next()) {
	               returnValue = result.getString("noOfCopies");
	           }
	           //System.out.print("There is currently" + returnValue + " Books with ID " + bookId + "\n");
	           conn.close();
	       } catch (Exception e) {
	           //e.printStackTrace();
	           System.out.println("Error in countCopiesofBookInBranch function");
	       }
	       return returnValue;

	   }
	    
	    public void reduceBookCopiesFromBranchTable(String branchId, String bookId) {
	        
	        if (Integer.parseInt(countCopiesofBookInBranch(bookId,branchId))  > 0) {
	        try {
	           int totalBookCopiesAfterUpdate = 0;
	           totalBookCopiesAfterUpdate = Integer.parseInt(countCopiesofBookInBranch(bookId,branchId))-1;
	           String strTotal = Integer.toString(totalBookCopiesAfterUpdate);
	           String sqlQuery = "update tbl_book_copies set noOfCopies=? where bookId=? and branchId=?";
	           PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
	           preparedStmt.setString(1, strTotal);
	           preparedStmt.setString(2, bookId);
	           preparedStmt.setString(3, branchId);

	           System.out.println("You now have " + strTotal + " copies");

	           preparedStmt.executeUpdate();
	           conn.close();

	       } catch (Exception e) {
	          // e.printStackTrace();
	           System.out.println("Error in reduceBookCopiesFromBranchTable function");
	       }
	    }
	        else {    
	        System.out.println("There is no copy of this book in this branch");
	        }
	    }
	    
public void increaseBookCopiesFromBranchTable(String branchId, String bookId) {
	        
	        if (Integer.parseInt(countCopiesofBookInBranch(bookId,branchId)) > 0) {
	        try {
	           int totalBookCopiesAfterUpdate = 0;
	           totalBookCopiesAfterUpdate = Integer.parseInt(countCopiesofBookInBranch(bookId,branchId)) + 1;
	           String sqlQuery = "update tbl_book_copies set noOfCopies=? where bookId=? and branchId=?";
	           PreparedStatement preparedStmt = conn.prepareStatement(sqlQuery);
	           preparedStmt.setInt(1, totalBookCopiesAfterUpdate);
	           preparedStmt.setString(2, bookId);
	           preparedStmt.setString(3, branchId);

	           System.out.println("You now have " + totalBookCopiesAfterUpdate + " copies");

	           preparedStmt.executeUpdate();
	           conn.close();

	       } catch (Exception e) {
	          // e.printStackTrace();
	           System.out.println("Error in increaseBookCopiesFromBranchTable function");
	       }
	    }
	        else {    
	        System.out.println("There is no copy of this book in this branch");
	        }
	    }
}
