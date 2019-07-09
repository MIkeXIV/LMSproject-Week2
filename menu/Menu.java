package menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.ActionsByUniqueId;
import dao.ActionsWithNoPrimaryKey;
import dao.MySQLDAO;
import models.AuthorTable;
import models.BookCopiesTable;
import models.BookLoansTable;
import models.BookTable;
import models.LibraryBranch;
import models.PublisherTable;
import models.borrowerTable;

public class Menu {
	
	// dao connection
	// enter username and password to begin
	MySQLDAO dao = new MySQLDAO("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/library");
	Connection conn = dao.getLocalHostConnection(username, password); // need to hide password
	ActionsByUniqueId idActions = new ActionsByUniqueId(conn);
	ActionsWithNoPrimaryKey noId = new ActionsWithNoPrimaryKey(conn);
	BorrowerController borrowerController = new BorrowerController(conn);
	BookController bookController = new BookController(conn);
	BranchController bc = new BranchController(conn);
	
	
	
	// POJOs
	AuthorTable authors = new AuthorTable();
	BookCopiesTable bookCopies = new BookCopiesTable();
	BookLoansTable bookLoans = new BookLoansTable();
	BookTable books = new BookTable();
	borrowerTable borrowers = new borrowerTable();
	LibraryBranch branches = new LibraryBranch();
	PublisherTable pubs = new PublisherTable();
	
	// UI
	UI ui = new UI();
	
//	private static LibraryManager manager;
	
	public final String DIVIDER = "======================================================";
	
	public final String MAINMENU = "Welcome to the GCIT Library Management System. Which category of auser are you\n"
			+ "1 - Librarian \n"
			+ "2 - Administrator \n"
			+ "3 - Borrower \n"
			+ "99- Exit Program";
	
	public final String LIBRARIANMENU = "Librarian Menu\n"
			+ "1 - Enter Branch name you are managing\n"
			+ "2 - Back to previous Menu";
	
	public final String LIBRARIAN2 = "Librarian2 Menu\n"
			+ "1 - Library 1 //Hard Coded\n"
			+ "2 - Library 2 //Hard Coded\n"
			+ "3 - Library 3 //Hard Coded\n"
			+ "4 - Library 4 //Hard Coded\n"
			+ "99 - Back to previous Menu";
	
	public final String LIBRARIAN3 = "Librarian3 Menu\n"
			+ "1 - Update the details of library\n"
			+ "2 - Add copies of Book to the branch\n"
			+ "3 - Back to previous Menu";
	
	public final String ADMINISTRATORMENU = "Administrator Menu\n"
			+ "1 - Add/Update/Delete Books\n"
			+ "2 - Add/Update/Delete Authors\n"
			+ "3 - Add/Update/Delete Publisherns\n"
			+ "4 - Add/Update/Delete Library Branches\n"
			+ "5 - Add/Update/Delete Borrowers\n"
			+ "6 - Over-ride Due Date for a Book Loan\n"
			+ "7 - Back to previous menu\n";
	
	public final String BORROWERMENU = "Borrower Menu\n"
			+ "Enter the your Card Number: <take input>\n"
			+ "1 - This will take you to the next menu\n";
	
	public final String BORROWER2= "Borrower2\n"
			+"1 - Check out a book // Pick branch you want to check out\n"
			+"2 - Return a book\n"
			+"3 - Back to previous Menu\n";
	
	public final String BORROWER3 = "Borrower3\n"
			+"1 - List of branches\n"
			+"2 - Back to previous Menu\n";
	
//	public final static String LIBRARIANMENU = "<1>Manage Books \n"
//			+ "<2>Manage Authors \n"
//			+ "<3>Manage Publishers \n"
//			+ "<99>Exit Program";
	public final String BRANCHMENU = "1 - View all Branches \n"
			+ "2 - Add a Branch \n"
			+ "3 - Update a Branch \n"
			+ "4 - Delete a Branch \n"
			+ "5 - Go Back";
	
