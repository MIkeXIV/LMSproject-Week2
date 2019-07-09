package models;

public class Author {
	
	private int ID = 0;
	private String name = "NO AUTHOR";
	
	// do i need these atrributes and constructor
	
	public int getID() {
		return this.ID;
	}
	public void setID(int authorNewID) {
		this.ID = authorNewID;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	
	public Author() {}
	
	public Author(int ID, String Name) {
		this.ID = ID;
		this.name = Name;
	}
	
}
