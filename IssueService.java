package library.Service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.Dto.IssueDto;
import library.Dto.issueConverter;
import library.entities.Book;
import library.entities.BookRepository;
import library.entities.Issue;
import library.entities.IssueRepository;
import library.entities.User;
import library.entities.UserRepository;

@Service
public class IssueService {

	@Autowired
	private BookRepository bookRepository;
	@Autowired 
	private IssueRepository issueRepository;
	@Autowired
	private AuthService authService;
	@Autowired
	private issueConverter issueConverter;
	
	@Autowired
	private UserRepository userRepository;
	private int bookCount;



public int getBookCount() {
		return bookCount;
	}




	public void setBookCount(int bookCount) {
	
		this.bookCount = bookCount;
	}




public IssueService(BookRepository bookRepository, AuthService authService,
			library.Dto.issueConverter issueConverter , IssueRepository issueRepository , UserRepository userRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authService = authService;
		this.issueConverter = issueConverter;
		this.issueRepository = issueRepository;
		this.userRepository =userRepository;
	}




public List<Book> getBooks(IssueDto issueDto) {
	
	
	Issue issue = issueConverter.dtoToEntity(issueDto);
	
	String role = authService.authenticate(issueDto.getAuthId(), issueDto.getAuthPassword());
	
	if(role != null && role.equalsIgnoreCase("admin")){
		
		 return bookRepository.findAll();
		
	}else{
		throw new RuntimeException("not allow");
	}
			


}

@Transactional
public Issue issueBook( IssueDto issueDto) {
	
	Issue issue = issueConverter.dtoToEntity(issueDto);
	String role = authService.authenticate(issueDto.getAuthId() , issueDto.getAuthPassword());
	
	
	if(role != null && role.equalsIgnoreCase("student")) {
		
	Book book = bookRepository.findByBookName(issueDto.getBookName());
	User user = userRepository.findByUserId((Integer.parseInt(issueDto.getAuthId())));
//				.orElseThrow(()-> new IllegalStateException("book with name" +issueDto.getBook().getBookName() + "does not exists"));
		if(book == null) {
			throw new RuntimeException("given book is not available");
		}

		
		
			Issue addIssue = new Issue();
			
			addIssue.setIssuedate(new Date());
			
			addIssue.setReturndate(null);
			
			addIssue.setBook(book);
			addIssue.setUser(user);
			
		
			book.setnoOfCopies(book.getnoOfCopies()-1);
			
			 bookRepository.save(book);
			 
			return issueRepository.save(addIssue);
			

			
			
			}
	return issue;
	
	
}



@Transactional
public Issue returnBook( IssueDto issueDto) {
	
	Issue issue = issueConverter.dtoToEntity(issueDto);
	Book book = bookRepository.findByBookName(issueDto.getBookName());
	User user = userRepository.findByUserId((Integer.parseInt(issueDto.getAuthId())));
	String role = authService.authenticate(issueDto.getAuthId(), issueDto.getAuthPassword());
	
	if(role != null &&
			role.equalsIgnoreCase("student")){
		
//		
		if(book == null) {
			throw new RuntimeException("given book is not available");
		}
		 
		Issue removeIssue = new Issue();
		
		
			
			
			removeIssue.setIssuedate(issue.getIssuedate());
			
			removeIssue.setReturndate(new Date());
			
			removeIssue.setBook(book);
			removeIssue.setUser(user);
	
			
			 book.setnoOfCopies(book.getnoOfCopies()+1);
            bookRepository.save(book);
			
            return issueRepository.save(removeIssue);


		}
		
		

	return issue;
	
}


}
