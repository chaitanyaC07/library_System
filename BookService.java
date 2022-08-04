package library.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.Dto.BookDto;
import library.Dto.bookConverter;
import library.entities.Book;
import library.entities.BookRepository;

@Service
public class BookService {
	
	
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthService authService;
	@Autowired
	private bookConverter bookConverter;
	
	

	public BookService() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public BookService(BookRepository bookRepository, AuthService authService , bookConverter bookConverter) {
		super();
		this.bookRepository = bookRepository;
		this.authService = authService;
		this.bookConverter = bookConverter;
		
	}



// -Save the book 
	public Book addBook(BookDto bookDto) {
		
//		Book book = bookConverter.dtoToEntity(bookDto);
		
		Book book = bookConverter.dtoToEntity(bookDto);

		
	String role = 	authService.authenticate(bookDto.getAuthId(), bookDto.getAuthPassword());
		
	
if(role!= null && role.equalsIgnoreCase("admin") ) {
	
	return bookRepository.save(book);
}else {
	throw new RuntimeException("not allow");
}
			
	}
	

// Delete book 

	public Book removeBook(int Id ,BookDto bookDto) {
		
	Book book = bookConverter.dtoToEntity(bookDto);
	String role = authService.authenticate(bookDto.getAuthId(), bookDto.getAuthPassword());
	
	try {
		
	
	if(role != null && role.equalsIgnoreCase("admin")) {
		boolean exists = bookRepository.existsById(Id);
		
	if(!exists) {
		throw new IllegalStateException(
				"Book with id "+Id+ "does not exists");
	}else {
	   bookRepository.deleteById(Id);
	}
	
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return book;
	
	
		
	
		
	}



@Transactional
	public Book updateQuantity(int Id , BookDto bookDto ) {
	
	
	Book book = bookConverter.dtoToEntity(bookDto);
	String role = authService.authenticate(bookDto.getAuthId() , bookDto.getAuthPassword());
	
		if(role != null && 
				role.equalsIgnoreCase("admin")) {
			
		
	               book =  bookRepository.findById(Id)
			          .orElseThrow(() -> new IllegalStateException("student with id" + Id+ "does not exists"));
		
	               
			 if(bookDto.getnoOfCopies() != 0 )  {
				 
				 book.setnoOfCopies(bookDto.getnoOfCopies());
				 

			 }
			 return bookRepository.save(book); 
		}else
		{
			throw new RuntimeException("not allow ");
			
		}
			
//		return bookRepository.save(book);
		
	}




//public Book issueBook(int id, BookDto bookDto) {
//	
//	
//	Book book = bookConverter.dtoToEntity(bookDto);
//	String role = authService.authenticate(bookDto.getAuthId() , bookDto.getAuthPassword());
//	
//	if(role != null && role.equalsIgnoreCase("student")) {
//		
//		book = bookRepository.findById(id)
//				.orElseThrow(()-> new IllegalStateException("book with id" + id + "does not exists"));
//		
//		if(bookDto.getBookName() != null &&
//				bookDto.getBookName().length() > 0
//				)  {
//			if(bookDto.getnoOfCopies() >0) {
//				bookRepository.deleteById(id);
//				return book;
////				bookDto.getnoOfCopies().
//				
//			}else {
//				throw new RuntimeException("not allow");
//			}
//			
//			
//			
//		}
//		
//		
//		
//	}
//	
//	return null;
//}
	
	
	
	
	
	

}
