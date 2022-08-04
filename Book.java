package library.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Book")
@Component
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid; 
	

	private String bookName; 
	private String author; 
	private String publication;
	private String subject; 
	private int noOfCopies;
	
	
//	@OneToOne
//	private Book book; 
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(int bookid, String bookName, String author, String publication, String subject, int noOfCopies) {
		super();
		this.bookid = bookid;
		this.bookName = bookName;
		this.author = author;
		this.publication = publication;
		this.subject = subject;
		this.noOfCopies = noOfCopies;
	}


	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
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

	public void setnoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookName + ", author=" + author + ", publication=" + publication
				+ ", subject=" + subject + ", NoOfCopies=" + noOfCopies + "]";
	}

	

	
////	public Book getBook() {
////		return book;
////	}
////
////	public void setBook(Book book) {
//		this.book = book;
//	} 
//	
//	
//	private String role; 
//	private boolean enabled;

	
}
