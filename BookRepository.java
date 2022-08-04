package library.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import library.Dto.BookDto;

public interface BookRepository extends JpaRepository<Book, Integer> {

//	BookDto save(BookDto bookDto);

	Book findByBookName(String bookName);

}