	public final String ADMINBORROWERMENU = "1 - View all Borrowers \n"
			+ "2 - Add a Borrower \n"
			+ "3 - Update a Borrower \n"
			+ "4 - Delete a Borrower \n"
			+ "5 - Go Back";
	
	public final String BOOKMENU = "<1>View all Book \n"
			+ "<2>Add a Book \n"
			+ "<3>Update a Book \n"
			+ "<4>Delete a Book \n"
			+ "<99>Go Back";
	
	public final String AUTHORMENU = "<1>View all Authors \n"
			+ "<2>Add an Author \n"
			+ "<3>Update an Author \n"
			+ "<4>Delete an Author \n"
			+ "<99>Go Back";
	
	public final String PUBLISHERMENU = "<1>View all Publishers \n"
			+ "<2>Add a Publisher \n"
			+ "<3>Update a Publisher \n"
			+ "<4>Delete a Publisher \n"
			+ "<99>Go Back";
	
	public void mainProgram() {
		try {
//			manager = new LibraryManager();
			runMainMenu();			
		}
		catch(Exception ex) {
		}
		finally {
			ui.closeScanner();
		}
		
	}
	
	private void runMainMenu() throws SQLException {				
		boolean flag = true;
		while(flag) {
			ui.say(MAINMENU);	
			int choiceNum = ui.readInt();				
			switch(choiceNum) {
				case 1:
					flag = false;
					printDivider();
					runLibrarianMenu();
				break;					
				case 2:
					flag = false;
					printDivider();
					runAdministratorMenu();
				break;
				case 3:
					flag = false;
					printDivider();
					runBorrowerMenu();
				break;					
				case 99:
					flag = false;
				break;
				default:
					flag = true;
					ui.say("Not a valid option");						
				break;
			}								
		}				
	}
	private void runLibrarianMenu() throws SQLException {
		boolean flag = true;
		while(flag) {
			ui.say(LIBRARIANMENU);	
			
			int choiceNum = ui.readInt();
			
			switch(choiceNum) {
				case 1:
					printDivider();
					runLibrarian2();
					printDivider();
				break;
				case 2:
					printDivider();
					runMainMenu();
				break;
				default:
					ui.say("Not a valid option");						
				break;
			}					
		}	
	}
	
	private void runLibrarian2() throws SQLException {
		boolean flag = true;
		while(flag) {
		//	 ui.say(LIBRARIAN2);	
			ResultSet rs = noId.selectAll(branches.getTableName());
			noId.displayResultSet(rs);
			ui.say("0 - Back to previous Menu");
			int choiceNum = ui.readInt();
			int optionNum = 1;
			if(choiceNum == 0) { optionNum = 0; } 	/* else {
				ResultSet branch = idActions.selectRow(branches.getTableName(), branches.getBranchId(), choiceNum);
				if (branch == null) {optionNum = 2;}
				optionNum = 1;
			}*/
			
			switch(optionNum) {
				case 1:
					printDivider();
					runLibrarian3(choiceNum);
					printDivider();
				break;
				case 0:
					printDivider();
					runLibrarianMenu();
				break;
				default:
					ui.say("Not a valid option");						
				break;
			}					
		}
	}
	
	private void runLibrarian3(int choice) throws SQLException {
		boolean flag = true;
		while(flag) {
			ui.say(LIBRARIAN3);	
			
			int choiceNum = ui.readInt();
			
			switch(choiceNum) {
				case 1:
					printDivider();
					ui.say("Enter 1 to update name of the library or 2 to update address");
					int usrChoice = ui.readInt();
					String colUpdate = "";
					if (usrChoice == 1) {colUpdate = branches.getName();}
					if (usrChoice == 2) {colUpdate = branches.getAddress();}
					ui.say("Enter the new value for the selected option");
					String valUpdate = ui.readLine();
					if (colUpdate.contentEquals("")){break;}
					// scanner for columnName and value
					idActions.updateRow(branches.getTableName(), colUpdate, valUpdate, branches.getBranchId(), choice);
//					//update the library
					printDivider();
				break;
				case 2:
					printDivider();
					ui.say("Enter the book ID you wish to update amount of copies");
					String bookID = ui.readLine();
					ui.say("Enter the new amount of copies");
					String copyNum = ui.readLine();
					String[] condCols = {bookCopies.getBranchId(), bookCopies.getBookId()};
					String[] condVals = {Integer.toString(choice), bookID};
					noId.updateRow(bookCopies.getTableName(), bookCopies.getCopies(),
						copyNum, condCols, condVals, "AND");
//					add copies of book to the branch
				break;
				case 3:
					runLibrarian2();
				break;
				default:
					ui.say("Not a valid option");						
				break;
			}					
		}
	}
	
