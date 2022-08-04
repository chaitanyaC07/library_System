package library.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import library.Dto.BookDto;
import library.Dto.bookConverter;
import library.Exception.ApiRequestException;
import library.Service.AuthService;
import library.Service.BookService;
import library.Service.IssueService;
import library.entities.Book;

@RestController
public class BookController {
	
@Autowired
	private  BookService bookService;
private  IssueService issueService;
private AuthService authService;

public BookController(BookService bookService, IssueService issueService, AuthService authService) {
	super();
	this.bookService = bookService;
	this.issueService = issueService;
	this.authService = authService;
}

@Autowired
public bookConverter converter;

	
	@PostMapping("/Book")
	public ResponseEntity<Book> AddBooks(@RequestBody BookDto bookDto) {
		
		Book b = null; 
		
		try {
			b = bookService.addBook(bookDto);
			System.out.println(bookDto);
//			return ResponseEntity.status(HttpStatus.CREATED).build();
			return ResponseEntity.of(Optional.of(b));
			 
		}catch(Exception e) {
			e.printStackTrace();
		throw new ApiRequestException("you cannot add the book check the details");
		}
	}

	
	@DeleteMapping(path = "/Book/{bookId}")
	public ResponseEntity<Book> RemoveBooks(
			@PathVariable("bookId") Integer Id,
			@RequestBody BookDto bookDto) {
		
		
		
		try {
			Book book =bookService.removeBook(Id, bookDto);
			return ResponseEntity.of(Optional.of(book));
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new ApiRequestException("you cannot remove the book add the right Id ");
		}
		
//	  return ResponseEntity.of(Optional.of(book));
	}	
	
	@PutMapping(path = "/Book/{bookId}")
	public ResponseEntity<BookDto> updateQuantity(
			@PathVariable("bookId") int Id,
			@RequestBody BookDto bookDto) {
		
		try {
			bookService.updateQuantity(Id , bookDto);
			 bookService.addBook(bookDto);
			return ResponseEntity.ok().body(bookDto);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ApiRequestException("you cannot update the Quantity because your Id is wrong");
			
		}
		  
		  
		  
		
		  
}

//	@ExceptionHandler({NullPointerException.class })
//	 public String exceptionHanderNull(Model m) {
//		m.addAttribute("msg" ,"Null pointer exception");
//		 return "null_page";
//	 }
//	
//	@ExceptionHandler({NullPointerException.class , NumberFormatException.class})
//	 public String exceptionHanderNull() {
//		 return "null_page";
//	 }
//	
//	
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(value = Exception.class)
//	 public String exceptionHanderNulls(Model m) {
//		m.addAttribute("msg ","Exception has occured");
//		 return "null_page";
//	 }
	
	
	
	
	
  
}



//@GetMapping("/test")
//@ResponseBody
//public String test() {
//	
//	Book book = new Book();
//	book.setBookname("Java");
//	book.setCode(213);
//	book.setAuthor("steve");
//	book.setSubject("java");
//	book.setNoOfCopies(2);
//	book.setPublication("N.D");
//	
//	
//	
//	userRepository.save(book);
//	return "working ";
//}



//@PostMapping("/User")
//
//public Issue  Add(@RequestBody Issue issue ) {
//	
//	System.out.println(issue);
//	try {
//	return issueRepository.save(issue);
//	}catch(Exception e) {
////		System.out.println();
//		e.printStackTrace();
//	}
//	
//	return null;
////	return this.userservice.addUser(issue);
//	
//}