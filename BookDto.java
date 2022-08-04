package library.Dto;

import org.springframework.stereotype.Component;


public class BookDto {
	
	
	private int bookId; 
	
	
	private String bookName; 
	private String author; 
	private String publication;
	private String subject; 
	private int noOfCopies;
	

	private String authId;
    private String authPassword;
    
    
    
    
    
	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BookDto(int bookId, String bookName, String author, String publication, String subject, int noOfCopies,
			String authId, String authPassword) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publication = publication;
		this.subject = subject;
		this.noOfCopies = noOfCopies;
		this.authId = authId;
		this.authPassword = authPassword;
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getPublication() {
		return publication;
	}



	public void setPublication(String publication) {
		this.publication = publication;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public int getnoOfCopies() {
		return noOfCopies;
	}



	public   void setnoOfCopies(int noOfCopies) {
		
		this.noOfCopies = noOfCopies;
	}



	public String getAuthId() {
		return authId;
	}



	public void setAuthId(String authId) {
		this.authId = authId;
	}



	public String getAuthPassword() {
		return authPassword;
	}



	public void setAuthPassword(String authPassword) {
		this.authPassword = authPassword;
	}



	@Override
	public String toString() {
		return "BookDto [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", publication="
				+ publication + ", subject=" + subject + ", noOfCopies=" + noOfCopies + ", authId=" + authId
				+ ", authPassword=" + authPassword + "]";
	}
    
	
    
    
    
	
	
    







}