	private void runAdministratorMenu() throws SQLException {
		boolean flag = true;
		while(flag) {
			ui.say(ADMINISTRATORMENU);	
			
			int choiceNum = ui.readInt();
			
			switch(choiceNum) {
				case 1:
					printDivider();
					runBookMenu();
					printDivider();
				break;
				case 2:
					printDivider();
					runAuthorMenu();
				break;
				case 3:					
					printDivider();
					runPublisherMenu();												
				break;
				case 4:					
					printDivider();
					runBranchMenu();
				break;
				case 5:					
					printDivider();
					runAdminBorrowerMenu();
				break;
				case 6:					
					printDivider();
					runOverrideMenu();
				break;
				case 7:
					flag = false;
					printDivider();
					runMainMenu();
				break;
				default:
					ui.say("Not a valid option");						
				break;
			}					
		}
	}
	
	private void runBorrowerMenu() throws SQLException {
		boolean flag = true;
		while(flag) {
			ui.say(BORROWERMENU);	
			
			int choiceNum = ui.readInt();
			
			switch(choiceNum) {
			case 1:
				printDivider();
                ui.say("Enter your card number");
                String cardNo = ui.readLine();
                ArrayList<String> allCardNumList = borrowerController.getAllBorrower();
                // A query that calls all Borrower Card numbers and adds to the list
                if(allCardNumList.contains(cardNo)){
                	runBorrower2(cardNo);
                } else {
                	printDivider();
                	System.out.println("Card Number not found!");
                }
					
				printDivider();
			break;
			case 2:
				runAdministratorMenu();
			break;
			default:
				ui.say("Not a valid option");						
			break;
		}					
	}		
}

public void runBorrower2(String choice) throws SQLException {
	boolean flag = true;
	while(flag) {
		ui.say(BORROWER2);	
		
		int choiceNum = ui.readInt();
		
		switch(choiceNum) {
			case 1:
				printDivider();
				
//				Check out a book
				ui.say("Enter the Branch ID you wish to check out");
				bc.displayAllBranch();
				String branchId = ui.readLine();
				printDivider();
				ui.say("Enter the Id of the book you want to check out");
				bookController.displayAllBooks(); // Make sure it has at least one copy
				printDivider();
				String bookId = ui.readLine();
				String[] selectCols = {"bookId", "branchId"};
				String[] selectVals = {bookId, branchId};
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
				   LocalDateTime now = LocalDateTime.now();  
				   String dateOut = dtf.format(now);
				   LocalDateTime dueDate = now.plusDays(7);
				   String dueDay = dtf.format(dueDate);
				  
				String[] values = new String[]{bookId, branchId, choice, dateOut, dueDay};
				idActions.insertRow("tbl_book_loans", values);
				ResultSet rs = noId.selectColInRow("tbl_book_copies", "noOfCopies", selectCols, selectVals, "AND");
				String copyString = noId.storeResultSet(rs);
				int copies = Integer.parseInt(copyString) - 1;
				copyString = Integer.toString(copies);
				noId.updateRow("tbl_book_copies", "noOfCopies", copyString, selectCols, selectVals, "AND");
//				bookController.reduceBookCopiesFromBranchTable(branchId, bookId);
				//increase copies
				printDivider();
			break;
			case 2:
				ui.say("Enter the Book ID you want to return");
                String bookID = ui.readLine();
                ui.say("Enter the Branch ID");
                String branchID = ui.readLine();
                String[] selectCols2 = {"bookId", "branchId"};
				String[] selectVals2 = {bookID, branchID};
                String[] columns = {"bookId", "branchId", "cardNo"};
                String[] valueData = {bookID, branchID, choice };
                //bookController.countCopiesofBookInBranch(bookID, branchID);
                //bookController.increaseBookCopiesFromBranchTable(branchID, bookID);
                // fix this
                ResultSet rs2 = noId.selectColInRow("tbl_book_copies", "noOfCopies", selectCols2, selectVals2, "AND");
				String copyStr = noId.storeResultSet(rs2);
				int copies2 = Integer.parseInt(copyStr) + 1;
				copyStr = Integer.toString(copies2);
				noId.updateRow("tbl_book_copies", "noOfCopies", copyStr, selectCols2, selectVals2, "AND");
                noId.deleteRow("tbl_book_loans", columns, valueData, "AND");
//                   DELETE FROM tbl_book_loans WHERE bookId = '1' AND branchId = '1' AND cardNo = '10'

//                also update the BookCopiesTable. Increase by one
                
                printDivider();
			break;
			case 3:
				runBorrowerMenu();
			break;
			default:
				ui.say("Not a valid option");						
			break;
		}					
	}
	}
	
