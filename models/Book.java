package models;

public class Book {
	
	private String bookID = "0";
	private int authorID = 	0;
	private int publisherID = 0;
	private String bookName = "NO BOOKNAME";
	
	public String getBookID() { 
		return bookID;
		}
	public void setBookID(String bookID) { 
		this.bookID = bookID;
		}
	
	
	public int getAuthorID() { 
		return authorID;
		}
	public void setAuthorID(int authorID) { 
		this.authorID = authorID;
		}
	
	
	public int getPublisherID() { 
		return publisherID;
		}
	public void setPublisherID(int publisherID) { 
		this.publisherID = publisherID;
		}
	
	
	public String getName() { 
		return bookName;
		}
	public void setName(String bookName) { 
		this.bookName = bookName;
		}
	
	
	public Book() {}
	
	public Book(String bookID, int authorID, int publisherID, String bookName) {
		this.bookID = bookID;
		this.authorID = authorID;
		this.publisherID = publisherID;
		this.bookName = bookName;
	}
}
