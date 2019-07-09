package models;

public class Publisher {

		private int publisherID = 0;
		private String publisherName = "NO PUBLISHERNAME";
		
		public Publisher() {}
		
		public Publisher(int publisherID, String publisherName) {
			this.publisherID = publisherID;
			this.publisherName = publisherName;
		}
		
		public int getpublisherID() {
			return publisherID;
		}
		public void setpublisherID(int publisherID) {
			this.publisherID = publisherID;
		}
		
		public String getpublisherName() {
			return publisherName;
		}
		public void setpublisherName(String publisherName) {
			this.publisherName = publisherName;
		}
		
		
		
}