	private void runBranchMenu() throws SQLException {		
		boolean flag = true;
		while(flag) {
			ui.say(BRANCHMENU);	
			
			int choiceNum = ui.readInt();
			
			switch(choiceNum) {
				case 1:
					printDivider();
					ResultSet rs = noId.selectAll(branches.getTableName());
					noId.displayResultSet(rs);
					printDivider();
				break;
				case 2:
					printDivider();
					ui.say("Enter the new branch's uniqeId");
					String newId = ui.readLine();
					ui.say("Enter the new branch's Name");
					String title = ui.readLine();
					ui.say("Enter the new branch's address");
					String address = ui.readLine();
					String[] valArr = {newId, title, address};
					idActions.insertRow(branches.getTableName(), valArr);
				break;
				case 3:					
					printDivider();
					ui.say("Enter the unique branch ID you wish to update");
					int idInput = ui.readInt();
					ui.say("Enter 1 to update name, 2 for address");
					int usrChoice = ui.readInt();
					String colUpdate = "";
					if (usrChoice == 1) {colUpdate = branches.getName();}
					if (usrChoice == 2) {colUpdate = branches.getAddress();}
					ui.say("Enter the new value for the selected option");
					String valUpdate = ui.readLine();
					if (colUpdate.contentEquals("")){break;}
					idActions.updateRow(branches.getTableName(), colUpdate, valUpdate, branches.getBranchId(), idInput);																				
				break;
				case 4:					
					printDivider();
					ui.say("Enter the unique branch ID you wish to delete");
					int userChoice = ui.readInt();
					idActions.deleteRow(branches.getTableName(), branches.getBranchId(), userChoice);
				break;
				case 5:
					runAdministratorMenu();
				break;
				default:
					ui.say("Not a valid option");						
				break;
			}					
		}		
	}
	
