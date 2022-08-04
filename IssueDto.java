package library.Dto;

import java.util.Date;

import library.entities.Book;
import library.entities.User;

public class IssueDto {
	
	private int issueId;
	private Date  issuedate;
	private Date returndate;
	
	private User user;
	private Book book;
	
	private String authId;
	private String bookName;
	
	

	private int bookCount; 
	
	
	
	public int getBookCount() {
		return bookCount;
	}



	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}



	public String getAuthId() {
		return authId;
	}
	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
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

	private String authPassword;
	
	public IssueDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public IssueDto(int issueId, Date issuedate, Date returndate, User user, Book book, String authId,
			String authPassword) {
		super();
		this.issueId = issueId;
		this.issuedate = issuedate;
		this.returndate = returndate;
		this.user = user;
		this.book = book;
		this.authId = authId;
		this.authPassword = authPassword;
	}



	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public Date getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "IssueDto [issueId=" + issueId + ", issuedate=" + issuedate + ", returndate=" + returndate + ", user="
				+ user + ", book=" + book + "]";
	}




	
	
	
	
	
	
	

}
