package library.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import library.entities.User;
import library.entities.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	public AuthService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
//	 @Autowired
//		private  BookService bookService;
	 

	public AuthService() {
		super();
		
	}
	
	
	@Transactional
	public String  authenticate(String authId, String authPassword) throws IllegalStateException, IllegalStateException {
		
		
		User user=  userRepository.findById(Integer.parseInt(authId))
				 .orElseThrow(() -> new IllegalStateException("student with id" + authId+ "does not exists"));
			
	
				 if(authPassword.equals( user.getPassword() )) {
					 
					 System.out.println("your password is correct");
					 
					 return user.getRole(); 
					 
//					 bookService.addBook(null);
//					 bookService.removeBook();
					
					 
					 
					 
				 }else {
					 System.out.println("Enter the right password");
					 return null; 
				 }
				
				
		
		
	}


	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Autowired
//	private BookRepository bookRepository;
//
//	public AuthService(BookRepository bookRepository) {
//		
//		this.bookRepository = bookRepository;
//	}
//	 
//
//	boolean exists =  bookRepository.existbyId(Id);
//	AuthService.authenticate(bookDto.AuthId, bookDto.AuthPassword);
//	
//	if(!exists) {
//		
//	}
}
