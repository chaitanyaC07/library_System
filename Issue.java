package library.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Issue")
@Component
public class Issue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name="issueId")
	
	private int issueId;
//	private int bookid; 
//	private int userid; 
	
	
	private Date  issuedate; 
	
	private Date  returndate;

	@OneToOne(cascade = CascadeType.ALL)
	private User user; 
	
	@OneToOne(cascade = CascadeType.ALL)
	private Book book; 
	
	
	
	
	
////	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY , mappedBy = "Book")
//	@OneToOne
//	private List<User> user = new ArrayList<>();
//	
////	@OneToOne(cascade = CascadeType.ALL)
//	@OneToOne
//	private List<Book> book = new ArrayList<>();
	
	
	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
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

	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public int getBookid() {
//		return bookid;
//	}
//
//	public void setBookid(int bookid) {
//		this.bookid = bookid;
//	}
//
//	public int getUserid() {
//		return userid;
//	}
//
//	public void setUserid(int userid) {
//		this.userid = userid;
//	}

	public Date  getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	public Date  getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	

	public Issue(int issueId, Date issuedate,Date returndate, User user, Book book) {
		super();
		this.issueId = issueId;
		this.issuedate = issuedate;
		this.returndate = returndate;
		this.user = user;
		this.book = book;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", issuedate=" + issuedate + ", returndate=" + returndate + ", user="
				+ user + ", book=" + book + "]";
	}


//	public List<User> getUser() {
////		return user;
//	}
//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}
//
//	public List<Book> getBook() {
//		return book;
//	}
//
//	public void setBook(List<Book> book) {
//		this.book = book;
//	} 
//	
//	
	
	
}