	private void runAdminBorrowerMenu() throws SQLException {		
		boolean flag = true;
		while(flag) {
			ui.say(ADMINBORROWERMENU);	
			
			int choiceNum = ui.readInt();
			
			switch(choiceNum) {
				case 1:
					printDivider();
					ResultSet rs = noId.selectAll(borrowers.getTableName());
					noId.displayResultSet(rs);
					printDivider();
				break;
				case 2:
					printDivider();
					ui.say("Enter the new borrower's uniqeId");
					String newId = ui.readLine();
					ui.say("Enter the new borrower's Name");
					String title = ui.readLine();
					ui.say("Enter the address");
					String address = ui.readLine();
					ui.say("Enter the phone");
					String phone = ui.readLine();
					String[] valArr = {newId, title, address, phone};
					idActions.insertRow(borrowers.getTableName(), valArr);
				break;
				case 3:					
					printDivider();
					ui.say("Enter the unique borrower ID you wish to update");
					int idInput = ui.readInt();
					ui.say("Enter 1 to update borrower Name, 2 for address, 3 for phone");
					int usrChoice = ui.readInt();
					String colUpdate = "";
					if (usrChoice == 1) {colUpdate = borrowers.getName();}
					if (usrChoice == 2) {colUpdate = borrowers.getAddress();}
					if (usrChoice == 3) {colUpdate = borrowers.getPhoneNum();}
					ui.say("Enter the new value for the selected option");
					String valUpdate = ui.readLine();
					if (colUpdate.contentEquals("")){break;}
					idActions.updateRow(borrowers.getTableName(), colUpdate, valUpdate, borrowers.getCardNum(), idInput);												
				break;
				case 4:					
					printDivider();
					ui.say("Enter the unique borrower Id you wish to delete");
					int userChoice = ui.readInt();
					idActions.deleteRow(borrowers.getTableName(), borrowers.getCardNum(), userChoice);
				break;
				case 5:
					runAdministratorMenu();
				break;
				default:
					ui.say("Not a valid option");						
				break;
			}					
		}		
	}
	
	private void runOverrideMenu() throws SQLException {
		boolean flag = true;
		while(flag) {
			ui.say("Enter the card Number for the loan due date you wish to override");  // 0 to quit??
			int usrChoice = ui.readInt();
			ResultSet rs = idActions.selectRow(bookLoans.getTableName(), bookLoans.getCardNum(), usrChoice);
			noId.displayResultSet(rs);
			ui.say("");
			ui.say("Enter 1 if this is correct, 2 to re-enter and 0 to return to previous menu");
			int correctChoice = ui.readInt();
			switch(correctChoice) {
				case 1:
					ui.say("Enter the new due date in yyyy-mm-dd format");
					String newDueDate = ui.readLine();
					idActions.updateRow(bookLoans.getTableName(), bookLoans.getDueDate(), newDueDate, bookLoans.getCardNum(), usrChoice);
				break;
				case 2:
					runOverrideMenu();
				break;
				case 0:
					runAdministratorMenu();
				break;
			}
			
		}
	}
	
	private void runBookMenu() throws SQLException {		
		boolean flag = true;
		while(flag) {
			ui.say(BOOKMENU);	
			
			int choiceNum = ui.readInt();
			
			switch(choiceNum) {
				case 1:
					printDivider();
					ResultSet rs = noId.selectAll(books.getTableName());
					noId.displayResultSet(rs);
					printDivider();
				break;
				case 2:
					printDivider();
					ui.say("Enter the new book's uniqeId");
					String newId = ui.readLine();
					ui.say("Enter the new book's Name");
					String title = ui.readLine();
					ui.say("Enter the author Id");
					String authId = ui.readLine();
					ui.say("Enter the publisher Id");
					String pubId = ui.readLine();
					String[] valArr = {newId, title, authId, pubId};
					idActions.insertRow(books.getTableName(), valArr);
				break;
				case 3:					
					printDivider();
					ui.say("Enter the unique bookID you wish to update");
					int idInput = ui.readInt();
					ui.say("Enter 1 to update book Name, 2 for AuthId, 3 for PubId");
					int usrChoice = ui.readInt();
					String colUpdate = "";
					if (usrChoice == 1) {colUpdate = books.getName();}
					if (usrChoice == 2) {colUpdate = books.getAuthorId();}
					if (usrChoice == 3) {colUpdate = books.getPublisherId();}
					ui.say("Enter the new value for the selected option");
					String valUpdate = ui.readLine();
					if (colUpdate.contentEquals("")){break;}
					idActions.updateRow(books.getTableName(), colUpdate, valUpdate, books.getBookId(), idInput);								
				break;
				case 4:					
					printDivider();
						ui.say("Enter the unique bookID you wish to delete");
						int userChoice = ui.readInt();
						idActions.deleteRow(books.getTableName(), books.getBookId(), userChoice);
				break;
				case 99:
					flag = false;
					printDivider();
					runMainMenu();
				break;
				default:
					ui.say("Not a valid option");						
				break;
			}					
		}		
	}
	
