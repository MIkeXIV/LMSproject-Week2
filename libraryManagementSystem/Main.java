package libraryManagementSystem;

import dao.MySQLDAO;
import menu.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.*;
import dao.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		DAO dao = new DAO(); // need to update dao to sql backend
		dao.initialize(); // initialize one DAO instance Singleton??
		System.out.println("");//
		while(true) {
		LMSMenu.initializeMenu();*/
//		MySQLDAO dao = new MySQLDAO("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/library");
//		Connection conn = dao.getLocalHostConnection("root", "Mike60646!!"); // need to hide password
		// what do I set the above function equal to??
		
		/*
		borrowerTable test = new borrowerTable();
		String one = test.generateDeleteQuery(5);
		System.out.println(one);
		String two = test.generateInsertQuery("mike", "123 Fake St", "800-123-4567");
		System.out.println(two);
		String three = test.generateSelectQuery(1, "N/A", "N/A", "N/A");
		System.out.println(three);
		String four = test.generateUpdateQuery(9, "Mike", "123-456-7890", "N/A");
		System.out.println(four);
		*/
//		ActionsByUniqueId idActions = new ActionsByUniqueId(conn);
//		ActionsWithNoPrimaryKey noId = new ActionsWithNoPrimaryKey(conn);
//		String[] columns = {"bookId", "branchId"};
//		String[] vals = {"1", "1"};
//		ResultSet rs = noId.selectColInRow("tbl_book_copies", "noOfcopies", columns, vals, "AND");
//		String copyStr = noId.storeResultSet(rs);
//		noId.displayResultSet(rs);

//		System.out.println(copyStr);
		
	//	String[] columns = {"branchName", "branchAddress"};
	//	String[] vals = {"University Library", "Boston"};
	//	noId.deleteRow("tbl_library_branch", columns, vals, "AND");
	
	//	String[] cols = {"branchId", "branchName"};
	//	String[] vals = {"1", "University Library"};
	//	noId.updateRow("tbl_library_branch", "branchAddress", "Boston", cols, vals, "AND");
		
	//	String[] columns = {"branchId", "branchName", "branchAddress"};
	//	String[] vals = {"4", "University Library", "Boston"};
	//	noId.selectRow("tbl_library_branch", columns , vals, "OR");
		
		//String[] myStrArr = {"1", "4", "1", "2019-07-08", "2019-07-15"};
		//String name = "tbl_book_loans";
		//idActions.insertRow(name, myStrArr);
		
	//	idActions.updateRow("tbl_library_branch", "branchAddress", "Boston", "branchId", 1);
	
	//	idActions.deleteRow("tbl_library_branch", "branchId", 1);
		
	//	idActions.selectRow("tbl_library_branch", "branchId", 2);
	
	//	LibraryBranch branchInst = new LibraryBranch(conn);
	//	branchInst.generateInsertQuery("County Library", "McLean VA");
		//dao.updateCopies(conn, bookId, branchId, -1);

/*
		try {
			PreparedStatement selectStatement = conn.prepareStatement(ulB);
			selectStatement.executeUpdate();
			System.out.println("updated table");
			//ResultSet copies = selectStatement.executeQuery();
			/*
			ArrayList<Integer> borrower = new ArrayList<Integer>();
			while (copies.next()) {
				borrower.add(copies.getInt(1)); // why isnt't this .get(0)
			}
			System.out.print(borrower.get(0));
			*/
			/*
			int newCopy = bookNum.get(0) + increment;
			if (newCopy < 0) {
				System.out.println("Unable to perform command. Not enough copies of books");// or return null
				return false; // is this the best way to do this
			}
			
			String updateQuery = String.format("UPDATE book_copies SET noOfCopies =", newCopy);
			PreparedStatement updateAmount = conn.prepareStatement(updateQuery);
			return true;
			*/
		 /*
		} catch (Exception e) {
			System.out.println(e);
			//return false; // is this the way to go
		}*/
		Menu menu = new Menu();
		menu.mainProgram();
		}
	


}
