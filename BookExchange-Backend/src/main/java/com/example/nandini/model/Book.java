package com.example.nandini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {

	@Id
    private String bookId;
	private String title;
	private String author;
	private String genre;
	private String condition;
	private boolean available;
	private String coverImage;

	
	
	 public Book() {}

	    public Book(String bookId, String title, String author, String genre, String condition, boolean available, String coverImage) {
	        this.bookId = bookId;
	    	this.title = title;
	        this.author = author;
	        this.genre = genre;
	        this.condition = condition;
	        this.available = available;
	        this.coverImage= coverImage;
	    }
	    
	    
	    public String getBookId() {
	        return bookId;
	    }

	    public void setBookId(String bookId) {
	        this.bookId = bookId;
	    }

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}

		public boolean isAvailable() {
			return available;
		}

		public void setAvailable(boolean available) {
			this.available = available;
		}

		public String getCoverImage() {
			return coverImage;
		}

		public void setCoverImage(String coverImage) {
			this.coverImage = coverImage;
		}
	    
	    
	
	

}
