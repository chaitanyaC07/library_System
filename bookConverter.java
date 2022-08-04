package library.Dto;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.entities.Book;

@Component
public class bookConverter {
	
	@Autowired
	private Book book;
	
public bookConverter(Book book) {
		
		this.book = book;
	}




public bookConverter() {
	super();
	// TODO Auto-generated constructor stub
}



public static BookDto entityToDto(Book book) {
	
	
	BookDto bookDto  = new BookDto();
	
	bookDto.setBookId(book.getBookid());
	bookDto.setBookName(book.getBookName());
	bookDto.setAuthor(book.getAuthor());
	bookDto.setnoOfCopies(book.getnoOfCopies());
	bookDto.setPublication(book.getPublication());
	bookDto.setSubject(book.getSubject());
	
	
	bookDto.setAuthId("1");
	bookDto.setAuthPassword("1234");

	
	
	return bookDto;
}

public List<BookDto> entityToDto(List<Book> book){
	
	return book.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	
	
}

	
public  Book dtoToEntity(BookDto bookDto) {
	
//	Book book = new Book();
	
	book.setBookid(bookDto.getBookId());
	book.setBookName(bookDto.getBookName());
	book.setAuthor(bookDto.getAuthor());
	book.setnoOfCopies(bookDto.getnoOfCopies());
	book.setPublication(bookDto.getPublication());
	book.setSubject(bookDto.getSubject());
	

	return book;
}

public List<Book> dtoToEntity(List<BookDto> bookDto){
	
	return bookDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	
	
}
	
	

}
