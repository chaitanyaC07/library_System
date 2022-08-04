package library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import library.Dto.IssueDto;
import library.Service.IssueService;
import library.entities.Book;
import library.entities.Issue;

@RestController	
public class IssueController {
	
	@Autowired
	private IssueService issueService;

	public IssueController(IssueService issueService) {
		super();
		this.issueService = issueService;
	}
	
	
	@GetMapping("/Issue")
	public List<Book> getStudents(@RequestBody IssueDto issueDto){
		
		return issueService.getBooks(issueDto);
				
				
	}
	
	// Issue Book
	   
	   @DeleteMapping(path = "/Issue")
	   public Issue IssueBook(
			   @RequestBody IssueDto issueDto)  {
		   
		   return issueService.issueBook(issueDto);
		   
	   }
	   
	   // Return book
	   
	   @PostMapping(path = "/Issue")
	   public Issue ReturnBook(
			   @RequestBody IssueDto issueDto) {
		   
		   return issueService.returnBook( issueDto);
	   }
	

}
