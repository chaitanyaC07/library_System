package library.Dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.entities.Issue;

@Component
public class issueConverter {
	
	@Autowired
	public Issue issue;
	
	
	
	public issueConverter(Issue issue) {
		super();
		this.issue = issue;
	}
	
	public static IssueDto  entityToDto(Issue issue) {
		
		IssueDto  issueDto = new IssueDto();
		
		issueDto.setIssueId(issue.getIssueId());
		issueDto.setIssuedate(issue.getIssuedate());
issueDto.setReturndate(issue.getReturndate());
issueDto.setUser(issue.getUser());
issueDto.setBook(issue.getBook());

issueDto.setAuthId("2");
issueDto.setAuthPassword("1234");

return issueDto;
		
	}
	public List<IssueDto> entityToDto(List<Issue> issue){
		return issue.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public Issue dtoToEntity(IssueDto issueDto) {
		
		issue.setIssueId(issueDto.getIssueId());
		issue.setIssuedate(issueDto.getIssuedate());
		issue.setReturndate(issueDto.getReturndate());
		issue.setUser(issueDto.getUser());
		issue.setBook(issueDto.getBook());
		
		return issue;
		
	}
public List<Issue> dtoToEntity(List<IssueDto> issueDto){
		
		return issueDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	
	}

}