	private void runAuthorMenu() throws SQLException {		
		boolean flag = true;
		while(flag) {
			ui.say(AUTHORMENU);
			
			int choiceNum = ui.readInt();
			
			switch(choiceNum) {
				case 1:
					printDivider();
					ResultSet rs = noId.selectAll(authors.getTableName());
					noId.displayResultSet(rs);	
					printDivider();
				break;
				case 2:					
					printDivider();
					ui.say("Enter the new Author's uniqeId");
					String newId = ui.readLine();
					ui.say("Enter the new Author's Name");
					String title = ui.readLine();
					String[] valArr = {newId, title};
					idActions.insertRow(authors.getTableName(), valArr);
				break;
				case 3:					
					printDivider();
					ui.say("Enter the unique author ID you wish to update");
					int idInput = ui.readInt();
					ui.say("Enter the updated authorName");
					String valUpdate = ui.readLine();
					idActions.updateRow(authors.getTableName(), authors.getName(), valUpdate, authors.getAuthorId(), idInput);								
				break;
				case 4:
					printDivider();
					ui.say("Enter the unique author ID you wish to delete");
					int userChoice = ui.readInt();
					idActions.deleteRow(authors.getTableName(), authors.getAuthorId(), userChoice);
				break;
				case 99:
					flag = false;
					printDivider();
					runMainMenu();
				break;
				default:
					ui.say("Not a valid option");						
				break;
			}								
		}		
	}
	
	private void runPublisherMenu() throws SQLException {
		boolean flag = true;
		while(flag) {
			ui.say(PUBLISHERMENU);
			int choiceNum = ui.readInt();
				
			switch(choiceNum) {
				case 1:
					printDivider();
					ResultSet rs = noId.selectAll(pubs.getTableName());
					noId.displayResultSet(rs);	
					printDivider();
				break;
				case 2:
					ui.say("Enter the new publisher's uniqeId");
					String newId = ui.readLine();
					ui.say("Enter the new publisher's Name");
					String title = ui.readLine();
					ui.say("Enter the new publishers address");
					String pubAdd = ui.readLine();
					ui.say("Enter the publisher Phone");
					String pubPhone = ui.readLine();
					String[] valArr = {newId, title, pubAdd, pubPhone};
					idActions.insertRow(pubs.getTableName(), valArr);
//					manager.createPublisher();
				break;
				case 3:
					ui.say("Enter the unique publisher ID you wish to update");
					int idInput = ui.readInt();
					ui.say("Enter 1 to update Name, 2 for address, 3 for phone");
					int usrChoice = ui.readInt();
					String colUpdate = "";
					if (usrChoice == 1) {colUpdate = pubs.getName();}
					if (usrChoice == 2) {colUpdate = pubs.getAddress();}
					if (usrChoice == 3) {colUpdate = pubs.getPhoneNum();}
					ui.say("Enter the new value for the selected option");
					String valUpdate = ui.readLine();
					if (colUpdate.contentEquals("")){break;}
					idActions.updateRow(pubs.getTableName(), colUpdate, valUpdate, pubs.getPublisherId(), idInput);
//					manager.updatePublisher();						
				break;
				case 4:
					printDivider();
					ui.say("Enter the unique publisher ID you wish to delete");
					int userChoice = ui.readInt();
					idActions.deleteRow(pubs.getTableName(), pubs.getPublisherId(), userChoice);
				break;
				case 99:
					flag = false;
					printDivider();
					runMainMenu();
				break;
				default:
					ui.say("Not a valid option");						
				break;
			}		
		}			
	}
	
	private void printDivider() { ui.say(DIVIDER); }
}